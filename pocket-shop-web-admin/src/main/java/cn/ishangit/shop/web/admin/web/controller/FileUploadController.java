package cn.ishangit.shop.web.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Chen
 * @create 2019-05-24 16:01
 * 文件上传控制器
 */
@Controller
public class FileUploadController {
    public static final  String UPLOAD_DIC = "/static/upload";

    @ResponseBody
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public Map<String,Object> upload(MultipartFile dropzFile, HttpServletRequest request){
        Map<String,Object> res = new HashMap<String, Object>();
        //获取文件名
        String fileName = dropzFile.getOriginalFilename();
        //获取文件后缀名
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_DIC);
        File file = new File(filePath);
        //如果文件不存在，创建文件夹
        if (!file.exists()){
            file.mkdir();
        }
        //写入文件
         file = new File(filePath, UUID.randomUUID()+fileSuffix);
        try {
            dropzFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        res.put("fileName",UPLOAD_DIC+file.getName());
        return res;
    }

}

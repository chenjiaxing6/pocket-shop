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
    public static final String UPLOAD_DIC = "/static/upload";

    /**
     * 文件上传
     *
     * @param dropzFile                   ：dropzone上传的文件
     * @param editorFiles：wangEditor上传的文件
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public Map<String, Object> upload(MultipartFile dropzFile, MultipartFile[] editorFiles, HttpServletRequest request) {
        Map<String, Object> res = new HashMap<String, Object>();
        MultipartFile myfile = null;
        //如果dropFile不为空  则为dropzone上传的文件
        if (dropzFile != null) {
            myfile = dropzFile;
            String fileName = writeFile(myfile, request);
            res.put("fileName", UPLOAD_DIC + fileName);
            return res;
        }

        //wangEditor上传
        else {
            /**
             * getScheme:服务端提供的协议  http/https
             * getServerName:：服务器名称
             * getServerPort:服务器端口
             */
            String serverPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
            String[] stringData = new String[100];
            int i = 0;
            for (MultipartFile editorFile : editorFiles) {
                String fileName = writeFile(editorFile, request);
                stringData[i] = serverPath + UPLOAD_DIC + "/" + fileName;
                i++;
            }
            res.put("errno", 0);
            res.put("data", stringData);
            return res;
        }
    }

    /**
     * 把文件写入
     *
     * @param myfile
     */
    private String writeFile(MultipartFile myfile, HttpServletRequest request) {
        //获取文件名
        String fileName = myfile.getOriginalFilename();
        //获取文件后缀名
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_DIC);
        File file = new File(filePath);
        //如果文件不存在，创建文件夹
        if (!file.exists()) {
            file.mkdir();
        }
        //写入文件
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            myfile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getName();

    }

}

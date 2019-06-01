package cn.ishangit.shop.commons.constant;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;

/**
 * @description:HttpClient工具类
 * @author: Chen
 * @create: 2019-05-31 15:29
 **/
public class HttpClientUtils {

    public static final  String Get = "get";
    public static final  String Post = "post";
    public static final  String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final  String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36";
    /**
     * Get请求
     * @return
     */
    public static String doGet(String url){
        return createReqest(url,Get,null,null);
    }

    /**
     * 带Cookie的Get请求
     * @param url
     * @param cookie
     * @return
     */
    public static String doGet(String url,String cookie){
        return createReqest(url,Get,cookie,null,null);
    }

    /**
     * Post请求
     * @return
     */
    public static String doPost(String url,BasicNameValuePair...params){
        return createReqest(url,Post,null,params);
    }

    /**
     * 带Cookie的Post请求
     * @param url
     * @param cookie
     * @param params
     * @return
     */
    public static String doPost(String url,String cookie,BasicNameValuePair...params){
        return createReqest(url,Post,cookie,params);
    }

    /**
     * 创建请求
     * @param url 请求地址
     * @param RequestMethod 请求方法 Get Post
     * @param cookie Cookie信息
     * @param params 参数列表
     * @return
     */
    public static String createReqest(String url, String RequestMethod, String cookie, BasicNameValuePair...params){
        //创建一个HttpClient客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //请求结果
        String result = null;
        //请求方式
        HttpGet httpGet = null;
        HttpPost httpPost = null;

        //响应
        CloseableHttpResponse response = null;
        try {
            //如果是Get请求
            if(Get.equals(RequestMethod)){
                httpGet = new HttpGet(url);
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpGet.setHeader("Cookie", cookie);
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);

                response = httpClient.execute(httpGet);
            }
            //如果是Post请求
            else  if(Post.equals(RequestMethod)){
                httpPost = new HttpPost(url);
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("Cookie", cookie);
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                //如果有参数
                if (params != null && params.length>0){
                    httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(params),"utf-8"));
                }
                response = httpClient.execute(httpPost);
            }
            //获取响应内容
            HttpEntity httpEntity = response.getEntity();
            result = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

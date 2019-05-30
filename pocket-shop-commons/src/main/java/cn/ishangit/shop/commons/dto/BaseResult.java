package cn.ishangit.shop.commons.dto;

import java.io.Serializable;

/**
 * @author Chen
 * @create 2019-05-17 16:30
 * 数据传输对象
 * 自定义返回结果
 */
public class BaseResult implements Serializable {
    public static final  int STATUS_SUCCESS = 200;
    public static final  int STATUS_FAIL = 500;
    private int status;
    private String message;
    private Object data;

    public static BaseResult success(){
        return createBaseResult(STATUS_SUCCESS,"成功",null);
    }

    public static  BaseResult fail(){
        return  createBaseResult(STATUS_FAIL,"错误",null);
    }

    public static BaseResult success(String message){
        return createBaseResult(STATUS_SUCCESS,message,null);
    }

    public static BaseResult success(String message,Object data){
        return createBaseResult(STATUS_SUCCESS,message,data);
    }

    public static  BaseResult fail(String message){
        return  createBaseResult(STATUS_FAIL,message,null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 用于创建返回结果
     * @param status
     * @param message
     * @return
     */
    private static BaseResult createBaseResult(int status,String message,Object data){
        BaseResult baseResult = new BaseResult() ;
        baseResult.setMessage(message);
        baseResult.setStatus(status);
        baseResult.setData(data);
        return baseResult;
    }
}

package com.murphy.gee.common.entity;

/**
 * @ClassName JsonResult
 * @Description Http返回格式
 * @Author Murphy.Gee
 * @Date 2019-07-26 15:26
 * @Version 1.0
 **/
public class JsonResult<T> {

    public int code;

    private String msg;

    private T data;

    private final static String SUCCESS = "success";


    /*
     * @description: 成功的构造函数
     * @param data
     * @return:
     * @author: Murphy.Gee
     * @date: 2019-07-26 15:42
     */
    public JsonResult(T data){
        this.code = 200;
        this.msg = SUCCESS;
        this.data = data;
    }

    /*
     * @description: 默认的构造函数
     * @param code
     * @param msg
     * @return:
     * @author: Murphy.Gee
     * @date: 2019-07-26 15:42
     */
    public JsonResult(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public JsonResult(){

    }

    /*
     * @description: 失败的构造函数
     * @param murphyResponseCode
     * @return:
     * @author: Murphy.Gee
     * @date: 2019-07-26 15:47
     */
    public JsonResult(MurphyResponseCode murphyResponseCode){
        this.code = murphyResponseCode.code;
        this.msg = murphyResponseCode.name();
    }

    public JsonResult<T> setCode(MurphyResponseCode murphyResponseCode){
        this.code = murphyResponseCode.code;
        return this;
    }

    public int getCode(){
        return code;
    }

    public JsonResult<T> setCode(int code){
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public JsonResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public JsonResult<T> setData(T data) {
        this.data = data;
        return this;
    }
    /*
     * @description: 调用成功
     * @param data
     * @return: com.murphy.gee.common.entity.JsonResult<T>
     * @author: Murphy.Gee
     * @date: 2019-07-26 15:48
     */
    public static <T> JsonResult<T> success(T data){
        return new JsonResult<T>(data);
    }

    public static JsonResult success(){
        return new JsonResult().setMsg("操作成功").setCode(200);
    }
    /*
     * @description: 失败时调用
     * @param murphyResponseCode
     * @return: com.murphy.gee.common.entity.JsonResult<T>
     * @author: Murphy.Gee
     * @date: 2019-07-26 15:49
     */
    public static <T> JsonResult<T> fail(MurphyResponseCode murphyResponseCode){
        return new JsonResult<T>(murphyResponseCode);
    }
}

package com.hull.common;

/**
 * 接口统一返回的消息体
 *
 * @author
 * @create 2018-04-05 上午5:45
 **/

public class RespDto<T> extends BaseEntity {
    public static final String SUCCESS = "0000";
    public static final String ERROR = "0001";

    private String resultCode;
    private String resultMsg;
    private T data;

    public static <T> RespDto<T> success(){
        RespDto respDto = new RespDto();
        respDto.setResultCode(SUCCESS);
        respDto.setResultMsg("success");
        return respDto;
    }

    public static <T> RespDto<T> success(T data){
        RespDto respDto = new RespDto();
        respDto.setData(data);
        respDto.setResultCode(SUCCESS);
        respDto.setResultMsg("success");
        return respDto;
    }

    public static <T> RespDto<T> error(String msg){
        RespDto respDto = new RespDto();
        respDto.setResultCode(ERROR);
        respDto.setResultMsg(msg);
        return respDto;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

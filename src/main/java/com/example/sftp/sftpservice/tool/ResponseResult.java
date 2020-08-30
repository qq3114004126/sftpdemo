package com.example.sftp.sftpservice.tool;

public class ResponseResult {

    /**
     * 状态码.
     */
    private String code;
    /**
     * 返回信息.
     */
    private String msg;
    /**
     * 接口返回数据.
     */
    private Object data;

    /**
     * getCode.
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * setCode.
     * @param code1 String
     */
    public void setCode(final String code1) {
        this.code = code1;
    }

    /**
     * getMsg.
     * @return String
     */
    public String getMsg() {
        return msg;
    }

    /**
     * setMsg.
     * @param msg1 String
     */
    public void setMsg(final String msg1) {
        this.msg = msg1;
    }

    /**
     * getData.
     * @return Object
     */
    public Object getData() {
        return data;
    }

    /**
     * setData.
     * @param data1 Object
     */
    public void setData(final Object data1) {
        this.data = data1;
    }

    /**
     * ResponseResult.
     * @param code1 String
     * @param msg1 String
     * @param data1 Object
     */
    public ResponseResult(final String code1, final String msg1, final Object data1) {
        this.code = code1;
        this.msg = msg1;
        this.data = data1;
    }

    /**
     * error.
     * @Title: success @Description: 失败统一返回0
     * @param errorMessage 错误信息
     * @return ResponseResult
     */
    public static ResponseResult error(final String errorMessage) {
        return new ResponseResult("0", errorMessage, null);
    }

    /**
     * success.
     * @Title: success
     * @Description: 成功统一返回1
     * @param data 数据
     * @param messgae 消息
     * @return ResponseResult
     */
    public static ResponseResult success(final String messgae, final Object data) {
        return new ResponseResult("1", messgae, data);
    }

    /**
     * success.
     * @return @Description: 成功统一返回1
     */
    public static ResponseResult success() {
        return ResponseResult.
                success(null, null);
    }

    /**
     * success.
     * @param data object
     * @return @Description: 成功统一返回1和返回结果
     */
    public static ResponseResult success(final Object data) {
        return ResponseResult.success(null, data);
    }
}

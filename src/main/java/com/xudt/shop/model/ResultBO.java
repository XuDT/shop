package com.xudt.shop.model;

import com.xudt.shop.utils.constants.Constants;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 结果类
 */
public class ResultBO<T> {

    /**
     * 状态码,200表示成功，1表示失败
     */
    private String code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 是否成功，true表示成功，false表示失败
     */
    private boolean success;

    public static ResultBO success(){
        ResultBO result = new ResultBO();
        result.setCode(Constants.SUCCESS_CODE);
        result.setMsg(Constants.SUCCESS_MSG);
        result.setSuccess(true);
        return result;
    }

    public static ResultBO error(){
        ResultBO result = new ResultBO();
        result.setCode(Constants.ERROR_CODE);
        result.setMsg(Constants.ERROR_MSG);
        result.setSuccess(false);
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
package com.xudt.shop.utils;

import com.xudt.shop.model.ResultBO;
import com.xudt.shop.utils.constants.Constants;

/**
 * @author: dantong.xu
 * @date: 2018/10/26
 * @describe: 返回结果
 */
public class ResultUtils {
    /**
     * 返回成功
     * @return Object
     */
    public static Object getSucess(){
        ResultBO result = new ResultBO();
        result.setSuccess(true);
        result.setMsg(Constants.SUCCESS_MSG);
        result.setData(null);
        return result;
    }

    /**
     * 返回成功
     * @param obj
     * @return Object
     */
    public static Object getSucess(Object obj){
        return getSucess(obj, Constants.SUCCESS_MSG);
    }

    /**
     * 返回成功
     * @param obj
     * @param msg
     * @return Object
     */
    public static Object getSucess(Object obj, String msg){
        ResultBO result = new ResultBO();
        result.setSuccess(true);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }


    /**
     * 返回错误
     * @return Object
     */
    public static Object getError(){
        ResultBO result = new ResultBO();
        result.setSuccess(false);
        result.setMsg(Constants.ERROR_MSG);
        result.setData(null);
        return result;
    }

    /**
     * 返回错误
     * @param obj
     * @return Object
     */
    public static Object getError(Object obj){
        return getError(obj, Constants.ERROR_MSG);
    }

    /**
     * 返回错误
     * @param obj
     * @param msg
     * @return Object
     */
    public static Object getError(Object obj, String msg){
        ResultBO result = new ResultBO();
        result.setSuccess(false);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }
}

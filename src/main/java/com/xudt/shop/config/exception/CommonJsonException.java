package com.xudt.shop.config.exception;

import com.alibaba.fastjson.JSONObject;
import com.xudt.shop.utils.enums.ErrorEnum;

import static com.xudt.shop.utils.ResultUtils.getError;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 自定义错误类，拦截器可以统一拦截此错误
 */
public class CommonJsonException extends RuntimeException {
    private Object resultJson;

    public CommonJsonException(ErrorEnum errorEnum) {
        this.resultJson = getError(errorEnum);
    }

    public CommonJsonException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }

    public Object getResultJson() {
        return resultJson;
    }
}

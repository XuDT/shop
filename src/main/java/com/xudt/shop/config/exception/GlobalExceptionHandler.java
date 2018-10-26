package com.xudt.shop.config.exception;

import com.alibaba.fastjson.JSONObject;
import com.xudt.shop.utils.enums.ErrorEnum;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.xudt.shop.utils.ResultUtils.getError;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 统一异常拦截
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger("GlobalExceptionHandler");

    /**
     * @param request
     * @param e
     * @return JSONObject
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public JSONObject defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        String errorPosition = "";
        //如果错误堆栈信息存在
        if (e.getStackTrace().length > 0) {
            StackTraceElement element = e.getStackTrace()[0];
            String fileName = element.getFileName() == null ? "未找到错误文件" : element.getFileName();
            int lineNumber = element.getLineNumber();
            errorPosition = fileName + ":" + lineNumber;
        }
        //返回错误状态码和错误信息
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("returnCode", ErrorEnum.E_400.getErrorCode());
        jsonObject.put("returnMsg", ErrorEnum.E_400.getErrorMsg());
        JSONObject errorObject = new JSONObject();
        errorObject.put("errorLocation", e.toString() + "    错误位置:" + errorPosition);
        jsonObject.put("returnData", errorObject);
        logger.error("异常", e);
        return jsonObject;
    }

    /**
     * GET/POST请求方法错误拦截器
     * @return Object
     * @throws Exception
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object httpRequestMethodHandler() throws Exception {
        //返回错误信息
        return getError(ErrorEnum.E_500.getErrorMsg());
    }

    /**
     * 自定义错误的拦截器，拦截到错误之后, 就返回这个类里面的json给前端
     * 常见使用场景是参数校验失败,抛出此错,返回错误信息给前端
     * @param commonJsonException
     * @return Object
     * @throws Exception
     */
    @ExceptionHandler(CommonJsonException.class)
    public Object commonJsonExceptionHandler(CommonJsonException commonJsonException) throws Exception {
        return commonJsonException.getResultJson();
    }

    /**
     * 权限不足报错拦截
     * @return Object
     * @throws Exception
     */
    @ExceptionHandler(UnauthorizedException.class)
    public Object unauthorizedExceptionHandler() throws Exception {
        return getError(ErrorEnum.E_502.getErrorMsg());
    }

    /**
     * 未登录报错拦截
     * @return Object
     * @throws Exception
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public Object unauthenticatedException() throws Exception {
        //返回错误信息
        return getError(ErrorEnum.E_20011.getErrorMsg());
    }
}

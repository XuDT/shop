package com.xudt.shop.utils.enums;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 图片上传异常信息枚举类
 */
public enum ImgErrorEnum {
    //异常信息
    SUCCESS("200", "操作成功"),
    ERROR("201", "网络异常，请稍后重试"),
    FILE_UPLOAD_ERROR("1002","图片上传异常"),
    FILE_UPLOAD_NULL("1003","图片为空");

    /**
     * 状态码
     */
    private String code;
    /**
     * 信息
     */
    private String message;

    ImgErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
            return this.code;
        }


}
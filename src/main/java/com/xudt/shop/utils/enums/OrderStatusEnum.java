package com.xudt.shop.utils.enums;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 订单状态枚举类
 */
public enum OrderStatusEnum {
    /**
     * 订单状态
     */
    NEW(0,"已新建"),
    COMPLETE(1,"已付款");

    private int code;
    private String message;

    OrderStatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.xudt.shop.utils.constants;

import java.util.Date;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 生成订单号
 */
public class GenerateOrderId {
    public static String getOrderId(int type){
        //当前时间的唯一编号
        long time=new Date().getTime();
        String orderId = String.valueOf(type) + time;
        return orderId;
    }
}

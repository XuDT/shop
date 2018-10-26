package com.xudt.shop.utils;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 字符串工具类
 */
public class StringTools {

    /**
     * 字符串判空
     * @param str
     * @return boolean
     */
    public static boolean isNullOrEmpty(String str) {
        return null == str || "".equals(str) || "null".equals(str);
    }

    public static boolean isNullOrEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }
}

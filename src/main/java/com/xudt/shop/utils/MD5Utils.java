package com.xudt.shop.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: MD5工具类
 */
public class MD5Utils {

    private static final String salt = "pass8866";

    /**
     * 对字符串进行Md5加密
     * @param input
     * @return String
     */
    public static String md5(String input) {
        byte[] code = null;
        try {
            code = MessageDigest.getInstance("md5").digest(input.getBytes());
        } catch (NoSuchAlgorithmException e) {
            code = input.getBytes();
        }
        BigInteger bi = new BigInteger(code);
        return bi.abs().toString(32).toUpperCase();
    }

    /**
     * 生成Md5加密密码
     * @param input
     * @return String
     */
    public static String generatePasswordMD5(String input) {
        return md5(salt + md5(input));
    }
}

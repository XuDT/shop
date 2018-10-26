package com.xudt.shop.service;

import com.xudt.shop.model.UserDTO;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 登录
 */
public interface LoginService {
    /**
     * 登录表单提交
     * @param user
     * @return Object
     */
    public Object authLogin(UserDTO user);

    /**
     * 查询当前登录用户的权限等信息
     * @return Object
     */
    public Object getInfo();

    /**
     * 退出登录
     * @return Object
     */
    public Object logout();
}

package com.xudt.shop.service.impl;

import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.LoginService;
import com.xudt.shop.utils.MD5Utils;
import com.xudt.shop.utils.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.xudt.shop.utils.ResultUtils.getError;
import static com.xudt.shop.utils.ResultUtils.getSucess;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 用户登录
 */
@Service
public class LoginServiceImpl implements LoginService {
    private Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    /**
     * 登录表单提交
     * @param user
     * @return Object
     */
    @Override
    public Object authLogin(UserDTO user) {
        //获取用户名和密码
        String username = user.getUsername();
        String password = MD5Utils.generatePasswordMD5( user.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            //登录
            currentUser.login(token);
            return getSucess();
        } catch (AuthenticationException e) {
            return getError("用户名或者密码错误！");
        }
    }

    /**
     * 查询当前登录用户的权限等信息
     * @return Object
     */
    @Override
    public Object getInfo() {
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        UserDTO userInfo = (UserDTO) session.getAttribute(Constants.SESSION_USER_INFO);
        return getSucess(userInfo);
    }

    /**
     * 退出登录
     * @return Object
     */
    @Override
    public Object logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            //退出登录
            currentUser.logout();
            return getSucess();
        } catch (Exception e) {
            return null;
        }
    }
}

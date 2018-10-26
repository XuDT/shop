package com.xudt.shop.controller;

import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.LoginService;
import com.xudt.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.xudt.shop.utils.ResultUtils.getError;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 用户登录
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    /**
     * 转入登录页面
     * @return String
     */
    @RequestMapping(value="/login")
    public String login(String role){
        if("user".equals(role)){
            return "user_login";
        }
        return "admin_login";
    }

    /**
     * 验证账号与密码
     * @param user
     * @return Object
     */
    @RequestMapping(value="/auth")
    @ResponseBody
    public Object authLogin(UserDTO user) {
        try {
            if(userService.queryExistUsername(user.getUsername())!=null){
                return loginService.authLogin(user);
            }else{
                return getError("该用户还未注册!");
            }
        } catch (Exception e) {
            return getError("登录失败!");
        }
    }

    /**
     * 退出登录
     * @return Object
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Object logout() {
        return loginService.logout();
    }

}

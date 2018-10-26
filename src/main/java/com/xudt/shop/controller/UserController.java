package com.xudt.shop.controller;

import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.UserService;
import com.xudt.shop.utils.MD5Utils;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import static com.xudt.shop.utils.ResultUtils.getError;
import static com.xudt.shop.utils.ResultUtils.getSucess;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 用户注册
 */
@Api(description = "用户注册")
@Controller
@RequestMapping("/user")
public class UserController{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return Object
     */
    @RequestMapping(value="/registered")
    @ResponseBody
    public Object registered(UserDTO user){
        try {
            //判断用户名是否重复
            if (userService.queryExistUsername(user.getUsername())!=null){
                return getError("用户名重复，请重新输入!");
            }else{
                user.setPassword(MD5Utils.generatePasswordMD5(user.getPassword()));
                user.setCreatetime(new Date());
                user.setUpdatetime(new Date());
                userService.addUser(user);
                Subject currentUser = SecurityUtils.getSubject();
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
                currentUser.login(token);
                return getSucess();
            }
        } catch (Exception e){
            LOGGER.error("运行错误!");
            return getError("注册失败，请重试!");
        }
    }
    /**
     * 查询用户个人资料
     * @return
     */
    @RequestMapping(value = "userInfo")
    public ModelAndView userInfo(Integer id){
        ModelAndView model = new ModelAndView("user/user_info");
        if (id != null){
            UserDTO userInfoList = userService.findUserInfo(id);
            model.addObject("userInfoList",userInfoList);
        }
        return model;
    }

}

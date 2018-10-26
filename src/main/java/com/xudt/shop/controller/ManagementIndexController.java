package com.xudt.shop.controller;

import com.xudt.shop.model.MenuDTO;
import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.MenuService;
import com.xudt.shop.utils.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 后台管理首页
 */
@Controller
public class ManagementIndexController {
    @Autowired
    private MenuService menuService;

    /**
     * 后台管理首页
     * @return ModelAndView
     */
    @RequestMapping(value = "index")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("/management_index");
        //获取一级菜单
        List<MenuDTO> menuList = menuService.findParentsMenu(null);
        for (MenuDTO menu : menuList) {
            menu.setChildmenu(menuService.findChildMenuByPid(menu.getId()));
        }
        //获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        UserDTO userInfo = (UserDTO) session.getAttribute(Constants.SESSION_USER_INFO);
        model.addObject("menuList", menuList);
        model.addObject("userInfo",userInfo);
        return model;
    }
}
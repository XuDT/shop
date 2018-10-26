package com.xudt.shop.controller;

import com.xudt.shop.model.MenuDTO;
import com.xudt.shop.service.MenuService;
import com.xudt.shop.utils.StringTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.xudt.shop.utils.ResultUtils.getError;
import static com.xudt.shop.utils.ResultUtils.getSucess;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 菜单管理
 */
@Controller
@RequestMapping("/menu")
@ResponseBody
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 查询菜单列表
     * @param keyword
     * @return ModelAndView
     */
    @RequestMapping(value = "menuList", method = RequestMethod.GET)
    public ModelAndView index(String keyword) {
        ModelAndView model = new ModelAndView("menu/menu_list");
        model.addObject("menulist",menuService.findMenuList(keyword));
        model.addObject("keyword",keyword);
        return model;
    }

    /**
     * 修改菜单
     * @param id
     * @return ModelAndView
     */
    @RequestMapping(value = "editMenu", method = RequestMethod.GET)
    public ModelAndView editMenu(Integer id) {
        ModelAndView model = new ModelAndView("menu/menu_edit");
        if (id != null) {
            MenuDTO menuRecord = menuService.findMenuById(id);
            model.addObject("menuRecord", menuRecord);
        }
        List<MenuDTO> parentsMenu = menuService.findParentsMenu(id);
        model.addObject("parentsMenu", parentsMenu);
        return model;
    }

    /**
     * 保存
     * @param menu
     * @return Object
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public Object save(MenuDTO menu) {
        try {
            if (menu.getId() != null){
                menuService.updateMenuById(menu);
            }else{
                menuService.insertMenu(menu);
            }
            return getSucess();
        } catch (Exception e) {
            return getError();
        }
    }

    /**
     * 检测菜单编码是否重复
     * @param code
     * @param id
     * @return Object
     */
    @RequestMapping(value = "checkCode",method = RequestMethod.POST)
    public Object checkCode(String code, Integer id) {
        MenuDTO menu = new MenuDTO();
        if(StringTools.isNullOrEmpty(code)){
            return getError();
        }else{
            menu.setCode(code);
            menu.setId(id);
            if (menuService.checkCode(menu) != null) {
                return getSucess();
            } else {
                return getError();
            }
        }
    }

    /**
     * 根据id删除菜单
     * @param id
     * @return Object
     */
    @RequestMapping(value = "deleteById", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteById(Integer id){
        try{
            if(id != null){
                menuService.deleteById(id);
            }
            return getSucess();
        }catch (Exception e){
            return getError();
        }
    }
}

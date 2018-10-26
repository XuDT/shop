package com.xudt.shop.service.impl;


import com.xudt.shop.dao.MenuDao;
import com.xudt.shop.model.MenuDTO;
import com.xudt.shop.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 菜单管理
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    /**
     * 新增菜单
     * @param menu
     */
    @Override
    public void insertMenu(MenuDTO menu) {
         menuDao.insertMenu(menu);
    }

    /**
     * 获取菜单列表
     * @param keyword
     * @return List<MenuDTO>
     */
    @Override
    public List<MenuDTO> findMenuList(String keyword) {
        return menuDao.findMenuList(keyword);
    }

    /**
     * 根据id获取菜单
     * @param id
     * @return MenuDTO
     */
    @Override
    public MenuDTO findMenuById(Integer id) {
        return menuDao.findMenuById(id);
    }

    /**
     * 查询父级菜单
     * @param id
     * @return List<MenuDTO>
     */
    @Override
    public List<MenuDTO> findParentsMenu(Integer id) {
        return menuDao.findParentsMenu(id);
    }

    /**
     * 根据id查询子菜单
     * @param id
     * @return List<MenuDTO>
     */
    @Override
    public List<MenuDTO> findChildMenuByPid(Integer id) {
        return menuDao.findChildMenuByPid(id);
    }

    /**
     * 根据id修改菜单
     * @param menu
     */
    @Override
    public void updateMenuById(MenuDTO menu) {
        menuDao.updateMenuById(menu);
    }

    /**
     * 检测菜单编码是否重复
     * @param menu
     * @return MenuDTO
     */
    @Override
    public MenuDTO checkCode(MenuDTO menu) {
        return menuDao.checkCode(menu);
    }

    /**
     * 根据id删除菜单
     * @param id
     */
    public void deleteById(Integer id){
        menuDao.deleteById(id);
    }
}

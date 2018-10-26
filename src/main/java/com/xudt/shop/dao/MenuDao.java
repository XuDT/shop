package com.xudt.shop.dao;

import com.xudt.shop.model.MenuDTO;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 菜单管理
 */
public interface MenuDao {

    /**
     * 获取菜单列表
     * @param keyword
     * @return List<MenuDTO>
     */
    public List<MenuDTO> findMenuList(String keyword);

    /**
     * 新增菜单
     * @param menu
     */
    public void insertMenu(MenuDTO menu);

    /**
     * 根据Id查询记录
     * @param id
     * @return MenuDTO
     */
    public MenuDTO findMenuById(Integer id);

    /**
     * 查询父级菜单
     * @param id
     * @return List<MenuDTO>
     */
    public List<MenuDTO> findParentsMenu(Integer id);

    /**
     * 查询子级菜单
     * @param id
     * @return List<MenuDTO>
     */
    public List<MenuDTO> findChildMenuByPid(Integer id);

    /**
     * 根据id修改菜单
     * @param menu
     */
    public void updateMenuById(MenuDTO menu);

    /**
     * 检测code是否重复
     * @param menu
     * @return MenuDTO
     */
    public MenuDTO checkCode(MenuDTO menu);

    /**
     * 根据id删除菜单
     * @param id
     */
    public void deleteById(Integer id);
}

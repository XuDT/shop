package com.xudt.shop.model;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 菜单实体类
 */
public class MenuDTO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 级别
     */
    private int level;

    /**
     * 父级id
     */
    private long pid;

    /**
     * 路径
     */
    private String path;

    /**
     * 代码
     */
    private String code;

    /**
     * 父级名称
     */
    private String parentName;

    /**
     * 子菜单
     */
    private List<MenuDTO> childmenu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<MenuDTO> getChildmenu() {
        return childmenu;
    }

    public void setChildmenu(List<MenuDTO> childmenu) {
        this.childmenu = childmenu;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}

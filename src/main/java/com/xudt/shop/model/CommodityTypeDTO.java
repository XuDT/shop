package com.xudt.shop.model;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 商品类型实体类
 */
public class CommodityTypeDTO {
    /**
     * 商品类型id
     */
    private Integer id;

    /**
     * 商品类型代码
     */
    private String code;

    /**
     * 商品类型名称
     */
    private String name;

    /**
     * 二级菜单
     */
    private List<CommodityDTO> childCommodity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CommodityDTO> getChildCommodity() {
        return childCommodity;
    }

    public void setChildCommodity(List<CommodityDTO> childCommodity) {
        this.childCommodity = childCommodity;
    }
}

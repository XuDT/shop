package com.xudt.shop.dao;

import com.xudt.shop.model.CommodityDTO;
import com.xudt.shop.model.CommodityTypeDTO;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 商品管理
 */
public interface CommodityDao {

    /**
     * 获取全部商品
     * @return List<CommodityDTO>
     */
    public List<CommodityDTO> findAll();

    /**
     * 新增商品
     * @param commodity
     */
    public void insertCommodity(CommodityDTO commodity);

    /**
     * 修改商品
     * @param commodity
     */
    public void updateCommodity(CommodityDTO commodity);

    /**
     * 根据id获取商品
     * @param id
     * @return CommodityDTO
     */
    public CommodityDTO findById(Integer id);

    /**
     * 根据id删除商品
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 根据名称搜索商品
     * @param keyword
     * @return List<CommodityDTO>
     */
    public List<CommodityDTO> findByKeyword(String keyword);

    /**
     * 查询商品一级分类
     * @return List<CommodityTypeDTO>
     */
    public List<CommodityTypeDTO> findParentCommodity();

    /**
     * 查询商品二级分类
     * @param type
     * @return List<CommodityDTO>
     */
    public List<CommodityDTO> findChildCommodity(Integer type);

}

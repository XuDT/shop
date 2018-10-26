package com.xudt.shop.service.impl;

import com.xudt.shop.dao.CommodityDao;
import com.xudt.shop.model.CommodityDTO;
import com.xudt.shop.model.CommodityTypeDTO;
import com.xudt.shop.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 商品管理
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;

    /**
     * 获取全部商品
     * @return List<CommodityDTO>
     */
    public List<CommodityDTO> findAll(){
        return commodityDao.findAll();
    }

    /**
     * 新增商品
     * @param commodity
     */
    public void insertCommodity(CommodityDTO commodity){
        commodityDao.insertCommodity(commodity);
    }

    /**
     * 修改商品
     * @param commodity
     */
    public void updateCommodity(CommodityDTO commodity){
        commodityDao.updateCommodity(commodity);
    }

    /**
     * 根据id获取商品
     * @param id
     * @return CommodityDTO
     */
    public CommodityDTO findById(Integer id){
        return commodityDao.findById(id);
    }

    /**
     * 根据id删除商品
     * @param id
     */
    public void deleteById(Integer id){
        commodityDao.deleteById(id);
    }

    /**
     * 根据名称搜索商品
     * @param keyword
     * @return List<CommodityDTO>
     */
    public List<CommodityDTO> findByKeyword(String keyword) {
        return commodityDao.findByKeyword(keyword);
    }

    /**
     * 查询商品一级分类
     * @return
     */
    public List<CommodityTypeDTO> findParentCommodity(){
        return commodityDao.findParentCommodity();
    }

    /**
     * 查询商品二级分类
     * @param type
     * @return
     */
    public List<CommodityDTO> findChildCommodity(Integer type){
        return commodityDao.findChildCommodity(type);
    }

    /**
     * 商品分类列表
     * @param commodityTypeList
     * @return List<CommodityTypeDTO>
     */
    public List<CommodityTypeDTO> findCommodityClassify(List<CommodityTypeDTO> commodityTypeList){
        for (CommodityTypeDTO commodityTypeDTO : commodityTypeList) {
            commodityTypeDTO.setChildCommodity(commodityDao.findChildCommodity(commodityTypeDTO.getId()));
        }
        return commodityTypeList;
    }

}

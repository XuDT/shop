package com.xudt.shop.controller;

import com.xudt.shop.model.CommodityDTO;
import com.xudt.shop.model.CommodityTypeDTO;
import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.CommodityService;
import com.xudt.shop.utils.StringTools;
import com.xudt.shop.utils.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
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
 * @describe: 商品信息管理
 */
@Controller
@RequestMapping("/commodity")
public class CommodityController  {

    @Autowired
    private CommodityService commodityService;

    /**
     * 获取所有商品信息
     * @return ModelAndView
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView("commodity/commodity_list");
        List<CommodityDTO> commodityList = commodityService.findAll();
        List<CommodityTypeDTO> typeList = commodityService.findParentCommodity();
        model.addObject("typeList", typeList);
        model.addObject("commodityList", commodityList);
        return model;
    }

/*    *//**
     * 根据id获取商品信息
     * @param id
     * @return ModelAndView
     *//*
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ModelAndView findById(Integer id){
        ModelAndView model = new ModelAndView("commodity/commodity_edit");
        if (id != null) {
            CommodityDTO commodityList = commodityService.findById(id);
            model.addObject("commodityList", commodityList);
        }
        List<CommodityTypeDTO> typeList = commodityService.findParentCommodity();
        model.addObject("typeList", typeList);
        return model;
    }*/

    /**
     * 转入新增页面
     * @return ModelAndView
     */
    @RequestMapping(value = "editCommodityView")
    public ModelAndView editCommodityView(Integer id){
        ModelAndView model = new ModelAndView("commodity/commodity_edit");
        if(id != null) {
            //根据商品id获取商品信息
            CommodityDTO commodityList = commodityService.findById(id);
            model.addObject("commodityList", commodityList);
        }
        List<CommodityTypeDTO> typeList = commodityService.findParentCommodity();
        model.addObject("typeList", typeList);
        return model;
    }

    /**
     * 根据id删除商品信息
     * @param id
     * @return Object
     */
    @RequestMapping(value = "deleteById", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteById(Integer id){
        try{
            if(id != null){
                commodityService.deleteById(id);
            }
            return getSucess();
        }catch (Exception e){
            return getError();
        }
    }

    /**
     * 修改商品信息
     * @param commodity
     * @return Object
     */
    @RequestMapping(value = "editCommodity")
    @ResponseBody
    public Object editCommodity(CommodityDTO commodity){
        try{
            if (commodity.getId() != null){
                commodityService.updateCommodity(commodity);
            }else {
                commodityService.insertCommodity(commodity);
            }
            return getSucess();
        }catch (Exception e){
            return getError();
        }
    }

    /**
     * 根据名称搜索商品
     * @param keyword
     * @return ModelAndView
     */
    @RequestMapping(value = "findByKeyword", method = RequestMethod.GET)
    public ModelAndView findByKeyword(String keyword) {
        ModelAndView model = new ModelAndView("commodity/commodity_list");
        if(!StringTools.isNullOrEmpty(keyword)){
            List<CommodityDTO> commodityList = commodityService.findByKeyword(keyword);
            model.addObject("commodityList", commodityList);
        }
        return model;
    }


    /**
     * 根据id获取商品详情信息
     * @param id
     * @return ModelAndView
     */
    @RequestMapping(value = "detailById", method = RequestMethod.GET)
    public ModelAndView detailById(Integer id){
        ModelAndView model = new ModelAndView("order/order_detail");
        if (id != null) {
            CommodityDTO commodityList = commodityService.findById(id);
            model.addObject("commodityList", commodityList);
        }
        //用户信息
        Session session = SecurityUtils.getSubject().getSession();
        UserDTO userInfo = (UserDTO) session.getAttribute(Constants.SESSION_USER_INFO);
        model.addObject("userInfo",userInfo);
        return model;
    }
}



package com.xudt.shop.controller;

import com.xudt.shop.model.CommodityDTO;
import com.xudt.shop.model.CommodityTypeDTO;
import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.CommodityService;
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
 * @describe: 商城首页
 */
@Controller
public class MallController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 商城首页
     * @param id
     * @return ModelAndView
     */
    @RequestMapping(value = "mallIndex")
    public ModelAndView index(Integer id) {
        ModelAndView model = new ModelAndView("/mall_index");
        //商品列表
        List<CommodityDTO> commodityList = commodityService.findAll();
        //商品一级分类
        List<CommodityTypeDTO> parentCommodity = commodityService.findParentCommodity();
        //商品分类列表
        List<CommodityTypeDTO> commodityClassify = commodityService.findCommodityClassify(parentCommodity);
        //用户信息
        Session session = SecurityUtils.getSubject().getSession();
        UserDTO userInfo = (UserDTO) session.getAttribute(Constants.SESSION_USER_INFO);
        model.addObject("commodityList", commodityList);
        model.addObject("commodityClassify",commodityClassify);
        model.addObject("userInfo",userInfo);
        return model;
    }
}

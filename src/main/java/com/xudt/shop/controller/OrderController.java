package com.xudt.shop.controller;

import com.xudt.shop.model.CommodityDTO;
import com.xudt.shop.model.CommodityTypeDTO;
import com.xudt.shop.model.OrderDTO;
import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.CommodityService;
import com.xudt.shop.service.OrderService;
import com.xudt.shop.service.UserService;
import com.xudt.shop.utils.StringTools;
import com.xudt.shop.utils.constants.GenerateOrderId;
import com.xudt.shop.utils.enums.OrderStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;

import static com.xudt.shop.utils.ResultUtils.getError;
import static com.xudt.shop.utils.ResultUtils.getSucess;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 订单管理
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private UserService userService;

    /**
     * 获取所有订单
     * @return ModelAndView
     */
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public ModelAndView findAll(){
        ModelAndView model = new ModelAndView("order/order_list");
        List<OrderDTO> orderList = orderService.findAll();
        model.addObject("orderList", orderList);
        return model;
    }

    /**
     * 下单
     * @param id
     * @return Object
     */
    @RequestMapping(value = "insertOrder")
    @ResponseBody
    public Object insertOrder(Integer id, String orderUser, Integer userId){
        try{
            //根据商品id查询商品信息
            CommodityDTO commodityList = commodityService.findById(id);
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCommodityId(commodityList.getId());
            orderDTO.setCommodityName(commodityList.getName());
            orderDTO.setCommodityType(commodityList.getType());
            orderDTO.setCommodityPrice(commodityList.getPrice());
            orderDTO.setStatus(OrderStatusEnum.NEW.getCode());
            orderDTO.setOrderId(GenerateOrderId.getOrderId(commodityList.getType()));
            orderDTO.setOrderUser(orderUser);
            orderDTO.setUserId(userId);
            //下单
            orderService.insertOrder(orderDTO);
            UserDTO userDTO = new UserDTO();
            //根据用户id查询用户现有积分
            BigDecimal oldPoints = userService.findUserPoints(userId);
            //下单成功后积分增加商品价格数
            userDTO.setPoints(oldPoints.add(commodityList.getPrice()));
            userDTO.setId(userId);
            //修改用户积分
            userService.updateUserPoints(userDTO);
            return getSucess();
        }catch (Exception e){
            return getError();
        }
    }

    /**
     * 根据id获取订单
     * @param id
     * @return ModelAndView
     */
    @RequestMapping(value = "findById", method = RequestMethod.GET)
    public ModelAndView findById(Integer id){
        ModelAndView model = new ModelAndView("order/order_edit");
        if (id != null ) {
            OrderDTO orderList = orderService.findById(id);
            model.addObject("orderList", orderList);
        }
        List<CommodityTypeDTO> typeList = commodityService.findParentCommodity();
        model.addObject("typeList", typeList);
        return model;
    }

    /**
     * 根据id删除订单
     * @param id
     * @return Object
     */
    @RequestMapping(value = "deleteById", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteById(Integer id){
        try{
            if(id != null){
                orderService.deleteById(id);
            }
            return getSucess();
        }catch (Exception e){
            return getError();
        }
    }

    /**
     * 修改订单信息
     * @param order
     * @return Object
     */
    @RequestMapping(value = "editOrder")
    @ResponseBody
    public Object editOrder(OrderDTO order){
        try{
            if (order.getId() != null){
                orderService.updateOrder(order);
            }
            return getSucess();
        }catch (Exception e){
            return getError();
        }
    }

    /**
     * 根据订单号搜索订单
     * @param keyword
     * @return ModelAndView
     */
    @RequestMapping(value = "searchOrder", method = RequestMethod.GET)
    public ModelAndView searchOrder(String keyword) {
        ModelAndView model = new ModelAndView("order/order_list");
        if (!StringTools.isNullOrEmpty(keyword)){
            List<OrderDTO> orderList = orderService.findByKeyword(keyword);
            model.addObject("orderList", orderList);
        }
        return model;
    }

    /**
     * 根据用户id查询用户购物车商品
     * @param userId
     * @return ModelAndView
     */
    @RequestMapping(value = "userCarList")
    public ModelAndView userCarList(Integer userId){
        ModelAndView model = new ModelAndView("user/user_carList");
        if (userId != null){
            List<OrderDTO> userCarList = orderService.userCarList(userId);
            model.addObject("userCarList",userCarList);
        }
        return model;
    }

    /**
     * 付款
     * @param id
     * @return Object
     */
    @RequestMapping(value = "pay")
    @ResponseBody
    public Object pay(Integer id){
        try{
            if (id != null){
                orderService.pay(id);
            }
            return getSucess();
        }catch (Exception e){
            return getError();
        }
    }

    /**
     * 根据用户id查询用户已付款商品
     * @param userId
     * @return
     */
    @RequestMapping(value = "userOrderList")
    public ModelAndView userOrderList(Integer userId){
        ModelAndView model = new ModelAndView("user/user_orderList");
        if (userId != null){
            List<OrderDTO> userOrderList = orderService.userOrderList(userId);
            model.addObject("userOrderList",userOrderList);
        }
        return model;
    }
}

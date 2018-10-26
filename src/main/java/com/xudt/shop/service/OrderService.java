package com.xudt.shop.service;

import com.xudt.shop.model.OrderDTO;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 订单管理
 */
public interface OrderService {
    /**
     * 获取所有订单
     * @return
     */
    public List<OrderDTO> findAll();

    /**
     * 新增订单
     * @param order
     */
    public void insertOrder(OrderDTO order);

    /**
     * 修改订单
     * @param order
     */
    public void updateOrder(OrderDTO order);

    /**
     * 根据id获取订单
     * @param id
     * @return CommodityDTO
     */
    public OrderDTO findById(Integer id);

    /**
     * 根据id删除订单
     * @param id
     */
    public void deleteById(Integer id);

    /**
     * 根据订单号搜索订单
     * @param keyword
     * @return List<CommodityDTO>
     */
    public List<OrderDTO> findByKeyword(String keyword);

    /**
     * 根据用户id查询用户购物车商品
     * @param userId
     * @return List<OrderDTO>
     */
    public List<OrderDTO> userCarList(Integer userId);

    /**
     * 付款
     * @param id
     */
    public void pay(Integer id);

    /**
     * 根据用户id查询用户已付款订单
     * @param userId
     * @return List<OrderDTO>
     */
    public List<OrderDTO> userOrderList(Integer userId);

}

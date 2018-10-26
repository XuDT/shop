package com.xudt.shop.service.impl;

import com.xudt.shop.dao.OrderDao;
import com.xudt.shop.model.OrderDTO;
import com.xudt.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 订单管理
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    /**
     * 获取所有订单
     * @return List<OrderDTO>
     */
    public List<OrderDTO> findAll() {
        return orderDao.findAll();
    }

    /**
     * 新增订单
     * @param order
     */
    public void insertOrder(OrderDTO order) {
        orderDao.insertOrder(order);
    }

    /**
     * 修改订单
     * @param order
     */
    @Override
    public void updateOrder(OrderDTO order) {
        orderDao.updateOrder(order);
    }

    /**
     * 根据id查询订单
     * @param id
     * @return OrderDTO
     */
    @Override
    public OrderDTO findById(Integer id) {
        return orderDao.findById(id);
    }

    /**
     * 根据id删除订单
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        orderDao.deleteById(id);
    }

    /**
     * 根据订单号搜索订单
     * @param keyword
     * @return List<OrderDTO>
     */
    @Override
    public List<OrderDTO> findByKeyword(String keyword) {
        return orderDao.findByKeyword(keyword);
    }

    /**
     * 根据用户id查询用户购物车商品
     * @param userId
     * @return List<OrderDTO>
     */
    public List<OrderDTO> userCarList(Integer userId) {
        return orderDao.userCarList(userId);
    }

    /**
     * 付款
     * @param id
     */
    public void pay(Integer id) {
        orderDao.pay(id);
    }

    /**
     * 根据用户id查询用户已付款订单
     * @param userId
     * @return List<OrderDTO>
     */
    public List<OrderDTO> userOrderList(Integer userId){
        return orderDao.userOrderList(userId);
    }
}

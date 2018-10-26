package com.xudt.shop.model;

import java.math.BigDecimal;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 订单实体类
 */
public class OrderDTO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 订单状态
     */
    private int status;

    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 商品id
     */
    private int commodityId;

    /**
     * 商品价格
     */
    private BigDecimal commodityPrice;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品类型
     */
    private int commodityType;


    /**
     * 删除状态，0表示已删除
     */
    private int deleteStatus;

    /**
     * 商品类型名称
     */
    private String name;
    /**
     * 下单用户
     */
    private String orderUser;
    /**
     * 下单时间
     */
    private String orderTime;
    /**
     * 下单用户id
     */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public BigDecimal getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(BigDecimal commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(int commodityType) {
        this.commodityType = commodityType;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}

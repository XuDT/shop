package com.xudt.shop.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 用户实体类
 */
public class UserDTO {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String  password;

    /**
     * 联系方式
     */
    private String  tel;

    /**
     * 昵称
     */
    private String  nickname;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 创建时间
     */
    private Date  createtime;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 逻辑删除
     */
    private int deletestatus;

    /**
     * 用户地址
     */
    private String address;

    /**
     * 用户积分
     */
    private BigDecimal points;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public int getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(int deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
}

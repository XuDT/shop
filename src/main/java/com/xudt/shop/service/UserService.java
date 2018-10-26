package com.xudt.shop.service;

import com.xudt.shop.model.UserDTO;

import java.math.BigDecimal;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 用户管理
 */
public interface UserService {

    /**
     * 新增用户
     * @param user
     */
    public void addUser(UserDTO user);

    /**
     * 检测用户名是否已存在
     * @param username
     * @return
     */
    public UserDTO queryExistUsername(String username);

    /**
     * 获取用户当前积分
     * @param userId
     * @return BigDecimal
     */
    public BigDecimal findUserPoints(Integer userId);

    /**
     * 修改用户积分
     * @param userDTO
     */
    public void updateUserPoints(UserDTO userDTO);

    /**
     * 查询用户个人资料
     * @param id
     * @return List<UserDTO>
     */
    public UserDTO findUserInfo(Integer id);
}

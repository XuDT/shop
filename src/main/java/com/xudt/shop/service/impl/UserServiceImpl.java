package com.xudt.shop.service.impl;

import com.xudt.shop.dao.UserDao;
import com.xudt.shop.model.UserDTO;
import com.xudt.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: dantong.xu
 * @date: 2018/10/23
 * @describe: 用户管理
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增用户
     * @param user
     */
    @Override
    public void addUser(UserDTO user) {
        userDao.addUser(user);
    }

    /**
     * 校验用户名是否已存在
     * @param username
     * @return UserDTO
     */
    @Override
    public UserDTO queryExistUsername(String username) {
        return userDao.queryExistUsername(username);
    }

    /**
     * 获取用户当前积分
     * @param userId
     * @return BigDecimal
     */
    public BigDecimal findUserPoints(Integer userId){
        return userDao.findUserPoints(userId);
    }

    /**
     * 修改用户积分
     * @param userDTO
     */
    @Override
    public void updateUserPoints(UserDTO userDTO) {
        userDao.updateUserPoints(userDTO);
    }

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return UserDTO
     */
    @Override
    public UserDTO findUserInfo(Integer id) {
        return userDao.findUserInfo(id);
    }


}

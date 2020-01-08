package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.common.OrderEnum;
import com.mxz.supermarket.model.User;

import java.util.List;

public interface UserService {

    /**
     * 登录用户
     * @param users
     * @return
     */
    User loginUser(User users);

    /**
     * 增加用户
     * @param user
     * @return
     */
    int addUser(User user);



    /**
     * 批量增加用户
     * @param users
     * @return
     */
    boolean addBatchUsers(List<User> users);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);


    /**
     * 通过邮箱修改密码
     * @param
     * @param user
     * @return
     */
    int updatePasswordByMailbox(User user);
    /**
     * 根据ID删除用户
     * @param userId
     * @return
     */
    boolean deleteUser(Integer userId);

    /**
     * 查询所有用户
     * @param page
     * @param limit
     * @return
     */
    PageInfo<User> searchUsers(int page, int limit);

    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    User searchUsersByUserId(Integer userId);



    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    PageInfo<User> searchUsersById(int page, int limit, Integer userId, String order, OrderEnum orderEnum);

    /**
     *根据名称查询用户
     * @param page
     * @param limit
     * @param userName
     * @return
     */
    PageInfo<User> searchUsersByName(int page, int limit, String userName);

    /**
     *根据邮箱查询用户
     * @param page
     * @param limit
     * @param email
     * @return
     */
    PageInfo<User> searchUsersByEmail(int page, int limit, String email);

}

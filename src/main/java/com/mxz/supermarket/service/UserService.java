package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.User;

import java.util.List;

public interface UserService {

    /**
     * 登录用户
     * @param email 用户名
     * @param userpassword 密码
     * @return 用户信息
     */
    User loginUser(String email,String userpassword);

    /**
     * 增加用户
     * @param user 用户的信息
     * @return 是否添加成功
     */
    boolean addUser(User user);



    /**
     * 批量增加用户
     * @param users 用户列表
     * @return 是否增加成功
     */
    boolean addBatchUsers(List<User> users);

    /**
     * 修改用户
     * @param user 用户数据
     * @return 是否修改成功
     */
    boolean updateUser(User user);


    /**
     * 通过邮箱修改密码
     * @param newPassword 新密码
     * @param userId 用户id
     * @return 是否修改成功
     */
    boolean updatePasswordByMailbox(String newPassword,Integer userId);
    /**
     * 根据ID删除用户
     * @param userId 用户的id
     * @return 是否删除成功
     */
    boolean deleteUser(Integer userId);

    /**
     * 查询所有用户
     * @param page 当前页页码
     * @param limit 页面大小
     * @return 分页查询出来的用户数据
     */
    PageInfo<User> searchUsers(int page, int limit);

    /**
     * 根据ID查询用户
     * @param userId 用户的id
     * @return 用户数据
     */
    User searchUsersByUserId(Integer userId);

    /**
     *根据名称查询用户
     * @param userName 用户名
     * @return 查询出来的用户
     */
    User searchUsersByName(String userName);

   

}

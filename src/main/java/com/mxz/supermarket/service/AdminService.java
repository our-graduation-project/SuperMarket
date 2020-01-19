package com.mxz.supermarket.service;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.model.Admin;


/**
 * @Author: Zxw
 * @Description:
 * @Date: Created in 10:09 2020/1/14
 * @Modifued By:
 */
public interface AdminService {

    /**
     * 管理员登录
     * @param admin 管理员对象
     * @return
     */
    Admin login(Admin admin);

    /**
     * 管理员增加
     * @param admin 管理员对象
     * @return
     */
    boolean addAdmin(Admin admin);

    /**
     * 管理员增加
     * @param admin 管理员对象
     * @return
     */
    boolean updateAdmin(Admin admin);

    /**
     * 根据管理员id'查找管理员
     * @param adminId 管理员id
     * @return
     */
    Admin findAdminById(int adminId);

    /**
     * 管理员增加
     * @param adminName 管理员名
     * @return
     */
    PageInfo<Admin> findAdminLikeName(String adminName, int page, int limit);


    /**
     * 管理员注册
     * @param admin 管理员对象
     * @return
     */
    boolean registerAdmin(Admin admin);

    /**
     * 根据管理员email'查找管理员
     * @param email 管理员邮箱
     * @return
     */
    Admin findAdminByEmail(String email);

    /**
     * 根据管理员email'查找管理员
     * @param phone 管理员电话
     * @return
     */
    Admin findAdminByPhone(String phone);

    /**
     * 查询出所有的管理员
     * @param page
     * @param limit
     * @return
     */
    PageInfo<Admin> loadAllAdmin(int page,int limit);

    /**
     * 根据id删除管理员
     * @param adminId
     * @return
     */
    boolean delAdmin(int adminId);
}
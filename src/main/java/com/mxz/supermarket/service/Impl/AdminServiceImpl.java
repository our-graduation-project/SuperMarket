package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.AdminMapper;
import com.mxz.supermarket.model.Admin;
import com.mxz.supermarket.model.AdminExample;
import com.mxz.supermarket.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Zxw
 * @Description:
 * @Date: Created in 10:36 2020/1/14
 * @Modifued By:
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 管理员登录
     *
     * @param admin 管理员对象
     * @return
     */
    @Override
    public Admin login(Admin admin) {
        AdminExample adminExample = new AdminExample();
        adminExample.or().andEmailEqualTo(admin.getEmail()).andPasswordEqualTo(admin.getPassword());
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        System.out.println(admins);
        if (admins != null && admins.size() == 1) {
            return admins.get(0);
        }
        return null;
    }

    /**
     * 管理员增加
     *
     * @param admin 管理员对象
     * @return
     */
    @Override
    public boolean addAdmin(Admin admin) {

        int insert = adminMapper.insert(admin);

        if(insert > 0){
            return true;
        }

        return false;
    }

    /**
     * 管理员增加
     *
     * @param admin 管理员对象
     * @return
     */
    @Override
    public boolean updateAdmin(Admin admin) {
        int i = adminMapper.updateByPrimaryKeySelective(admin);
        if(i > 0){
            return true;
        }
        return false;
    }

    /**
     * 根据管理员id'查找管理员
     *
     * @param adminId 管理员id
     * @return
     */
    @Override
    public Admin findAdminById(int adminId) {
        Admin admin = adminMapper.selectByPrimaryKey(adminId);
        return admin;
    }

    /**
     * 管理员增加
     *
     * @param adminName 管理员名
     * @return
     */
    @Override
    public PageInfo<Admin> findAdminLikeName(String adminName, int page, int limit) {
        AdminExample adminExample = new AdminExample();
        if(adminName == null){
            adminExample.or();
        }else{
            adminExample.or().andAdminNameLike(adminName+"%");
        }
        PageHelper.startPage(page, limit);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        PageInfo pageInfo=new PageInfo(admins,3);
        return pageInfo;
    }

    /**
     * 管理员注册
     *
     * @param admin 管理员对象
     * @return
     */
    @Override
    public boolean registerAdmin(Admin admin) {
        int insert = adminMapper.insert(admin);
        if(insert > 0){
            return true;
        }
        return false;
    }

    @Override
    public Admin findAdminByEmail(String email) {
        AdminExample adminExample = new AdminExample();
        adminExample.or().andEmailEqualTo(email);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins != null && admins.size() == 1) {
            return admins.get(0);
        }
        return null;
    }

    /**
     * 根据管理员email'查找管理员
     *
     * @param phone 管理员电话
     * @return
     */
    @Override
    public Admin findAdminByPhone(String phone) {
        AdminExample adminExample = new AdminExample();
        adminExample.or().andPhoneEqualTo(phone);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        if (admins != null && admins.size() == 1) {
            return admins.get(0);
        }
        return null;
    }

    /**
     * 查询出所有的管理员
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageInfo<Admin> loadAllAdmin(int page, int limit) {

        AdminExample adminExample=new AdminExample();
        adminExample.or();
        PageHelper.startPage(page, limit);
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        PageInfo pageInfo=new PageInfo(admins,3);
        return pageInfo;
    }

    /**
     * 根据id删除管理员
     *
     * @param adminId
     * @return
     */
    @Override
    public boolean delAdmin(int adminId) {
        int i = adminMapper.deleteByPrimaryKey(adminId);
        return i > 0 ;
    }
}
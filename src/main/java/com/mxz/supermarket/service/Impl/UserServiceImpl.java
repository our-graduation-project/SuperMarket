package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.mapper.UserMapper;
import com.mxz.supermarket.model.User;
import com.mxz.supermarket.model.UserExample;
import com.mxz.supermarket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 * @createTime 2020.01.09.16:20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Resource(type = UserMapper.class)
    UserMapper userMapper;

    /**
     * 登录用户
     *
     * @param email 用户名
     * @param userpassword 密码
     * @return 用户信息
     */
    @Override
    public User loginUser(String email, String userpassword) {
        UserExample userExample = new UserExample();
        userExample.or().andEmailEqualTo(email).andPasswordEqualTo(userpassword);
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null||users.size()>0){
            return users.get(0);
        }
        return null;
    }

    /**
     * 增加用户
     *
     * @param user 用户的信息
     * @return 是否添加成功
     */
    @Override
    public boolean addUser(User user) {
        UserExample userExample = new UserExample();
        userExample.or().andEmailEqualTo(user.getEmail());
        List<User> users = userMapper.selectByExample(userExample);
        if(users!=null&&users.size()>0){
            return false;
        }

        UserExample userExample2 = new UserExample();
        userExample2.or().andPhoneEqualTo(user.getPhone());
        List<User> users2 = userMapper.selectByExample(userExample2);
        if(users2!=null&&users2.size()>0){
            return false;
        }
        int insert = userMapper.insert(user);
        if(insert>0){
            return true;
        }
        return false;
    }

    /**
     * 批量增加用户
     *
     * @param users 用户列表
     * @return 是否增加成功
     */
    @Override
    public boolean addBatchUsers(List<User> users) {
        int i = userMapper.addBatchUsers(users);
        if(i==users.size()){
            return true;
        }
        return false;
    }

    /**
     * 修改用户
     *
     * @param user 用户数据
     * @return 是否修改成功
     */
    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * 通过邮箱修改密码
     *
     * @param newPassword 新密码
     * @param userId        用户id
     * @return 是否修改成功
     */
    @Override
    public boolean updatePasswordByMailbox(String newPassword, Integer userId) {
        User user = new User();
        user.setPassword(newPassword);
        user.setUserId(userId);
        UserExample userExample = new UserExample();
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i ==1){
            return true;
        }
        return false;
    }

    /**
     * 根据ID删除用户
     *
     * @param userId 用户的id
     * @return 是否删除成功
     */
    @Override
    public boolean deleteUser(Integer userId) {
        UserExample userExample = new UserExample();
        userExample.or().andUserIdEqualTo(userId);
        int i = userMapper.deleteByExample(userExample);
        if(i == 1){
            return true;
        }
        return false;
    }

    /**
     * 查询所有用户
     *
     * @param page  当前页页码
     * @param limit 页面大小
     * @return 分页查询出来的用户数据
     */
    @Override
    public PageInfo<User> searchUsers(int page, int limit) {
        UserExample userExample = new UserExample();
        userExample.or();
        PageHelper.startPage(page,limit);
        List<User> users = userMapper.selectByExample(userExample);
        PageInfo pageInfo = new PageInfo(users,5);
        return pageInfo;
    }

    /**
     * 根据ID查询用户
     *
     * @param userId 用户的id
     * @return 用户数据
     */
    @Override
    public User searchUsersByUserId(Integer userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }

    /**
     * 根据名称查询用户
     *
     * @param userName 用户名
     * @return 查询出来的用户
     */
    @Override
    public User searchUsersByName(String userName) {
        UserExample userExample = new UserExample();
        userExample.or().andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null && users.size()>0){
            return users.get(0);
        }
        return null;
    }


}

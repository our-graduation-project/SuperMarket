package com.mxz.supermarket.service.Impl;

import com.github.pagehelper.PageInfo;
import com.mxz.supermarket.SupermarketApplication;
import com.mxz.supermarket.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 向清润
 * @createTime 2020.01.10.15:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SupermarketApplication.class)
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;

    @Test
    void loginUser() {
        User user = userService.loginUser("123456@qq.com", "123456");
        System.out.println(user);
    }

    @Test
    void addUser() {
        User user = new User("张山","123456","123456@qq.com","zs","123343242","堡家山",15,true);
        boolean b = userService.addUser(user);
        boolean c = userService.addUser(user);
        System.out.println(b+":"+c);
    }

    @Test
    void addBatchUsers() {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("张山"+i,"123456"+i,"123456"+i+"@qq.com","zs","123343242"+i,"堡家山",15,true);
            users.add(user);
        }
        boolean b = userService.addBatchUsers(users);
        System.out.println(b);
    }

    @Test
    void updateUser() {
        User user = new User("张si","123456","123456@qq.com","zs","123343242","堡家山",15,true);

        user.setUserId(1);
        boolean b = userService.updateUser(user);
        System.out.println(b);
    }

    @Test
    void updatePasswordByMailbox() {
        boolean b = userService.updatePasswordByMailbox("2332123", 1);
        System.out.println(b);
    }

    @Test
    void deleteUser() {
        boolean b = userService.deleteUser(17);
        System.out.println(b);
    }

    @Test
    void searchUsers() {
        PageInfo<User> userPageInfo = userService.searchUsers(1, 4);
        for (int i = 0; i < 4; i++) {
            System.out.println(userPageInfo.getList().get(i));
        }

    }

    @Test
    void searchUsersByUserId() {
        User user = userService.searchUsersByUserId(1);
        System.out.println(user);
    }

    @Test
    void searchUsersByName() {
        User user = userService.searchUsersByName("张山1");
        System.out.println(user);
    }
}
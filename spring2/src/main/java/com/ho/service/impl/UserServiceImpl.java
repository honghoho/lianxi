package com.ho.service.impl;

import com.ho.dao.UserDao;
import com.ho.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
//  构造函数用的就是这种方式
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {
    }

/*    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/


    @Override
    public void out() {
        userDao.out();
    }

}

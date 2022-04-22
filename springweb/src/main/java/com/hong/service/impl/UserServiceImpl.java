package com.hong.service.impl;

import com.hong.dao.UserDao;
import com.hong.service.UserService;

public class UserServiceImpl implements UserService {


    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void save() {
        userDao.save();
    }
}

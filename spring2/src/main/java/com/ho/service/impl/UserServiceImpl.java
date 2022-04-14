package com.ho.service.impl;

import com.ho.dao.UserDao;
import com.ho.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    @Override
    public void out() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) app.getBean("UserDao");
        userDao.out();
    }

}

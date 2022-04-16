package com.ho.dao.impl;

import com.ho.dao.UserDao;

public class UserDaoImpl implements UserDao {

    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void out() {
        System.out.println(username+"===="+age);
        System.out.println("123456");
    }
}

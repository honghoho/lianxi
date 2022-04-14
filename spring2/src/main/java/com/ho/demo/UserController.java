package com.ho.demo;

import com.ho.service.UserService;
import com.ho.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserController {
    public static void main(String[] args) {
        ApplicationContext app =new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) app.getBean("userService");
        userService.out();
    }
}

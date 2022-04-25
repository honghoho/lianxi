package com.hong.listener;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    //读取web.xml中的全局参数
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        //读取web.xml中的全局参数
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
        ApplicationContext app =new ClassPathXmlApplicationContext(contextConfigLocation);
        //将这个应用上下文对象存储到最大的域ServletContext中
        servletContext.setAttribute("app",app);
        System.out.println("spring容器创建完毕");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

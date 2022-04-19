package com.hong.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {
    @Test
    //测试手动创建c3p0数据源的
    public void test1() throws Exception {
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/meeting?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


    @Test
    //测试手动创建druid数据源的
    public void test2() throws Exception{
        DruidDataSource dataSource =new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/meeting?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        DruidPooledConnection connection =dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


    @Test
    //测试手动创建c3p0数据源的(加载properties配置文件形式)
    public void test3() throws Exception{
        ResourceBundle rb =ResourceBundle.getBundle("jdbc");
        String driver =rb.getString("jdbc.driver");
        String url =rb.getString("jdbc.url");
        String username =rb.getString("jdbc.username");
        String password =rb.getString("jdbc.password");
        //创建数据源对象 设置连接参数
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        Connection connection= dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }


    @Test
    //测试spring容器产生数据源对象
    public void test4() throws Exception{
        ApplicationContext app =new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource= app.getBean(DataSource.class);
        Connection connection =dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
}
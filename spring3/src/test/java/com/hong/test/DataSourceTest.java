package com.hong.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.testng.annotations.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;

public class DataSourceTest {
    @Test
    //测试手动创建c3p0数据源的
    public void test1() throws Exception {
        ComboPooledDataSource dataSource =new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysqljdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/user");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

}

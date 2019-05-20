package com.soft1841.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 新增数据
 */
public class JDBCDmeo2 {
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL ="jdbc:mysql://localhost:3306/db_jdbc?useUnicode=true&characterEncoding=utf8";
    static final String USER ="root";
    static  final String PASS="root";
    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        System.out.println("连接数据库...");
        Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //拼写SQL语句，用？作为参数占位符（姓名和年龄）
        String sql ="INSERT INTO t_student (name,age) VALUES(?,?)";
        System.out.println("实例化PreparedStatement对象...");
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        //给两个参数设置值
        preparedStatement.setString(1,"测试用户");
        preparedStatement.setInt(2,20);
        int n =preparedStatement.executeUpdate();
        System.out.println(n+"行记录收到影响");
        preparedStatement.close();
        conn.close();
    }
}

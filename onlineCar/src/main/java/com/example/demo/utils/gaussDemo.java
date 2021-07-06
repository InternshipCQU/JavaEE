package com.example.demo.utils;
import java.sql.*;

public class gaussDemo {

    public static Connection getConnect(String username, String passwd) {
        //驱动类。
        String driver = "org.postgresql.Driver";
        //数据库连接描述符。
        String sourceURL = "jdbc:postgresql://120.46.151.189:8000/postgres";
        Connection conn = null;

        try
        {
            //加载驱动。
            Class.forName(driver);
        }
        catch( Exception e )
        {
            e.printStackTrace();
            return null;
        }

        try
        {
            //创建连接。
            conn = DriverManager.getConnection(sourceURL, username, passwd);
            System.out.println("Connection succeed!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return conn;
    };



    public static void main(String[] args) {
        String userName = "root";
        String password = "Heyjude259?";
        //创建数据库连接。
        Connection conn = getConnect(userName, password);
        //查询测试表。
//        SelectTest(conn);
//        //关闭数据库连接。
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
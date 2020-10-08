package com;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName mysqlconnect
 * @Description TODO
 * @Author tommy
 * @Date 9/2/2020 2:10 PM
 **/
public class mysqlconnect {
    public static Connection getConnection() {
        Connection connection = null;
        String ip = "jdbc:mysql://localhost:3306/cloud-class?serverTimezone=CTT&useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "123456";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("连接数据库中");
            connection = (Connection) DriverManager.getConnection(ip,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void getMsgFromDataBase(Connection connection){
        try{
            Statement statement  = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from vehicle_config");

            while (resultSet.next()){
                System.out.println("名称:"+resultSet.getString("name"));
                System.out.println("code:"+resultSet.getString("code"));
                System.out.println("id:"+resultSet.getString("id"));
                System.out.println("parentID:"+resultSet.getString("parent_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection!=null){
            System.out.println("输出数据");
        }
        getMsgFromDataBase(connection);
    }
}
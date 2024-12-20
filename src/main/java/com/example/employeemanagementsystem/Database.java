package com.example.employeemanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static Connection connectDb(){
    try{
       Class.forName("com.mysql.jdbc.Driver");
       Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login","root","78523Dip");
       return connection;
    } catch (Exception e) {
            e.printStackTrace();
    }
       return null;
    }
}




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Azmol-IT
 */
public class ConnectionManager {
    
    public final String CONN_DRIVER = "com.mysql.jdbc.Driver";
    public final String CONN_SCHEMA = "jdbc:mysql://localhost:3306/employee_management_db";
    public final String USERNAME = "root";
    public final String PASSWORD = "apcl123456";
    
    Connection conn;
    
    public Connection doCOnnection(){
        try {
            Class.forName(CONN_DRIVER);
            conn = DriverManager.getConnection(CONN_SCHEMA, USERNAME, PASSWORD);
        } catch (Exception e) {
        }
        return conn;
    }
    
    public void closeConnection(){
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
    
}

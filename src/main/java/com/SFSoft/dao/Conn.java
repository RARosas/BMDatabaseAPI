/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SFSoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author raul
 */

public class Conn {
    
    private Connection conn;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String user = "root";
    private final String password = "Tomas10/Sept";
    private final String urlDataBase = "jdbc:mysql://localhost:3306/BMDataBase?serverTimezone=UTC";
    
    private static Conn connection;
    
    private Conn () {}
    
    public static Conn getInstance() throws SQLException    {
        if (connection == null)   {
            connection = new Conn();
        }
        connection.connect();
        return connection;
    }

    private void connect() throws SQLException {
        if (conn == null || conn.isClosed())    {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = DriverManager.getConnection(urlDataBase, user, password);
        }
    }
    
    public boolean connectionExists () throws SQLException  {
        return conn != null && !conn.isClosed();
    }
    
    public Connection getCon()  {
        return conn;
    }
}

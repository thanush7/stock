package com.kgisl.capitalmarketing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    private DatabaseConnection(){

    }
    public static Connection getConnection() throws SQLException{
        if(connection==null||connection.isClosed()){
            try{
               connection=DriverManager.getConnection("jdbc:mysql://db4free.net:3306/kavin_mysql_123","kavin_123","kavin123");
            }
            catch(SQLException e){
            }
        }
        return connection;
    }
}

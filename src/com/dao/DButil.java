package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	public static Connection getConnection() {
        String username = "medicine";
        String password = "Liyang";
        String url="jdbc:oracle:thin:user@//localhost/orcl";
        String driver="oracle.jdbc.driver.OracleDriver";
        
        try {
        	
            Class.forName(driver);
            Connection con= DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = DButil.getConnection();
		System.out.println(con.toString());
	}

}

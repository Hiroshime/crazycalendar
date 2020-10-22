/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazycalendar.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

/**
 *
 * @author Luiz
 */
public class Conection {
    
    public static Connection getConnection() 
			throws ClassNotFoundException, 
		SQLException{
		String driver = "com.mysql.cj.jdbc.Driver";
                Class.forName( driver );
		String url = "jdbc:mysql://127.0.0.1/altair_suite?useTimezone=true&serverTimezone=UTC"; 
                String user = "root";
		String password = "root";
		
		Connection conn = 
				DriverManager.getConnection( url, user, password);

		return conn;
		
		

	}
}

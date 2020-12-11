/* 
 *	(C) Copyright 2020 LCN. All Rights Reserve
 *
 *	@author Admin
 *	@date Aug 27, 2020
 *	@version 1.0
 */ 
package model;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
	public static final String URL 		= "jdbc:sqlserver://LCN-COMPUTER\\SQLEXPRESS;databaseName=QLSV";
	
	public static final String DRIVER   = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	public static final String USERNAME = "sa";
	
	public static final String PASSWORD = "181000n@NNN";
	
	public static Connection connection = null;
	
	public static Connection openConnection() {
		 // check the connection
		if(connection != null) {
			return connection;
		}else {
			try {
				//load mysql driver
				Class.forName(DRIVER);
						
				// get connection
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			} catch (Exception e) {
				e.printStackTrace();
			}		
			// return connection
			return connection;
		}
	}
}

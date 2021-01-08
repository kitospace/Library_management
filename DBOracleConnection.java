package com.birlasoft.projectOne.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBOracleConnection {
	
	private static Connection con;
	
	public static void loadDriver()throws ClassNotFoundException
	{
		 
			// Loading drivers in application first step
			
			// is creating instance of driver
		Class.forName("oracle.jdbc.driver.OracleDriver"); // driver name 
		
		// Make a Connection second step
		
		
		
	}
	
	public static Connection  getOracleConnection() throws SQLException
	{
		String URL="jdbc:oracle:thin:@localhost:1522:ORCL1";
		String user="hr";
		String password="123456";
		if(con==null)
		{
			   con = DriverManager.getConnection(URL,user, password);
			
		}
		return con;
	}
	
	public static  void closeConnection(Connection con) throws SQLException
	{
		if(con!=null)
		con.close();
	}
	
	
	
}

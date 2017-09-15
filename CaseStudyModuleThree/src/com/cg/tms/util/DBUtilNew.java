package com.cg.tms.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtilNew {

	static InitialContext context;
	static DataSource dataSource;
	static Connection connection;
	
	static
	{
		try {
			context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/jdbc/TicketDB");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnect()
	{
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
}

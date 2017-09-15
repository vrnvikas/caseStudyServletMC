package com.cg.tms.util;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	

	public static Connection getDataBaseConnection() throws ClassNotFoundException, SQLException  {
		
		Connection conn = null;
		
			
		Class.forName(DBUtils.dbProperties().getProperty("driver"));
		conn = DriverManager.
				getConnection(DBUtils.dbProperties().getProperty("url"),
						DBUtils.dbProperties().getProperty("username"),
						DBUtils.dbProperties().getProperty("password"));
		
		return conn;
			
	}
	
	
	
	public static Properties dbProperties(){
		
		
		Properties prop;
		
		try(FileInputStream fin = new FileInputStream(
				new File(Constants.DATABSE_PROPERTIES_FILEPATH)) ){
			
			prop= new Properties();
			prop.load(fin);
			
			return prop;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}

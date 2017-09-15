package com.cg.tms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.pmc.dto.UserBean;
import com.cg.tms.exception.UserException;
import com.cg.tms.service.UserServiceImpl;
import com.cg.tms.util.DBUtilNew;
import com.cg.tms.util.DBUtils;

public class UserDAOImpl implements UserDAO {
	
	//static Logger myLogger = Logger.getLogger(TicketDAOImpl.class.getName());
	

	public UserDAOImpl() {
		
		//PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	
	/*
	 * Method Name: listTicketCategory
	 * Author: Vikas chaudhary
	 * Date: 31th Aug 2017
	 * Description: Method to add new ticket to table ticket log in databse.
	 * 
	 */

	// method to generate userId from sequence in database
	private int generateNewUserId(Connection databaseConn) throws UserException, SQLException {
		
		int userId = -1;
		final String userIdSequenceSQLQuey = "SELECT seq_firm_master.NEXTVAL FROM DUAL";
		
		try{
			
			PreparedStatement pstm= databaseConn.prepareStatement(userIdSequenceSQLQuey);
			ResultSet sequenceNumber = pstm.executeQuery();
				
				if(sequenceNumber.next())
					userId = sequenceNumber.getInt(1);
				else
					throw new UserException("Could not get ticket number.ticket number generation failed");
				
		}
		catch(SQLException e){
			
			throw new UserException("could not generate ticket number : " + e.getMessage());
			
		}
		return userId;		
		
	}

	@Override
	public int addUser(UserBean userBean) throws UserException{
		
		int userId = -1;
		
		boolean status = false;
		
		try(Connection conn = DBUtilNew.getConnect()){
			
			userId = generateNewUserId(conn);
			
			String FirstName = userBean.getFirstName();
			String MiddleName = userBean.getMiddleName();
			String LastName = userBean.getLastName();
			String businessName = userBean.getBusinessName();
			String emailId = userBean.getEmailId();
			Long phoneNo = userBean.getMobileNo();
			boolean isActive = userBean.isActive();
			
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO firms_master VALUES(?,?,?,?,?,?)");
			
			pstm.setInt(1,userId);
			pstm.setString(2, FirstName);
			pstm.setString(3, businessName);
			pstm.setString(4,emailId);
			pstm.setString(5,phoneNo.toString());
			
			if(isActive)
				pstm.setString(6,"t");
			else
				pstm.setString(6,"f");
			
			pstm.execute();
			
			status = true;
			
			//myLogger.info("ticket is added to database");
		}catch(Exception e){
			//myLogger.info("Exception occured in adding ticket bean to database : " + e.getMessage());
			System.out.println("Message : " + e.getMessage());
			throw new UserException(e.getMessage());
		}
		
		return userId;
	}


	@Override
	public boolean activateUser(String email) throws UserException {
		
		boolean status = false;
		
		try(Connection conn = DBUtilNew.getConnect()){
			
			
			PreparedStatement pstm = conn.prepareStatement("UPDATE firms_master SET IS_ACTIVE='t' WHERE EMAIL=?");
			
			pstm.setString(1,email);
			
			 pstm.execute();
			 status = true;
			//myLogger.info("ticket is added to database");
		}catch(Exception e){
			//myLogger.info("Exception occured in adding ticket bean to database : " + e.getMessage());
			System.out.println("Message : " + e.getMessage());
			throw new UserException(e.getMessage());
		}
		
		return status;
	}
	
	
	
}

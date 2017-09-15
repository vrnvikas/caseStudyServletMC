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

import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.exception.RaiseTicketException;
import com.cg.tms.service.TicketServiceImpl;
import com.cg.tms.util.DBUtils;

public class TicketDAOImpl implements TicketDAO {
	
	static Logger myLogger = Logger.getLogger(TicketDAOImpl.class.getName());
	

	public TicketDAOImpl() {
		
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	
	/*
	 * Method Name: listTicketCategory
	 * Author: Vikas chaudhary
	 * Date: 31th Aug 2017
	 * Description: Method to add new ticket to table ticket log in databse.
	 * 
	 */
	
	@Override
	public boolean raiseNewTicket(TicketBean ticketBean) throws RaiseTicketException {
		
		myLogger.info("raise new ticket method is called : " + ticketBean);
		
		int ticketNo = -1;
		
		boolean status = false;
		
		try(Connection conn = DBUtils.getDataBaseConnection()){
			
			ticketNo = generateNewTicketNo(conn);
			
			String ticketCategoryId = ticketBean.getTicketCategoryId();
			String ticketDescription = ticketBean.getTicketDescription();
			String ticketPriority = ticketBean.getTicketPriority();
			String ticketStatus = ticketBean.getTicketStatus();
			String itimedComments = ticketBean.getItimedComments();
			
			PreparedStatement pstm = conn.prepareStatement("INSERT INTO ticket_logs VALUES(?,?,?,?,?,?)");
			
			pstm.setInt(1,ticketNo);
			pstm.setString(2, ticketCategoryId);
			pstm.setString(3, ticketDescription);
			pstm.setString(4,ticketPriority);
			pstm.setString(5,ticketStatus);
			pstm.setString(6,itimedComments);
			
			pstm.execute();
			
			TicketServiceImpl.ticketNo = ticketNo;
			
			status = true;
			myLogger.info("ticket is added to database");
		}catch(Exception e){
			myLogger.info("Exception occured in adding ticket bean to database");
			throw new RaiseTicketException(e.getMessage());
		}
		
		return status;
	}
	
	
	/*
	 * Method Name: listTicketCategory
	 * Author: Vikas chaudhary
	 * Date: 31th Aug 2017
	 * Description: Method to get the list of all ticket categeory from ticket category table from the database.
	 * 
	 */
	@Override
	public List<TicketCategory> listTicketCategory() throws RaiseTicketException {
		
		myLogger.info("list ticket method is called");
		
		ArrayList<TicketCategory> ticketCategoryList = new ArrayList<TicketCategory>();
		TicketCategory ticketCategory;
		
		try(Connection conn = DBUtils.getDataBaseConnection()){
			
			Statement stm = conn.createStatement();
			
			ResultSet ticketCategorytable = stm.executeQuery("SELECT * FROM ticket_category");
			
			if(ticketCategorytable.next()){
				
				do{
					ticketCategory = new TicketCategory();
					ticketCategory.setTicketCategoryId(ticketCategorytable.getString("TICKET_CATEGORY_ID"));
					ticketCategory.setCategoryName(ticketCategorytable.getString("TICKET_CATEGORY_NAME"));
					ticketCategoryList.add(ticketCategory);
				}while(ticketCategorytable.next());
				
				myLogger.info("list ticket has retrived the list");
				
			}else{
				myLogger.info("Exception occured in listTicketCategory method : No record found on table");
				throw new RaiseTicketException("No record found on table");
			}
			
			
		}catch(Exception e){
			
			myLogger.info("Exception occured in listTicketCategory method : No record found on table");
			throw new RaiseTicketException("No record found on table");
		}
		
		return ticketCategoryList;
		
	}
	
	
	// method to generate ticketNo from sequence in database
	private int generateNewTicketNo(Connection databaseConn) throws RaiseTicketException, SQLException {
		
		int ticketNo = -1;
		final String ticketSequenceSQLQuey = "SELECT ticket_SEQ.NEXTVAL FROM DUAL";
		
		try{
			
			PreparedStatement pstm= databaseConn.prepareStatement(ticketSequenceSQLQuey);
			ResultSet sequenceNumber = pstm.executeQuery();
				
				if(sequenceNumber.next())
					ticketNo = sequenceNumber.getInt(1);
				else
					throw new RaiseTicketException("Could not get ticket number.ticket number generation failed");
				
		}
		catch(SQLException e){
			
			throw new RaiseTicketException("could not generate ticket number : " + e.getMessage());
			
		}
		return ticketNo;		
		
	}
	

}

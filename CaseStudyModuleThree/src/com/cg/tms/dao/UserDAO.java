package com.cg.tms.dao;

import java.util.List;

import com.cg.pmc.dto.UserBean;
import com.cg.tms.exception.UserException;

public interface UserDAO {
	
	//boolean raiseNewTicket(TicketBean ticketBean) throws UserException;
	//List<TicketCategory>listTicketCategory() throws UserException;
	//List<TicketBean>listTicket() throws UserException;
	//boolean editTicket(TicketBean ticketBean) throws UserException;
	int addUser(UserBean userBean) throws UserException;
	
	boolean activateUser(String email) throws UserException;
	
	
}

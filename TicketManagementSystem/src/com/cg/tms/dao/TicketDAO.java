package com.cg.tms.dao;

import java.util.List;

import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.exception.RaiseTicketException;

public interface TicketDAO {
	
	boolean raiseNewTicket(TicketBean ticketBean) throws RaiseTicketException;
	List<TicketCategory>listTicketCategory() throws RaiseTicketException;
}

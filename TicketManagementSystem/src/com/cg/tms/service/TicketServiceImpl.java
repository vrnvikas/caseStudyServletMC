package com.cg.tms.service;

import java.util.List;

import com.cg.tms.dao.TicketDAO;
import com.cg.tms.dao.TicketDAOImpl;
import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.exception.RaiseTicketException;

public class TicketServiceImpl implements TicketService {
	
	
	TicketDAO ticketDAO;
	public static int ticketNo = -1;
	
	public TicketServiceImpl() {
		ticketDAO = new TicketDAOImpl();
	}

	@Override
	public boolean raiseNewTicket(TicketBean ticketBean) throws RaiseTicketException {
		return ticketDAO.raiseNewTicket(ticketBean);
	}

	@Override
	public List<TicketCategory> listTicketCategory() throws RaiseTicketException {
		return ticketDAO.listTicketCategory();
	}
	
	
	public int getUserticketNo(){
		return ticketNo;
	}
	
}

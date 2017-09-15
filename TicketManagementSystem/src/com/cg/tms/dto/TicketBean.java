package com.cg.tms.dto;

public class TicketBean {
	
	
	private int ticketNo;
	private String ticketCategoryId;
	private String ticketDescription;
	private String ticketPriority;
	private String ticketStatus;
	private String itimedComments;
	
	public TicketBean() {
		// TODO Auto-generated constructor stub
	}

	public TicketBean(int ticketNo, String ticketCategoryId,
			String ticketDescription, String ticketPriority,
			String ticketStatus, String itimedComments) {
		super();
		this.ticketNo = ticketNo;
		this.ticketCategoryId = ticketCategoryId;
		this.ticketDescription = ticketDescription;
		this.ticketPriority = ticketPriority;
		this.ticketStatus = ticketStatus;
		this.itimedComments = itimedComments;
	}
	
	
	public TicketBean( String ticketCategoryId,
			String ticketDescription, String ticketPriority,
			String ticketStatus, String itimedComments) {
		super();
		this.ticketCategoryId = ticketCategoryId;
		this.ticketDescription = ticketDescription;
		this.ticketPriority = ticketPriority;
		this.ticketStatus = ticketStatus;
		this.itimedComments = itimedComments;
	}

	public int getTicketNo() {
		return ticketNo;
	}

	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public String getTicketCategoryId() {
		return ticketCategoryId;
	}

	public void setTicketCategoryId(String ticketCategoryId) {
		this.ticketCategoryId = ticketCategoryId;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getTicketPriority() {
		return ticketPriority;
	}

	public void setTicketPriority(String ticketPriority) {
		this.ticketPriority = ticketPriority;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getItimedComments() {
		return itimedComments;
	}

	public void setItimedComments(String itimedComments) {
		this.itimedComments = itimedComments;
	}

	@Override
	public String toString() {
		return "TicketBean [ticketNo=" + ticketNo + ", ticketCategoryId="
				+ ticketCategoryId + ", ticketDescription=" + ticketDescription
				+ ", ticketPriority=" + ticketPriority + ", ticketStatus="
				+ ticketStatus + ", itimedComments=" + itimedComments + "]";
	}
	
	

}

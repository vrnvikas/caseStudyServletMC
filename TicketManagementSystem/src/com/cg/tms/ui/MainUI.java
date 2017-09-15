package com.cg.tms.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.cg.tms.dto.TicketBean;
import com.cg.tms.dto.TicketCategory;
import com.cg.tms.exception.RaiseTicketException;
import com.cg.tms.service.TicketServiceImpl;
import com.cg.tms.util.ValidateInput;


interface MenuSelections{
	
	int RAISE_TICKET = 1;
	int EXIT_APPLICATION = 2;
	int TICKET_PRIORITY_LOW = 1;
	int TICKET_PRIORITY_MEDIUM = 2;
	int TICKET_PRIORITY_HIGH = 3;
	String TICKET_PRIORITY_LOW_VALUE = "low";
	String TICKET_PRIORITY_MEDIUM_VALUE = "medium";
	String TICKET_PRIORITY_HIGH_VALUE = "high";
	String TICKET_STATUS = "New";
	int TICKET_CATEGORY_SOFTWARE_INSTALLATION = 1;
	int TICKET_CATEGORY_MAILBOX_CREATION = 2;
	int TICKET_CATEGORY_NETWORK_ISSUES = 3;
}

public class MainUI implements MenuSelections  {
	
	private static TicketServiceImpl ticketService;
	
	
	public MainUI() {
		super();
		ticketService = new TicketServiceImpl();
	}
	
	
	public static void main(String[] args) {
		
		MainUI mainUI = new MainUI();
		
		while(true){
			
			
			// show menu to user
			mainUI.showMenu();
			
			// process the choices form the user and perform the necessary operations on it.
			mainUI.processChoice();
			
		}
		
	}
	
	
	private void processChoice(){
		
		Scanner scanner = new Scanner(System.in);
		switch(scanner.nextInt()){
			
		case RAISE_TICKET: raiseNewTicket(); break;
		case EXIT_APPLICATION: System.exit(0); break;
		default:
			System.out.println("Enter valid Option");
			System.out.print("\n");
			break;
		}
		
		return;
	}
	
	private void raiseNewTicket() {
		
		// creating new ticket bean for storing ticket info
		TicketBean ticketBean = new TicketBean();
		
		// getting the list of ticket category from database for to select.
		ArrayList<TicketCategory> ticketCategoryList = null;
		try {
			ticketCategoryList = (ArrayList<TicketCategory>) ticketService.listTicketCategory();
		} catch (RaiseTicketException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1.getMessage());
		}
		
		
		// Asking user to select the ticket category.
		System.out.println("----------------------------------------------");
		System.out.println("Enter the Details : ");
		System.out.print("\n");
		
		// showing all ticket category to user.
		showCategoryList(ticketCategoryList);
		
		// used to trap user in loop as long as he does choose the valid ticket category.
		boolean categoryStatus = false;
		
		
		
		// loop for selecting ticket category.
		do{
			Scanner scanner = new Scanner(System.in);
			
			int choice = -1;
			
			try{
				choice = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Enter Integer value only");
				System.out.print("\n");
			}
			
			
			if(choice <= ticketCategoryList.size()){
				ticketBean.setTicketCategoryId(
						ticketCategoryList.get(choice-1).getTicketCategoryId());
				categoryStatus = true;
			}else{
				System.out.println("Please enter a valid option Example(1)");
				System.out.print("\n");
				showCategoryList(ticketCategoryList);
			}
			
//			switch(choice){
//				case TICKET_CATEGORY_SOFTWARE_INSTALLATION:
//					ticketBean.setTicketCategoryId(
//							ticketCategoryList.get(TICKET_CATEGORY_SOFTWARE_INSTALLATION-1).getTicketCategoryId());
//					categoryStatus = true;
//					break;
//				case TICKET_CATEGORY_MAILBOX_CREATION:
//					ticketBean.setTicketCategoryId(
//							ticketCategoryList.get(TICKET_CATEGORY_MAILBOX_CREATION-1).getTicketCategoryId());
//					categoryStatus = true;
//					break;
//				case TICKET_CATEGORY_NETWORK_ISSUES:
//					ticketBean.setTicketCategoryId(
//							ticketCategoryList.get(TICKET_CATEGORY_NETWORK_ISSUES-1).getTicketCategoryId());
//					categoryStatus = true;
//					break;
//				default:
//					System.out.println("Please enter a valid option Example(1)");
//					System.out.print("\n");
//					showCategoryList(ticketCategoryList);
//			
//			}
		}while(!categoryStatus);
		
		// Asking user to enter description for the ticket.
		System.out.println("Enter Ticket Description");
		System.out.print("\n");
		
		String ticketDescription;
		
		// loop for entering the ticket description.
		do{
			Scanner scanner = new Scanner(System.in);
			ticketDescription = scanner.nextLine();
			
		}while(!ValidateInput.validateTicketDescription(ticketDescription));
		
		ticketBean.setTicketDescription(ticketDescription);
		
		
		// used to trap user in loop as long as he does choose the valid ticket priority.
		boolean priorityStatus = false;
		
		// loop for selecting valid ticket priority.
		do{	
			System.out.println("Enter Priority (1.low 2.medium 3.high).");
			Scanner scanner = new Scanner(System.in);
			int choice = -1;
			
			try{
				choice = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Enter Integer value only");
				System.out.print("\n");
			}
			
			switch(choice){
				case TICKET_PRIORITY_LOW:
						ticketBean.setTicketPriority(TICKET_PRIORITY_LOW_VALUE);
						priorityStatus = true;
					break;
				case TICKET_PRIORITY_MEDIUM:
					ticketBean.setTicketPriority(TICKET_PRIORITY_MEDIUM_VALUE);
					priorityStatus = true;
					break;
				case TICKET_PRIORITY_HIGH:
					ticketBean.setTicketPriority(TICKET_PRIORITY_HIGH_VALUE);
					priorityStatus = true;
					break;
				default:
					System.out.println("Please enter a valid option Example(1)");
					System.out.print("\n");
			}
			
		}while(!priorityStatus);
		
		
		ticketBean.setTicketStatus(TICKET_STATUS);
		
		
		// Asking user to enter the ticket comment.
		System.out.println("Enter Ticket comment");
		System.out.print("\n");
		
		String ticketComment;
		
		// loop for entering the ticket comment.
		do{
			Scanner scanner = new Scanner(System.in);
			ticketComment = scanner.nextLine();
			
		}while(!ValidateInput.validateTicketItimedComments(ticketComment));
		
		ticketBean.setItimedComments(ticketComment);
		
		
		// adding the ticket bean to database.
		try {
			if(ticketService.raiseNewTicket(ticketBean))
				System.out.println("Ticket number "+ ticketService.getUserticketNo() +" logged successfully at " + LocalDateTime.now());
				
			System.out.println("\t");
		} catch (RaiseTicketException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	// method to iterate over the category list and show them to user.
	private void showCategoryList(ArrayList<TicketCategory> ticketCategoryList) {
		
		if(ticketCategoryList == null)
			return;
		
		System.out.print("\n");
		System.out.println("Select Ticket Category from below List:");
		for(int i= 0;i < ticketCategoryList.size(); i++){
			System.out.println((i+1) + ". " + ticketCategoryList.get(i).getCategoryName());
		}
		
	}

	// method for showing menu to user.
	private void showMenu(){
		System.out.println("Welcomw to ITIMD Help Desk");
		System.out.println("1. Raise a Ticket");
		System.out.println("2. Exit from the System");
	}
	
}

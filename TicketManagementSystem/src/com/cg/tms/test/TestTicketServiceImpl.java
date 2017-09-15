package com.cg.tms.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.tms.dto.TicketBean;
import com.cg.tms.service.TicketService;
import com.cg.tms.service.TicketServiceImpl;

public class TestTicketServiceImpl {
	
	static private TicketService ticketService;
	private static TicketBean newTicket;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ticketService = new TicketServiceImpl();
		newTicket = new TicketBean("tc001","dummy ticket","low","new","dummy ticket for test case");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		newTicket = null;
		ticketService = null;
	}	

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRaiseNewTicket() {
		
		try {
			
			assertEquals(true, ticketService.raiseNewTicket(newTicket));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListTicketCategory() {
		
		try {
			assertNotNull(ticketService.listTicketCategory());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

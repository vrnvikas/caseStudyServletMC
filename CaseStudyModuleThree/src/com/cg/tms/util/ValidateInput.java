package com.cg.tms.util;

import java.util.regex.Pattern;

public class ValidateInput {

	
	
	public static boolean validateTicketDescription(String description){
		
		String ptrn = "[a-zA-Z1-9 .,]{1,50}";
		return Pattern.matches(ptrn, description);
	}

	public static boolean validateTicketItimedComments(String ticketComment) {
		String ptrn = "[a-zA-Z1-9 .,]{1,50}";
		return Pattern.matches(ptrn, ticketComment);
	}
	
	
}

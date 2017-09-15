package com.cg.pmc.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.pmc.dto.UserBean;
import com.cg.tms.exception.UserException;
import com.cg.tms.service.UserService;
import com.cg.tms.service.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private UserService userService;
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
        userService = new UserServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action  = request.getParameter("action");
		
		RequestDispatcher dispatcher = null;
		
		
		
		switch(action){
			
		case "registerUser":
			System.out.println("In doGet register case ");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request,response);
			break;
		
		case "home":
			System.out.println("In doGet home case ");
			HttpSession s = request.getSession(false);
//			if(s != null)
//				System.out.println("user seesion details : " + s.getAttribute("activationCode"));
			dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request,response);
			break;
			
			
		case "activateUser":
			System.out.println("In doGet activate case ");
			dispatcher = request.getRequestDispatcher("activate.jsp");
			dispatcher.forward(request,response);
			break;
		
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = null;
		
		String action  = request.getParameter("action");
		
		System.out.println("doPost called : " +" : " + " action value : " + action);
		
		HttpSession session = request.getSession();
		
		switch(action){
			
			case "register":
				System.out.println("register case");
				
				Random ran = new Random();
				
				
				int activationNo = ran.nextInt(9999);
				
				
				UserBean user = new UserBean();
				
				String firstName = request.getParameter("firstName");
				String middleName = request.getParameter("middleName");
				String lastName = request.getParameter("lastName");
				String businessName = request.getParameter("businessName");
				String emailId = request.getParameter("emailId");
				long mobileNo = Long.parseLong(request.getParameter("mobileNo"));
				
				
				user.setFirstName(firstName);
				user.setMiddleName(middleName);
				user.setLastName(lastName);
				user.setBusinessName(businessName);
				user.setEmailId(emailId);
				user.setMobileNo(mobileNo);
				user.setActive(false);
				
				System.out.println("User from Foam");
				System.out.println(user);
				
				int userId = -1;
				
				try {
					userId = userService.addUser(user);
					
					request.setAttribute("userId", userId);
					
					session.setAttribute("activationCode", activationNo);
					session.setAttribute("emailId", emailId);
					
					dispatcher = request.getRequestDispatcher("success.jsp");
					dispatcher.forward(request,response);
					
				} catch (UserException e) {
					
					request.setAttribute("userException", e.getMessage());
					dispatcher = request.getRequestDispatcher("error.jsp");
					dispatcher.forward(request,response);
				}
				

				break;
				
			case "activate":
				
				
				String email = request.getParameter("emailId");
				int activationCodeEntered = Integer.parseInt(request.getParameter("activationCode"));
				
				int sessionActivationCode = (int) session.getAttribute("activationCode");
				String SessionEmail = (String) session.getAttribute("emailId");
				
				if(activationCodeEntered == sessionActivationCode && SessionEmail.equals(email)){
					System.out.println("in activation process");
					
					try {
						
						boolean status = userService.activateUser(email);
						System.out.println("account activated : " + status);
						
						session.invalidate();
						request.setAttribute("message", LocalDate.now());
						dispatcher = request.getRequestDispatcher("message.jsp");
						dispatcher.forward(request,response);	
						
					} catch (UserException e) {
						// TODO Auto-generated catch block
						request.setAttribute("userException", e.getMessage());
						dispatcher = request.getRequestDispatcher("error.jsp");
						dispatcher.forward(request,response);
					}
					
				}
				
				break;

		}
		
		
	}

}

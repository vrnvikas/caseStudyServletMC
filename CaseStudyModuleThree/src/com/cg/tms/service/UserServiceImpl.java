package com.cg.tms.service;

import java.util.List;

import com.cg.pmc.dto.UserBean;
import com.cg.tms.dao.UserDAO;
import com.cg.tms.dao.UserDAOImpl;
import com.cg.tms.exception.UserException;

public class UserServiceImpl implements UserService {
	
	
	UserDAO userDAO;
	public static int ticketNo = -1;
	
	public UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}

	@Override
	public int addUser(UserBean userBean) throws UserException {
		// TODO Auto-generated method stub
		return userDAO.addUser(userBean);
	}

	@Override
	public boolean activateUser(String email) throws UserException {
		// TODO Auto-generated method stub
		return userDAO.activateUser(email);
	}


	
}

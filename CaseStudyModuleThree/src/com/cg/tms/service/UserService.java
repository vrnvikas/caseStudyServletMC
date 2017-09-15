package com.cg.tms.service;

import java.util.List;

import com.cg.pmc.dto.UserBean;
import com.cg.tms.exception.UserException;

public interface UserService {
	
	int addUser(UserBean userBean) throws UserException;
	boolean activateUser(String email) throws UserException;
}

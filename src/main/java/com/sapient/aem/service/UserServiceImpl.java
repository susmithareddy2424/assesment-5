package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.UserDAO;
import com.sapient.aem.dao.UserDaoImpl;
import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.User;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO=  new UserDaoImpl();

	@Override
	public List<User> getUser() throws UserException {
		
		try {
			List<User> userList=userDAO.getUser();
			return userList; 
		}catch(SQLException e) {
			
			throw new UserException(e.getMessage(),e);
		}
	}

	
}

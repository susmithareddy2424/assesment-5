package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;

public interface UserService {
	public abstract List<User> getUser()throws UserException;
}

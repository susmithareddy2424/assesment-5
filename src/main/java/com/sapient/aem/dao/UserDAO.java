package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.User;

public interface UserDAO {
	public abstract List<User> getUser()throws SQLException;
}

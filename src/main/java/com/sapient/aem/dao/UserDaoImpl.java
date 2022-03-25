package com.sapient.aem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;

public class UserDaoImpl implements UserDAO{

	@Override
	public List<User> getUser() throws SQLException {
		String sql="select * from user";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement();

			ResultSet resultSet= statement.executeQuery(sql);
			
			List<User> userList=new ArrayList<>();			
			while(resultSet.next()) {
				User user=new User();
				populateUser(resultSet,user);
				userList.add(user);		
			}

			return userList ;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
		
	}

	private void populateUser(ResultSet resultSet, User user) throws SQLException {
		
		user.setUserId(resultSet.getInt("user_id"));
		user.setUserName(resultSet.getString("user_name"));
		user.setPassword(resultSet.getString("password"));
		try {
			String role= resultSet.getString("role");
			Role myRole=null;
			if(role.equals("ADMIN")) {
				myRole= Role.ADMIN;
			}else if(role.equals("MANAGER")) {
				myRole=Role.DOCTOR;
			}
			else if(role.equals("MANAGER")) {
				myRole=Role.PATIENT;}
			else {
				myRole=null;
			}
		user.setRole(myRole);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
}

package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.User;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;

@WebServlet("/get-all-users")
public class GettingUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserService userService= new UserServiceImpl();
	private Logger logger= Logger.getLogger(GettingUserServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			List<User> userList=  userService.getUser();
			
			request.setAttribute("userList",userList );
			request.getRequestDispatcher("WEB-INF/views/get-all-user.jsp").forward(request, response);
		
			
		}catch(UserException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

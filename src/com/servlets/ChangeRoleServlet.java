package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.UserBL;
import com.entities.User;

import sun.nio.cs.US_ASCII;


public class ChangeRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ChangeRoleServlet() {
  
    }
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	   String path = getServletContext().getRealPath("");
		
	   String userName = request.getParameter("username");
	   String role = request.getParameter("role");
	   
		UserBL userbl = new UserBL(path);
		userbl.ChangeRole(userName, role);
		
		String message = userName + " change role to: " + role;
		
		response.getWriter().write(message);
		
	}



}

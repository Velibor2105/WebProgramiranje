package com.servlets;

import java.io.IOException;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.business.UserBL;
import com.entities.User;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    String path = getServletContext().getRealPath("");
	    
		String userName = request.getParameter("username");
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		UserBL userbl = new UserBL(path);
		
		User user = new User(userName, password, name, surname,"user", phone, email, new Date());
				
	    boolean success = userbl.AddUser(user);
	    
	    String message = success ? "User is successfully added" : "User alredy exist";

	    response.getWriter().write(message);
	}

}

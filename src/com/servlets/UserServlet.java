package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.User;


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UserServlet() {
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user != null){
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/adminpage.jsp");
			disp.forward(request, response);
			return;
		}
		else
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entities.User;



public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminServlet() {
        super();
      
    }


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    User user = (User)request.getSession().getAttribute("user");
		if(user != null)
		{
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/adminpage.html");
			disp.forward(request, response);
		}else
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post");
	}

}

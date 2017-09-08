package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.UserBL;
import com.entities.User;



public class UserBackOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private ArrayList<User> users;
  
    public UserBackOfficeServlet() {
        super();
      
    }




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user != null){
			
			UserBL userbl = new UserBL("");
			ServletContext ctx = getServletContext();
			users = userbl.GetUsers();
			ctx.setAttribute("users", users);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/userbackoffice.jsp");
			disp.forward(request, response);
			return;
		}else
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
	   
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

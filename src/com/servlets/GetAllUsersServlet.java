package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.business.UserBL;
import com.entities.User;
import com.google.gson.Gson;


public class GetAllUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ArrayList<User> users;
       
    public GetAllUsersServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		UserBL userbl = new UserBL(path);
		
		users = userbl.GetUsers();
		String json = new Gson().toJson(users);
		 response.getWriter().write(json.toString());
		
		
	}

}

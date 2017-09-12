package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.UserBL;
import com.google.gson.Gson;

public class GetAllModeratorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetAllModeratorsServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String path = getServletContext().getRealPath("");
		UserBL userBL = new UserBL(path);
		
		String json = new Gson().toJson(userBL.GetModerators());
		response.getWriter().write(json.toString());
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

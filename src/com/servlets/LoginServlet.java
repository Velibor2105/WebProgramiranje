package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.business.LoginBL;
import com.business.UserBL;
import com.entities.User;


//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	
    public LoginServlet() {
        super();
       
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    String path = getServletContext().getRealPath("");
		    LoginBL loginBl = new LoginBL(path);
			UserBL userBL = new UserBL();
			User user = new User();
			
			String userName = request.getParameter("username");
			String passWord = request.getParameter("password");
			
	        user = loginBl.DoLogin(userName, passWord);
			
	        response.getWriter().write(userBL.GetUserRole(user));
	}
}



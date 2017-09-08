package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ForumBL;
import com.business.UserBL;
import com.entities.Forum;
import com.entities.User;


public class ForumBackOfficeServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;
	 private ArrayList<Forum> forums;
	 private ArrayList<User> moderators;
	 
    public ForumBackOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		if(user != null){
			
			ServletContext ctx = getServletContext();
			
			UserBL userbl = new UserBL("");
			moderators = userbl.GetModerators();
			ctx.setAttribute("moderators", moderators);
			
	
			ForumBL forumbl = new ForumBL();
			forums = forumbl.GetForums();
			ctx.setAttribute("forums", forums);
			
			RequestDispatcher disp = getServletContext().getRequestDispatcher("/forumbackoffice.jsp");
			disp.forward(request, response);
			return;
		}else
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sdf");
		String userName = request.getParameter("file");
		String passWord = request.getParameter("password");
	}

}

package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
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


@WebServlet("/TT")
public class StartupServlet extends HttpServlet {
	
	private ArrayList<Forum> forums;
	private ArrayList<User> users;
	private String path;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		path = getServletContext().getRealPath("");
		
		ForumBL fbl = new ForumBL(path);
		UserBL ubl = new UserBL(path);
		
		ServletContext ctx = getServletContext();
		forums = fbl.GetForums();
		ctx.setAttribute("forums", forums);
		
	
		users = ubl.GetUsers();
		ctx.setAttribute("users", users);
		
		
		 
		 
	}

	private static final long serialVersionUID = 1L;
       
    public StartupServlet() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

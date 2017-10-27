package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ForumBL;
import com.entities.Forum;
import com.helpers.Helpers;



public class AddNewForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddNewForumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String rules = request.getParameter("rules");
		String moderator = request.getParameter("moderator");
		String moderators = request.getParameter("moderators");
		String icon = request.getParameter("icon");
	    ArrayList<String> listModerators = Helpers.convertStringToArrayList(moderators);
	    
	    ForumBL forumBL = new ForumBL(path);
	    
	    Forum forum = new Forum(name,description,rules,moderator,listModerators,icon);
	    
	    response.getWriter().write(forumBL.AddForum(forum));   
		
	}

}

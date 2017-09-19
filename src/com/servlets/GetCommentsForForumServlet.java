package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.CommentBL;
import com.google.gson.Gson;

public class GetCommentsForForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetCommentsForForumServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		
		String forum = request.getParameter("forum");
		
		CommentBL commentBl = new CommentBL(path);
		
		String json = new Gson().toJson(commentBl.GetCommentsByForum(forum));
		
		response.getWriter().write(json.toString());
		//Aelyria
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

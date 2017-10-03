package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.CommentBL;
import com.entities.Comment;
import com.google.gson.Gson;

public class AddCommentDisLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddCommentDisLikeServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = getServletContext().getRealPath("");
		
		String userName = request.getParameter("userName");
		String forum = request.getParameter("forum");
		String commentId = request.getParameter("commentId");
		
		CommentBL commentBl = new CommentBL(path);
		
		ArrayList<Comment> comments = commentBl.AddCommentDisLike(userName, forum, commentId);
		
		String json = new Gson().toJson(comments);
		response.getWriter().write(json);
	}

}

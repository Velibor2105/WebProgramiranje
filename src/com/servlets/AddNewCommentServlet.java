package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.CommentBL;
import com.entities.Comment;

public class AddNewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddNewCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		
		String forum = request.getParameter("forum");
		String theme = request.getParameter("theme");
		String author = request.getParameter("author");
		String content = request.getParameter("content");
		String parentId = request.getParameter("parentId");
		
		CommentBL commentBl = new CommentBL(path);
		
		Comment comment = new Comment(forum, theme, author, commentBl.GenerateNextCommentId(), new Date(), content, 0, 0, false, new ArrayList<Comment>());
		
		String resp = null;
		boolean res = commentBl.AddComment(Integer.parseInt(parentId), comment);
		if(res)
			resp = "Success";
		else
			resp = "Fail";
		
		response.getWriter().write(resp);
		
	}

}

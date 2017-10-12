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


public class EditCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditCommentServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		
		String id = request.getParameter("id");
		String forum = request.getParameter("forum");
		String content = request.getParameter("content");
		
		CommentBL commentBl = new CommentBL(path);
		
		ArrayList<Comment> comments = commentBl.EditCommetnt(Integer.parseInt(id), content, forum);
		
		
		String json = new Gson().toJson(comments);
		response.getWriter().write(json);
				
	}

}

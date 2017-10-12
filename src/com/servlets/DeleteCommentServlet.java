package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.CommentBL;

public class DeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public DeleteCommentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		
		String id = request.getParameter("id");
		
		CommentBL commentBl = new CommentBL(path);
	 			
	    boolean success = commentBl.DeleteCommentById(Integer.parseInt(id));
		  
		response.getWriter().write(String.valueOf(success));
		
	}

}
 
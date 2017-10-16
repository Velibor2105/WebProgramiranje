package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.*;

public class DeleteForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DeleteForumServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		
		String forum = request.getParameter("forum");
		
		ForumBL forumBl = new ForumBL(path);
		
		forumBl.DeleteForumByName(forum);
		
		response.getWriter().write("success");
	}

}

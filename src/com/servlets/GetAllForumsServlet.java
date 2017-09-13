package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ForumBL;
import com.google.gson.Gson;
public class GetAllForumsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public GetAllForumsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");

		ForumBL forumBL = new ForumBL(path);
		
		String json = new Gson().toJson(forumBL.GetForums());
		response.getWriter().write(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

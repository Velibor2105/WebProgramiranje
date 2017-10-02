package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ThemeBL;

public class AddRemoveDisLikesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddRemoveDisLikesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		
		String userName = request.getParameter("userName");
		String theme = request.getParameter("theme");
		
		ThemeBL themeBl = new ThemeBL(path);
		
		int res = themeBl.AddRemoveDisLike(userName, theme);
		
		response.getWriter().write(Integer.toString(res));
	}

}

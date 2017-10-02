package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ThemeBL;

public class GetDisLikesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public GetDisLikesServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		
		String theme = request.getParameter("theme");
		ThemeBL themeBl = new ThemeBL(path);
		response.getWriter().write(Integer.toString(themeBl.GetDisLikes(theme)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

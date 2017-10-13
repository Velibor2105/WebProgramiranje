package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ThemeBL;
import com.google.gson.Gson;


public class EditThemeTextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditThemeTextServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		
		String theme = request.getParameter("theme");
		String forum = request.getParameter("forum");
		String content = request.getParameter("content");
		
		ThemeBL themeBl = new ThemeBL(path);
		
		String json = new Gson().toJson(themeBl.EditThemeText(theme, forum, content));
		response.getWriter().write(json);
	}

}

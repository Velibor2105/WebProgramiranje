package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ThemeBL;
import com.google.gson.Gson;

public class GetThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetThemeServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = getServletContext().getRealPath("");
		String forum = request.getParameter("forum");
		ThemeBL themeBL = new ThemeBL(path);
		
		String json = new Gson().toJson(themeBL.GetThemesForForumName(forum));
		response.getWriter().write(json.toString());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}

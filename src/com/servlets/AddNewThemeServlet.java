package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.ThemeBL;
import com.entities.Theme;

public class AddNewThemeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddNewThemeServlet() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String forum = request.getParameter("forum");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String type = request.getParameter("type");
		String content = request.getParameter("content");
		String negativeVotes = request.getParameter("negativeVotes");
		String positiveVotes = request.getParameter("positiveVotes");
		String base64 = request.getParameter("bitArray");
		String link = request.getParameter("link");
		
		String path = getServletContext().getRealPath("");
		
		ThemeBL themeBL = new ThemeBL(path);
		ArrayList<String> likes = new ArrayList<String>();
		ArrayList<String> disLikes = new ArrayList<String>();
		Theme theme = new Theme(forum,title,type,author,content,likes,disLikes,new Date(),Integer.parseInt(negativeVotes),Integer.parseInt(positiveVotes),base64,link);
		
		String resp = themeBL.AddTheme(theme) == true ? "success" : "fail";
		
	    response.getWriter().write(resp);	
	}

}

package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.MessageBL;
import com.google.gson.Gson;
 
public class GetMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetMessagesServlet() {
        super();
 
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		
		String reciver = request.getParameter("reciver");
		
		MessageBL messageBl = new MessageBL(path);
		
		String json = new Gson().toJson(messageBl.GetMessagesForReceiver(reciver));
		response.getWriter().write(json.toString());
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}

}

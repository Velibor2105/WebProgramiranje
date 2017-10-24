package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.business.MessageBL;

 
public class SendMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SendMessageServlet() {
        super();
   
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = getServletContext().getRealPath("");
		
		String sender = request.getParameter("sender");
		String reciver = request.getParameter("reciver");
		String body = request.getParameter("message");
		
		MessageBL messageBl = new MessageBL(path);
		
		boolean res = messageBl.AddMessage(sender, reciver, body);
		
		response.getWriter().write(String.valueOf(res));
		
	}

}

package com.business;

import java.util.ArrayList;

import com.dal.MessageRepository;
import com.entities.Message;

public class MessageBL {

	private ArrayList<Message> messages = null;
	private MessageRepository mr = null;
	
	
	public MessageBL(String path){
		mr = new MessageRepository(path);
		messages = mr.GetMessages();
	}
	
	
	public boolean AddMessage(String sender, String reciver, String body) {
		
		Message message = new Message(sender,reciver,body,false);
		return mr.AddTheme(message);
		
	}
	
}
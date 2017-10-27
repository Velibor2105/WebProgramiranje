package com.dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.entities.Message;




public class MessageRepository {

	private String path = null;
	private ArrayList<Message> messages = null;
	

	public MessageRepository(String path) {
		this.path = "C:\\";
		this.messages = GetAllMessages();
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<Message> GetAllMessages() {
		
        ArrayList<Message> messagesIn = new ArrayList<Message>();
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			 fin = new FileInputStream(this.path + "data\\messages.txt");
			 ois = new ObjectInputStream(fin);
			 messagesIn = (ArrayList<Message>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
		    if(ois  != null){
		        try {
		        	ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
		return messagesIn;
	}
	
	public boolean AddTheme(Message message) {
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		this.messages.add(message);
		try 
		{
		    fout = new FileOutputStream(this.path + "data\\messages.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(this.messages);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
		    if(oos  != null){
		        try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
		return true;
	}
	
	public ArrayList<Message> GetMessages(){
		return messages;
	}
}

package com.entities;

public class Message implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Sender;
	private String Reciver;
	private String Body;
	private boolean Seen;
	
	public Message(String sender, String reciver, String body, boolean seen) {
		super();
		Sender = sender;
		Reciver = reciver;
		Body = body;
		Seen = seen;
	}
	
	public String getSender() {
		return Sender;
	}
	public void setSender(String sender) {
		Sender = sender;
	}
	public String getReciver() {
		return Reciver;
	}
	public void setReciver(String reciver) {
		Reciver = reciver;
	}
	public String getBody() {
		return Body;
	}
	public void setBody(String body) {
		Body = body;
	}
	public boolean isSeen() {
		return Seen;
	}
	public void setSeen(boolean seen) {
		Seen = seen;
	}
	
	

}

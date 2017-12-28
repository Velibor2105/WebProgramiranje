package com.dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.entities.Comment;

public class CommentRepositiry {

	private String path = null;
	private ArrayList<Comment> comments = null;
	

	public CommentRepositiry(String path) {
		this.path = path;
		this.comments = GetAllComments();
	}


	@SuppressWarnings("unchecked")
	private ArrayList<Comment> GetAllComments() {
		
        ArrayList<Comment> commentsIn = new ArrayList<Comment>();
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			 fin = new FileInputStream(this.path + "\\data\\comments.txt");
			 ois = new ObjectInputStream(fin);
			 commentsIn = (ArrayList<Comment>) ois.readObject();
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
		return commentsIn;
	}
	
	public boolean AddComment(Comment comment) {
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		this.comments.add(comment);
		try 
		{
		    fout = new FileOutputStream(this.path + "\\data\\comments.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(this.comments);
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
	
public boolean AddComments(ArrayList<Comment> comments) {
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try 
		{
		    fout = new FileOutputStream(this.path + "\\data\\comments.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(comments);
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
	
	
	public ArrayList<Comment> GetComments(){
		return comments;
	}
	
}

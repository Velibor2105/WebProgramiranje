package com.dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.entities.Forum;
import com.entities.User;

public class ForumRepository {
	
	private String path = null;
	private ArrayList<Forum> forums = null;
	

	public ForumRepository(String path) {
		this.path = path;
		this.forums = GetAllForums();
	}

	@SuppressWarnings("unchecked")
	private  ArrayList<Forum> GetAllForums(){
		
	ArrayList<Forum> forums = new ArrayList<Forum>();
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			 fin = new FileInputStream("./WebContent/data/forums.txt");
			 ois = new ObjectInputStream(fin);
			 forums = (ArrayList<Forum>) ois.readObject();
		} catch (Exception e) {
			System.out.println("exception");
		} finally{
		    if(ois  != null){
		        try {
		        	ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
		return forums;
	}
	

	public  String AddForum(Forum forum){
				
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		this.forums.add(forum);
		try 
		{
		    fout = new FileOutputStream("./WebContent/data/forums.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(this.forums);
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
		return forum.getName();
	}
		
	public  Forum GetForumById(String id){
		
		 for (int i = 0; i < this.forums.size(); i++) 
			if (forums.get(i).getName().equals(id))
				return forums.get(i);
		 
        return null;
	}
	
	public static void UpdateUserById(String id){
		
	}
	public static void DeleteUserById(String id){
		
	}

	public ArrayList<Forum> GetForums() {
		return forums;
	}

}

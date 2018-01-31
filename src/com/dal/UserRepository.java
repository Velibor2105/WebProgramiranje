package com.dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.entities.User;

public class UserRepository {
	
	private String path = null;
	private ArrayList<User> users = null;
	

	public UserRepository(String path) {
		this.path = "C:";
		this.users = GetAllUsers();
	}


	@SuppressWarnings("unchecked")
	private  ArrayList<User> GetAllUsers(){
		
	ArrayList<User> users = new ArrayList<User>();
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			 fin = new FileInputStream(this.path + "\\data\\users.txt");
			 ois = new ObjectInputStream(fin);
			 users = (ArrayList<User>) ois.readObject();
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
		return users;
	}
	
	public  String AddUser(User user){
				
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		this.users.add(user);
		try 
		{
		    fout = new FileOutputStream(this.path + "\\data\\users.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(this.users);
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
		return user.getSurName();
	}
		
	public  User GetUserById(String id){
		
		 for (int i = 0; i < this.users.size(); i++) 
			if (users.get(i).getUserName().equals(id))
				return users.get(i);
		 
        return null;
	}
	
	public  void UpdateUser(User user){
		
		DeleteUserById(user.getUserName());
		
		AddUser(user);
		
	}
	public void DeleteUserById(String id){
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getUserName().equals(id)){
			   users.remove(i);
			}
		}
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
	
		try 
		{
		    fout = new FileOutputStream(this.path + "\\data\\users.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(users);
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
		
	}
	
	public ArrayList<User> GetUsers() {
		return users;
	}

}

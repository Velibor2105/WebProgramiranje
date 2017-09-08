package com.business;

import java.util.ArrayList;

import com.dal.UserRepository;
import com.entities.User;

public class UserBL {
	
	private ArrayList<User> users = null;
	private UserRepository ur = null;
	
	public UserBL(){
		
	}
	
	public UserBL(String path){
		ur = new UserRepository(path);
		users = ur.GetUsers();
	}
	
	public boolean AddUser(User user){
		if(UserExist(user))
			return false;
		
		ur.AddUser(user);
		
		return true;
	}
	
	public ArrayList<User> GetUsers(){
		return users;
	}
	
	private boolean UserExist(User user){
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserName().equals(user.getUserName())) 
				return true;
		}
		return false;
	}

	public void ChangeRole(String username, String role){
		
		User user = ur.GetUserById(username);
		user.setRole(role);
		ur.UpdateUser(user);
		
	}
	
	public ArrayList<User> GetModerators(){
		ArrayList<User> moderators = new ArrayList<User>();
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getRole().equals("moderator")) {
				moderators.add(users.get(i));
			}
		}
		return moderators;
	}
	
	public String GetUserRole(User user) {
		
	    	if(user == null)
			    return "User not exist";
		
			if(user.getRole().equals("admin")) 
				return "admin";
			
			if(user.getRole().equals("moderator"))
				return "moderator";
			
			if(user.getRole().equals("user"))
				return "user";
			
			return "User role not set";
	}
}

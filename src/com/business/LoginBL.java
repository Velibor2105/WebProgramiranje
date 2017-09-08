package com.business;

import com.dal.UserRepository;
import com.entities.User;

public class LoginBL {
	
	private  UserRepository userRepository;
	
	public LoginBL(String path) {
		userRepository = new UserRepository(path);
	}

	public User DoLogin(String username, String password){
		
		User user = userRepository.GetUserById(username);
		
		if(user != null && user.getPassword().equals(password))
		return user;
		
		return null;
	}
}

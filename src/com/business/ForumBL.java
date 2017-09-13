package com.business;

import java.util.ArrayList;

import com.dal.ForumRepository;
import com.entities.Forum;

public class ForumBL {
	
	private ArrayList<Forum> forums = null;
	private ForumRepository fr = null;
	
	public ForumBL(String path) {
		fr = new ForumRepository(path);
		this.forums = fr.GetForums();
	}

	public String AddForum(Forum forum) {
		if(!ForumExist(forum))
	       return fr.AddForum(forum);
		
		return "Forum alredy exist!";
	}
	
	public ArrayList<Forum> GetForums(){
	    return forums;
	}
	
	private boolean ForumExist(Forum forum) {
		
		for (Forum f : forums) 
			if(f.getName() == forum.getName()) return true;
		
		return false;
	}
}

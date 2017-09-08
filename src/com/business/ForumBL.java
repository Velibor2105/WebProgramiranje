package com.business;

import java.util.ArrayList;

import com.dal.ForumRepository;
import com.entities.Forum;

public class ForumBL {
	
	private ArrayList<Forum> forums = null;
	
	public ForumBL() {
		ForumRepository fr = new ForumRepository("");
		this.forums = fr.GetForums();
	}

	public ArrayList<Forum> GetForums(){
	    return forums;
	}
}

package com.business;

import java.util.ArrayList;

import com.dal.CommentRepositiry;
import com.entities.Comment;

public class CommentBL {

	private ArrayList<Comment> comments = null;
	private CommentRepositiry cr = null;
	
	public CommentBL(String path) {
		cr = new CommentRepositiry(path);
		this.comments = cr.GetComments();
	}
	
	
	
}

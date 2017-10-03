package com.business;

import java.util.ArrayList;


import com.dal.CommentRepositiry;
import com.entities.Comment;
import com.helpers.Helpers;

public class CommentBL {

	private ArrayList<Comment> comments = null;
	private CommentRepositiry cr = null;
	
	public CommentBL(String path) {
		cr = new CommentRepositiry(path);
		this.comments = cr.GetComments();
	}
	
	
	public ArrayList<Comment> GetCommentsByForumAndTheme(String forum, String theme){
		
		ArrayList<Comment> retVal = new ArrayList<Comment>();
		for (Comment comment : comments) {
			if(comment.getForum().equals(forum) && comment.getTheme().equals(theme))
				retVal.add(comment);
		}
		return retVal;
	}
	
	public ArrayList<Comment> GetCommentsByForum(String forum){
		
		ArrayList<Comment> retVal = new ArrayList<Comment>();
		for (Comment comment : comments) {
			if(comment.getForum().equals(forum))
				retVal.add(comment);
		}
		return retVal;
	}
	
	public Comment GetCommentById(int id){
		for (Comment comment : comments) {
			if(comment.getCommentId() == id)
				return comment;
		}
		return null;
	}
	
	public boolean AddComment(int parentId, Comment c) {
		
		Comment cmt = GetCommentById(parentId);
		
		if(parentId == 0) {
			cr.AddComment(c);
			return true;
		}
		
		for (Comment comment : comments) {
		  Comment cmnt = Helpers.search(comment, parentId);
			if(cmnt != null) {
				cmnt.getContain().add(c);
				cr.AddComments(comments);
				return true;
			}
		}
		return false;
	}
	
	public int GenerateNextCommentId() {
		ArrayList<Integer> intLIst = new ArrayList<Integer>();
		ArrayList<Integer> intLIst1 = new ArrayList<Integer>();
		intLIst1 =  Helpers.GetMax(comments, intLIst);
		
		int max = 0;
		for (Integer integer : intLIst1) {
			if(integer >= max)
				max = integer;
		}
	   
	   return max + 1;
	}

	
	public ArrayList<Comment> GetComments(){
	    return comments;
	}
	
	public void AddCommentLike() {
		
	}
	
	
}

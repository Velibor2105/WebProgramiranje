package com.business;

import java.util.ArrayList;


import com.dal.CommentRepositiry;
import com.entities.Comment;
import com.helpers.Helpers;

public class CommentBL {

	private ArrayList<Comment> comments = null;
	private CommentRepositiry cr = null;
	
	private ArrayList<Comment> DeleteComments(ArrayList<Comment> coms, int id){
		
		Comment c = GetCommentById(id);
		coms.remove(c);
		
		for (Comment comment : coms) {
			comment.getContain().remove(c);
			this.DeleteComments(comment.getContain(), id);
		}
		return coms;
	}
	
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
		for (Comment c : comments) {
			  Comment cmnt = Helpers.search(c, id);
				if(cmnt != null) {
					return cmnt;
				}
		}
		return null;
	}
	
	public boolean DeleteCommentById(int id) {
		
	    ArrayList<Comment> cc = DeleteComments(comments,id);
	    cr.AddComments(cc);
		return true;
	
	}
	
	public boolean AddComment(int parentId, Comment c) {
		
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
	
	public ArrayList<Comment> EditCommetnt(int id, String content, String forum) {
		
	Comment comment = null;
		
		for (Comment c : comments) {
			  Comment cmnt = Helpers.search(c, id);
				if(cmnt != null) {
					comment = cmnt;
				}
		}
		comment.setContent(content);
		
		cr.AddComments(comments);
		
		return GetCommentsByForum(forum);
	}
	
	public ArrayList<Comment> AddCommentLike(String userName, String forum, String commentId) {
		
		Comment comment = null;
		
		for (Comment c : comments) {
			  Comment cmnt = Helpers.search(c, Integer.parseInt(commentId));
				if(cmnt != null) {
					comment = cmnt;
				}
			}
		
		if(comment.getDisLikes().contains(userName)) 
			comment.getDisLikes().remove(userName);
		
		if(comment.getLikes().contains(userName)) 
			comment.getLikes().remove(userName);
		else	
			comment.getLikes().add(userName); 
		
		comment.setPositiveVotes(comment.getLikes().size()); 
		comment.setNegativeVotes(comment.getDisLikes().size());
		
		cr.AddComments(comments);
		
		return GetCommentsByForum(forum);
	}
	
    public ArrayList<Comment> AddCommentDisLike(String userName, String forum, String commentId) {
		
		Comment comment = null;
		
		for (Comment c : comments) {
			  Comment cmnt = Helpers.search(c, Integer.parseInt(commentId));
				if(cmnt != null) {
					comment = cmnt;
				}
		}
		
		if(comment.getLikes().contains(userName)) 
			comment.getLikes().remove(userName);
		
		if(comment.getDisLikes().contains(userName)) 
			comment.getDisLikes().remove(userName);
		else	
			comment.getDisLikes().add(userName); 
		
		comment.setPositiveVotes(comment.getLikes().size()); 
		comment.setNegativeVotes(comment.getDisLikes().size());
		
		cr.AddComments(comments);
		
		return GetCommentsByForum(forum);
	}
	
}

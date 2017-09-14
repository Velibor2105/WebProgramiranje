package com.entities;

import java.util.Date;

public class Theme {
	
	private String ParentForum;
	private String Title;
	private String Type;
	private String Author;
	private String Content;
	private String Comments; //ovo ce biti novi entitet
	private Date DateOfCreation; 
	private int PositiveVotes;
	private int NegativeVotes;
	
	
	public Theme(String parentForum, String title, String type, String author, String content, String comments, Date dateOfCreation, int positiveVotes, int negativeVotes) {

		ParentForum = parentForum;
		Title = title;
		Type = type;
		Author = author;
		Content = content;
		Comments = comments;
		DateOfCreation = dateOfCreation;
		PositiveVotes = positiveVotes;
		NegativeVotes = negativeVotes;
		
	}


	public String getParentForum() {
		return ParentForum;
	}


	public void setParentForum(String parentForum) {
		ParentForum = parentForum;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}


	public String getComments() {
		return Comments;
	}


	public void setComments(String comments) {
		Comments = comments;
	}


	public Date getDateOfCreation() {
		return DateOfCreation;
	}


	public void setDateOfCreation(Date dateOfCreation) {
		DateOfCreation = dateOfCreation;
	}


	public int getPositiveVotes() {
		return PositiveVotes;
	}


	public void setPositiveVotes(int positiveVotes) {
		PositiveVotes = positiveVotes;
	}


	public int getNegativeVotes() {
		return NegativeVotes;
	}


	public void setNegativeVotes(int negativeVotes) {
		NegativeVotes = negativeVotes;
	}
	
	
	

}

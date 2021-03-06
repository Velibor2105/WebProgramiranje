package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Forum;
	private String Theme;
	private String Author;
	private int CommentId;
	private Date DateOfCreation;
	private String Content;
	private int PositiveVotes;
	private int NegativeVotes;
	private boolean Changed;
	private ArrayList<Comment> Contain;
	private ArrayList<String> likes;
	private ArrayList<String> disLikes;
	private String ThemeAuthor;
	
	public Comment(String forum, String theme, String author, int commentId, Date dateOfCreation, String content,
			int positiveVotes, int negativeVotes, boolean changed, ArrayList<Comment> contain, ArrayList<String> likes,
			ArrayList<String> disLikes, String themeAuthor) {
		super();
		Forum = forum;
		Theme = theme;
		Author = author;
		CommentId = commentId;
		DateOfCreation = dateOfCreation;
		Content = content;
		PositiveVotes = positiveVotes;
		NegativeVotes = negativeVotes;
		Changed = changed;
		Contain = contain;
		this.likes = likes;
		this.disLikes = disLikes;
		ThemeAuthor = themeAuthor;
	}



	public String getThemeAuthor() {
		return ThemeAuthor;
	}

	public void setThemeAuthor(String themeAuthor) {
		ThemeAuthor = themeAuthor;
	}

	public String getForum() {
		return Forum;
	}

	public void setForum(String forum) {
		Forum = forum;
	}

	public String getTheme() {
		return Theme;
	}

	public void setTheme(String theme) {
		Theme = theme;
	}

	public int getCommentId() {
		return CommentId;
	}

	public void setCommentId(int commentId) {
		CommentId = commentId;
	}

	public Date getDateOfCreation() {
		return DateOfCreation;
	}

	public void setDateOfCreation(Date dateOfCreation) {
		DateOfCreation = dateOfCreation;
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

	public boolean isChanged() {
		return Changed;
	}

	public void setChanged(boolean changed) {
		Changed = changed;
	}

	public ArrayList<Comment> getContain() {
		return Contain;
	}

	public void setContain(ArrayList<Comment> contain) {
		Contain = contain;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public ArrayList<String> getLikes() {
		return likes;
	}



	public void setLikes(ArrayList<String> likes) {
		this.likes = likes;
	}



	public ArrayList<String> getDisLikes() {
		return disLikes;
	}



	public void setDisLikes(ArrayList<String> disLikes) {
		this.disLikes = disLikes;
	}
	
	
	

	
	
	
	
	
	
	
}

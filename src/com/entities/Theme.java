package com.entities;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class Theme implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ParentForum;
	private String Title;
	private String Type;
	private String Author;
	private String Content;
	private ArrayList<String> Likes; //ovo ce biti novi entitet
	private ArrayList<String> DisLikes; //ovo ce biti novi entitet
	private Date DateOfCreation; 
	private int PositiveVotes;
	private int NegativeVotes;
	private String Base64;
	private String Link;

	public Theme(String parentForum, String title, String type, String author, String content, ArrayList<String> likes,
			ArrayList<String> disLikes, Date dateOfCreation, int positiveVotes, int negativeVotes, String base64,
			String link) {
		super();
		ParentForum = parentForum;
		Title = title;
		Type = type;
		Author = author;
		Content = content;
		Likes = likes;
		DisLikes = disLikes;
		DateOfCreation = dateOfCreation;
		PositiveVotes = positiveVotes;
		NegativeVotes = negativeVotes;
		Base64 = base64;
		Link = link;
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




	public ArrayList<String> getLikes() {
		return Likes;
	}


	public void setLikes(ArrayList<String> likes) {
		Likes = likes;
	}


	public ArrayList<String> getDisLikes() {
		return DisLikes;
	}


	public void setDisLikes(ArrayList<String> disLikes) {
		DisLikes = disLikes;
	}


	public Date getDateOfCreation() {
		return DateOfCreation;
	}
	
	public String getBase64() {
		return Base64;
	}


	public void setBase64(String base64) {
		Base64 = base64;
	}


	public String getLink() {
		return Link;
	}


	public void setLink(String link) {
		Link = link;
	}


	public Theme() {
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

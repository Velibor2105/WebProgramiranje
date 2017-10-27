package com.entities;

import java.util.ArrayList;

public class Forum implements java.io.Serializable{
   
	private String Name;
	private String Description;
	private String Moderator;
	private String Rules;
	private ArrayList<String> Moderators; 
	private String Icon;
	
	public Forum() {
		
	}
	
	
	public Forum(String name, String description,String rules, String moderator, ArrayList<String> moderators, String icon) {
		Name = name;
		Description = description;
		Moderator = moderator;
		Moderators = moderators;
		Rules = rules;
		Icon = icon;
	}


	
	public String getIcon() {
		return Icon;
	}


	public void setIcon(String icon) {
		Icon = icon;
	}
	
	public String getRoles() {
		return Rules;
	}


	public void setRoles(String rules) {
		Rules = rules;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getModerator() {
		return Moderator;
	}


	public void setModerator(String moderator) {
		Moderator = moderator;
	}


	public ArrayList<String> getModerators() {
		return Moderators;
	}


	public void setModerators(ArrayList<String> moderators) {
		Moderators = moderators;
	}
	
	
	
	
}

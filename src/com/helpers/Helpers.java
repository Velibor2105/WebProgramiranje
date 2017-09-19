package com.helpers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.entities.Comment;

public class Helpers {

	public static ArrayList<String> convertStringToArrayList(String array){
		
	    ArrayList<String> listdata = new ArrayList<String>();     
		
		try {
			JSONArray jArray = new JSONArray(array);
			if (jArray != null) { 
				   for (int i=0;i<jArray.length();i++){ 
				    listdata.add(jArray.getString(i));
				   } 
				} 
		} catch (JSONException e) {
			e.printStackTrace();
		}  
		
		return listdata;
	}
	
	public static Comment search(Comment comment, int id) {
		
	    if (comment.getCommentId() == id) 
	    	return comment;
	    
	    for (Comment c : comment.getContain()) {
	    	Comment found = search(c, id);
	          if (found != null) return found;
		}
	    return null;
	}
	
	public static ArrayList<Integer> GetMax(ArrayList<Comment> comments, ArrayList<Integer> listOfInteger) {
	    for (Comment c : comments) {
	    	listOfInteger.add(c.getCommentId());
	    	GetMax(c.getContain(),listOfInteger);
		}
		return listOfInteger;
	}
}

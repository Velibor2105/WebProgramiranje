package com.helpers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

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
}

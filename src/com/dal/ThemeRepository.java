package com.dal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.entities.Theme;

public class ThemeRepository {

	private String path = null;
	private ArrayList<Theme> themes = null;
	

	public ThemeRepository(String path) {
		this.path = path;
		this.themes = GetAllThemes();
	}


	@SuppressWarnings("unchecked")
	private ArrayList<Theme> GetAllThemes() {
		
        ArrayList<Theme> themesIn = new ArrayList<Theme>();
		
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			 fin = new FileInputStream(this.path + "\\data\\themes.txt");
			 ois = new ObjectInputStream(fin);
			 themesIn = (ArrayList<Theme>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
		    if(ois  != null){
		        try {
		        	ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
		return themesIn;
	}
	
	public boolean AddTheme(Theme theme) {
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		this.themes.add(theme);
		try 
		{
		    fout = new FileOutputStream(this.path + "\\data\\themes.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(this.themes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
		    if(oos  != null){
		        try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		    } 
		}
		return true;
	}
	
	
	public ArrayList<Theme> GetThemes(){
		return themes;
	}
}
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
		this.path = "C:";
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
	
	public boolean AddThemes(ArrayList<Theme> themes) {
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
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
	
	
	
	public  Theme GetThemeById(String id){
		
		 for (int i = 0; i < this.themes.size(); i++) 
			if (themes.get(i).getTitle().equals(id))
				return themes.get(i);
		 
       return null;
	}
	
	public  void UpdateTheme(Theme theme){
		
		DeleteThemeById(theme.getTitle());
		
		AddTheme(theme);
		
	}
	public void DeleteThemeById(String id){
		for (int i = 0; i < themes.size(); i++) {
			if(themes.get(i).getTitle().equals(id)){
			   themes.remove(i);
			}
		}
		
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
	
		try 
		{
		    fout = new FileOutputStream(this.path + "\\data\\themes.txt");
		    oos = new ObjectOutputStream(fout);
			oos.writeObject(themes);
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
		
	}
}

package com.business;

import java.util.ArrayList;

import com.dal.ThemeRepository;
import com.entities.Theme;

public class ThemeBL {

	private ArrayList<Theme> themes = null;
	private ThemeRepository tr = null;
	
	public ThemeBL(){
		
	}
	
	public ThemeBL(String path){
		tr = new ThemeRepository(path);
		themes = tr.GetThemes();
	}
	
	public boolean AddTheme(Theme theme) {
		
		if(!ThemeExistInForum(theme.getParentForum(),theme.getTitle()))
		   return tr.AddTheme(theme);
		
		return false;
	}
	
	public ArrayList<Theme> GetThemesForForumName(String name) {
		
		ArrayList<Theme> forumThemes = new ArrayList<Theme>();
		
		for (Theme theme : themes) {
			if(theme.getParentForum().equals(name)) 
				forumThemes.add(theme);
		}
		return forumThemes;
	}
	
	private boolean ThemeExistInForum(String name, String title) {

		for (Theme theme : GetThemesForForumName(name)) {
			if(theme.getTitle().equals(title))
				return true;
		}
		return false;
	}
	
}

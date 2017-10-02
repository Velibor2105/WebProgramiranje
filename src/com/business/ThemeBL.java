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
	
	
	public void AddRemoveLike(String userName, String themeTitle) {
		
		Theme theme = tr.GetThemeById(themeTitle);
		
		if(DisLikeExist(userName, theme))
			RemoveDisLike(theme.getDisLikes(),userName);
		
		if(!LikeExist(userName,theme))
			theme.getLikes().add(userName);
		else
		    theme.setLikes(RemoveLike(theme.getLikes(), userName));
		
		tr.UpdateTheme(theme);
	}
	
	public void AddRemoveDisLike(String userName, String themeTitle) {
		
		Theme theme = tr.GetThemeById(themeTitle);
		
		if(LikeExist(userName, theme))
			RemoveLike(theme.getLikes(),userName);
		
		if(!DisLikeExist(userName,theme))
			theme.getDisLikes().add(userName);
		else
		    theme.setDisLikes(RemoveDisLike(theme.getDisLikes(), userName));
		
		tr.UpdateTheme(theme);
	}
	
	public boolean LikeExist(String userName, Theme theme) {
		
		ArrayList<String> users = theme.getLikes();
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).equals(userName))
				return true;
		}
		return false;
	}
	
public boolean DisLikeExist(String userName, Theme theme) {
		
		ArrayList<String> users = theme.getDisLikes();
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).equals(userName))
				return true;
		}
		return false;
	}
	
	public ArrayList<String> RemoveLike(ArrayList<String> users, String userName){
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).equals(userName))
				users.remove(i);
		}
		return users;
	}
	
    public ArrayList<String> RemoveDisLike(ArrayList<String> users, String userName){
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).equals(userName))
				users.remove(i);
		}
		return users;
	}
}

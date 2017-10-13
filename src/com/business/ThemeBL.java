package com.business;

import java.util.ArrayList;

import com.dal.ThemeRepository;
import com.entities.Theme;

public class ThemeBL {

	private ArrayList<Theme> themes = null;
	private ThemeRepository tr = null;
	
	
	public ThemeBL(String path){
		tr = new ThemeRepository(path);
		themes = tr.GetThemes();
	}
	
	private boolean ThemeExistInForum(String name, String title) {

		for (Theme theme : GetThemesForForumName(name)) {
			if(theme.getTitle().equals(title))
				return true;
		}
		return false;
	}
	
	public boolean AddTheme(Theme theme) {
		
		if(!ThemeExistInForum(theme.getParentForum(),theme.getTitle()))
		   return tr.AddTheme(theme);
		
		return false;
	}
	
	public String GetAuthorForTheme(String theme) {
		
		for (Theme t : themes) 
			if (t.getTitle().equals(theme)) 
				return t.getAuthor();
			
		return null;
	}
	
	public ArrayList<Theme> DeleteTheme(String theme, String forum){
		tr.DeleteThemeById(theme);
		return GetThemesForForumName(forum);
	}
	
	public ArrayList<Theme> EditThemeText(String theme, String forum, String content) {
		
		for (Theme t : themes) {
			if(t.getTitle().equals(theme) && t.getParentForum().equals(forum)) 
				t.setContent(content);
		}
		tr.AddThemes(themes);
		return GetThemesForForumName(forum);
	}
	
	public ArrayList<Theme> EditThemeLink(String theme, String forum, String link) {
		
		for (Theme t : themes) {
			if(t.getTitle().equals(theme) && t.getParentForum().equals(forum)) 
				t.setLink(link);
		}
		tr.AddThemes(themes);
		return GetThemesForForumName(forum);
	}
	
	public ArrayList<Theme> EditThemeImage(String theme, String forum, String base64) {
		
		for (Theme t : themes) {
			if(t.getTitle().equals(theme) && t.getParentForum().equals(forum)) 
				t.setBase64(base64);
		}
		tr.AddThemes(themes);
		return GetThemesForForumName(forum);
	}
	
	public ArrayList<Theme> GetThemesForForumName(String name) {
		
		ArrayList<Theme> forumThemes = new ArrayList<Theme>();
		
		for (Theme theme : themes) {
			if(theme.getParentForum().equals(name)) 
				forumThemes.add(theme);
		}
		return forumThemes;
	}

	
	public int AddRemoveLike(String userName, String themeTitle) {
		
		Theme theme = tr.GetThemeById(themeTitle);
		
		if(DisLikeExist(userName, theme))
			RemoveDisLike(theme.getDisLikes(),userName);
		
		if(!LikeExist(userName,theme))
			theme.getLikes().add(userName);
		else
		    theme.setLikes(RemoveLike(theme.getLikes(), userName));
		
		theme.setNegativeVotes(theme.getDisLikes().size());
		theme.setPositiveVotes(theme.getLikes().size());
		
		tr.UpdateTheme(theme);
		
		return theme.getPositiveVotes();
	}
	
	public int AddRemoveDisLike(String userName, String themeTitle) {
		
		Theme theme = tr.GetThemeById(themeTitle);
		
		if(LikeExist(userName, theme))
			RemoveLike(theme.getLikes(),userName);
		
		if(!DisLikeExist(userName,theme))
			theme.getDisLikes().add(userName);
		else
		    theme.setDisLikes(RemoveDisLike(theme.getDisLikes(), userName));
		
		theme.setNegativeVotes(theme.getDisLikes().size());
		theme.setPositiveVotes(theme.getLikes().size());
		
		tr.UpdateTheme(theme);
		
		return theme.getNegativeVotes();
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
    
    public int GetLikes(String theme) {
      return tr.GetThemeById(theme).getPositiveVotes();
    }
    
    public int GetDisLikes(String theme) {
        return tr.GetThemeById(theme).getNegativeVotes();
      }
}

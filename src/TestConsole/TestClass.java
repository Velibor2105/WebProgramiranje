package TestConsole;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.business.CommentBL;
import com.business.ThemeBL;
import com.dal.CommentRepositiry;
import com.dal.ForumRepository;
import com.dal.ThemeRepository;
import com.dal.UserRepository;
import com.entities.Comment;
import com.entities.Forum;
import com.entities.User;
import com.google.gson.Gson;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		CommentRepositiry cr = new CommentRepositiry("C:\\Users\\v.stancic\\Desktop\\faks\\web programiranje\\Forum\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Forum");
		
		CommentBL commentBl = new CommentBL("C:\\Users\\v.stancic\\Desktop\\faks\\web programiranje\\Forum\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Forum");
		
		ArrayList<Comment> comments = commentBl.AddCommentLike("admin", "Aelyria", "2");
		
		
		ArrayList<String> test = new ArrayList<String>();
		
		test.add("test");
		
		if(test.contains("test"))
			System.out.println("jest");
		
		
		test.remove("test");
		
		System.out.println("jest");
		
		
		
		ThemeRepository tr = new ThemeRepository("C:\\Users\\v.stancic\\Desktop\\faks\\web programiranje\\Forum\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Forum");
		
		
		
		ThemeBL themeBl = new ThemeBL("C:\\Users\\v.stancic\\Desktop\\faks\\web programiranje\\Forum\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Forum");
		
		
		//int t =	themeBl.AddRemoveLike("admin", "3");
		
     	int t =	themeBl.AddRemoveDisLike("admin", "3");
		
		
		
		System.out.println(t);
		
		
		
		
		

		
		
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
	
	

}

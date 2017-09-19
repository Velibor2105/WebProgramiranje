package TestConsole;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.business.CommentBL;
import com.dal.CommentRepositiry;
import com.dal.ForumRepository;
import com.dal.UserRepository;
import com.entities.Comment;
import com.entities.Forum;
import com.entities.User;
import com.google.gson.Gson;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CommentRepositiry cr = new CommentRepositiry("C:\\Users\\v.stancic\\Desktop\\faks\\web programiranje\\Forum\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Forum");
		
            
		/*	Comment c1 = new Comment("Aelyria","fgdsg","ja",1,new Date(),"test content",0,0,false, new ArrayList<Comment>());
			cr.AddComment(c1);
			String json = new Gson().toJson(cr.GetComments());
		    System.out.println("asd");*/
		    
		
     		CommentBL commentBl = new CommentBL("C:\\Users\\v.stancic\\Desktop\\faks\\web programiranje\\Forum\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Forum");
     		
     		Comment c7 = new Comment("Aelyria","fgdsg","ja",7,new Date(),"test content",0,0,false, new ArrayList<Comment>());
     		commentBl.AddComment(6, c7);

     		String json1 = new Gson().toJson(commentBl.GetComments());
     		
     		System.out.println("sdf");
		
		
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

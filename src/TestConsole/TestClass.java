package TestConsole;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
		
		
		   // Comment c1 = new Comment("f1","t1",1,new Date(),0,"test content",0,0,false, new ArrayList<Comment>());
		    
		    
			Comment c2 = new Comment("f1","t1","ja",2,new Date(),"test content",0,0,false, new ArrayList<Comment>());
			Comment c3 = new Comment("f1","t1","ja",3,new Date(),"test content",0,0,false, new ArrayList<Comment>());
			Comment c4 = new Comment("f1","t1","ja",4,new Date(),"test content",0,0,false, new ArrayList<Comment>());
			
			ArrayList<Comment> contain = new ArrayList<Comment>();

			contain.add(c2);
			contain.add(c3);
			contain.add(c4);

			Comment c1 = new Comment("f1","t1","ja",1,new Date(),"test content",0,0,false, contain);
			
			
			 Comment com = search(c1,4);
			 
			 com.getContain().add(new Comment("f1","t1","ja",5,new Date(),"test content",0,0,false, new ArrayList<Comment>()));
			 
             Comment com1 = search(c1,5);
			 
			 com1.getContain().add(new Comment("f1","t1","ja",6,new Date(),"test content",0,0,false, new ArrayList<Comment>()));
			 
			 
			 cr.AddComment(c1);
			
			String json = new Gson().toJson(c1);
			
		
		System.out.println("asd");
		
		
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

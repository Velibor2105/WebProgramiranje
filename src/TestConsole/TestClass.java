package TestConsole;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import com.dal.ForumRepository;
import com.dal.UserRepository;
import com.entities.Forum;
import com.entities.User;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File directory = new File("./");
		   System.out.println(directory.getAbsolutePath());
		
		UserRepository ur = new UserRepository("");
		
		ur.AddUser(new User("admin", "admin", "admin", "admin", "admin", "admin", "admin", new Date ()));
		
		
		
		ArrayList<String> moderators =  new ArrayList<String>();
		
		moderators.add("Petra");
		moderators.add("Ana");
		
		 ArrayList<Forum> forums =  new ArrayList<Forum>();
	
		
       ForumRepository fr = new ForumRepository("C://Users//Velior//Desktop//Testing//WebContent//data//users.txt");
       
       
       Forum forum = new Forum("FirstForum1","Description for fourm","Velibor Stancic",moderators);
       Forum forum1 = new Forum("FirstForum2","Description for fourm","Velibor Stancic",moderators);
       Forum forum2 = new Forum("FirstForum3","Description for fourm","Velibor Stancic",moderators);
       Forum forum3 = new Forum("FirstForum4","Description for fourm","Velibor Stancic",moderators);
       Forum forum4 = new Forum("FirstForum5","Description for fourm","Velibor Stancic",moderators);
       Forum forum5 = new Forum("FirstForum6","Description for fourm","Velibor Stancic",moderators);
       
       fr.AddForum(forum);
       fr.AddForum(forum1);
       fr.AddForum(forum2);
       fr.AddForum(forum3);
       fr.AddForum(forum4);
       fr.AddForum(forum5);
       
       
       
     
       forums = fr.GetForums();
       
  
   
	
		
		
	
		
		
	}

}

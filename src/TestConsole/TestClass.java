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
       
       
       
       
     
       forums = fr.GetForums();
       
  
   
	
		
		
	
		
		
	}

}

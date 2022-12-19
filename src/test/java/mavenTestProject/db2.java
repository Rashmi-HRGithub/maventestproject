package mavenTestProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class db2 {

 Connection con=null;	
@Test	
public void db2() throws SQLException {
	
	 
	 Scanner S = new Scanner(System.in);
	 System.out.println("enter the name");
	 
         Driver driver = new Driver();
	    DriverManager.registerDriver(driver);
         con = DriverManager.getConnection("\"jdbc:mysql://localhost:3306/student\",\"root\",\"root\"");
	   System.out.println("connection is done");
	   
	  Statement state = con.createStatement();
      String query = "select * from employee";
      ResultSet resultset = state.executeQuery(query);
      
      while(resultset.next())
    	  
      {
         String empname = resultset.getString(1);
         if(empname.equals(state))
         {
        	 System.out.println("employee name already exists");
        	 v=true;
        	 break;
         }	 
         }
         
        if(v==false)
        {	
         
        	 
    	  
      }
      
         
}
	
	
	

}

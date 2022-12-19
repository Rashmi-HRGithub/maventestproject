package mavenTestProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

  
public class readFromDatabaseTest1 

{
	Connection conn=null;
	boolean v;
	@Test
	   public void  readFromDatabaseTest1() throws SQLException {
	 
		    Scanner S= new Scanner(System.in);
		   System.out.println("enter the name");
		
		    String st=S.nextLine();

			Driver driverref=new Driver();
			// load/register mysql the database
			DriverManager.registerDriver(driverref);
			
			//connect to db
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
			System.out.println("connection is done");
		Statement state = conn.createStatement();
		String query="select * from employee";
		 //execute the query
		  
		ResultSet resultset = state.executeQuery(query);
		while(resultset.next())
		{
			
		String empname=resultset.getString(1);
		if(empname.equals(st))
		{
			
			System.out.println("employee alredy exists");
			v=true;
			break;
		}
		
		}
		if(v==false)
		{   System.out.println("employee name inserted successfully"+ "");
				
			conn.createStatement().executeUpdate("insert into employee values ('"+st+"');");
		}
			
		
		
	}

	     
	      
	     
			
			
	}
	


	


	
	
	
	
	
	



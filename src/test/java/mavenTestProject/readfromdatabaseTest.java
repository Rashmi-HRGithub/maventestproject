package mavenTestProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class readfromdatabaseTest {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
	try {
			Driver driverref=new Driver();
			// load/register mysql the database
			DriverManager.registerDriver(driverref);
			
			//connect to db
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root" );
			System.out.println("connection is done");
		Statement stat = conn.createStatement();
		String query="select * from student";
		 //execute the query
		  System.out.println(query);
		ResultSet resultset = stat.executeQuery(query);
		while(resultset.next())
		{
			
		//System.out.println(resultset.getString(1)+"\t"+resultset.getString(2)+"\t"+resultset.getShort(3)+"\t"+resultset.getShort(4));
		String empname=resultset.getString(1);
		if(empname.equals("Rashmi"))
		{
			
			boolean flag = true;
		}
		else if(!(empname.equals("Rashmi")));
		{
			
			String query1="insert into employee values(Raj)";
			ResultSet resultset1 = stat.executeQuery(query1);
		}
		}	
			
		
		
	}

	      catch (Exception e)	{
	    	  
	    
	      }
	      
	      finally {
	    	  
	    	  // close the connection
	    	  conn.close();
	    	  System.out.println("-----close db connection-----");
	    	  
	      }
			
			
	}
	


	}


	
	
		
		
	

	



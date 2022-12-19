package mavenTestProject;

import java.util.HashSet;

import org.testng.annotations.Test;

import com.graphbuilder.struc.LinkedList;

public class eachWordOccurance {
	@Test
	public void eachWordOccurance() 
	{
		
	
	String s="welcome to India welcome to Mysore";
	String []str=s.split(" ");
	HashSet<String> set =new HashSet<String>();
	for(int i=0;i<str.length;i++)
	{
		set.add(str[i]);
	}
	              
	for(String word:set)
	{
		int count=0;
		for(int i=0;i<str.length;i++)
		{
			if(word.equals(str[i]))
			{
				count++;
			}
			
		}
		System.out.println(word + " " + count);
	}
			
		}
	
	
	
	}





String s="welcome to India welcome to mysore";
String []str=s.split(" ");
HashSet<String> set=new HashSet<String>();

for(i=0;i<str.length;i++)
{
	set.add(str[i]);
}

 for(String word:set)
 {
	 int count=0;
	 for(int i=0;i<str.length;i++)
	 {		 
	 if(word.equals(str[i]))
	 {
		 count++;
	 }
	 
 }
System.out.println(word +" "+count);
 }
 }
 }




















package mavenTestProject;

import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class printnoOfoccurrence {
	
	@Test
	public void printnoOfoccurrence() 
	{
		String s= "Pradeep";
		//LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		for(int i=0;i<s.length();i++)
		{
			set.add(s.charAt(i));
		}
		for(Character ch:set)
		{
			int count=0;
			for (int i=0;i<s.length();i++)
			{
				if(ch==s.charAt(i))
				{
					count++;
				}
				
			}
			//if(count==1)
			//if(count==2)
			System.out.println(unique charactersre ch + " "+ count);
			System.out.println(duplicate character ch + " " + count); 
			
			System.out.println(ch+" "+count);
		}
		
		
		
		
		public void noOfoccourence1() {
			
			String name="hello";
		 LinkedHashList Set =new LinkedHashList<Character>();
		  for(int i=0;i<name.length();i++)
		  {
			  Set.add(name.charAt(i));
		  }
		   
			for(character ch:Set)
			{   int count=0;
			 for(int i=0;i<name.length();i++)
			 {	 
				if(ch==charAt(i))
				{
					count++;
				}
			
			}
		  
			 System.out.println(ch +" " +count);
			  
		  }
		  
		  
		  
		  
		  
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

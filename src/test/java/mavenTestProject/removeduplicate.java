package mavenTestProject;

import java.util.LinkedHashSet;

import org.testng.annotations.Test;

public class removeduplicate {
	@Test
	public void removeduplicate()
	
	{
		String S="hello";
        LinkedHashSet<Character> set=new LinkedHashSet<Character>();
        for(int i=0;i<S.length();i++)
        {
        	set.add(S.charAt(i));
        }
        
        for(Character ch : set)
        {
        	System.out.println(ch + " ");
        	
        }
		
	}

}

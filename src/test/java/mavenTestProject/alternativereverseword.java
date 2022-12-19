package mavenTestProject;

public class alternativereverseword {

	public static void main(String[] args) {
		String s="This is java programing questions";
		String []str=s.split(" ");
	       for(int i=0; i<str.length;i++)
		{
		    if(i%2==0)
		    {
		        for(int j=str[i].length()-1;j>=0;j--)
		        
		        {
		            System.out.print(str[i].charAt(j));
		            
		        }
		        System.out.print(" ");
		        
		    }
		    else
			System.out.println(str[i] + " ");
			
		}
		
	
		  
		
		
	}
}


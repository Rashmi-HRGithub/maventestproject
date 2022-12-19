package mavenTestProject;

public class missingevennos {

	
	
		public static void main (String[] args) throws java.lang.Exception
		{
			int []arr={2,4,8,12,16,20};

			for(int i=0; i<arr.length-1;i++)
			{
			    int n=arr[i+1]-arr[i];
			    int count=1;
			    while(n>1)
			    
			    {
			        int value=arr[i]+count;
			        if(value%2==0)
			        {
			            
			            System.out.println(value);
			        }
			            n--;
			            count++;
			    }
			}
			  
			
			
		}
	}

	
	
	
	


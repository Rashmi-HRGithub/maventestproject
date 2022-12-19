package mavenTestProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ageWebtable {

	public static void main(String[] args)
	
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		List<WebElement> age = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		int count=age.size();
		for(int i=0;i<count;i++)
		{
			if(!(age.equals(66)))
			{	
			System.out.println(age.get(i).getText());
			}
			 
		}		   				
			}
		}
	



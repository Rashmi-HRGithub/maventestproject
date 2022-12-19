package mavenTestProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class excel1 {

	@Test
	public void excel1() throws EncryptedDocumentException, IOException
	
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/table-sort-search-demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		List<WebElement> col1 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[1]"));
		List<WebElement> col2 = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		List<WebElement> age = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[4]"));
		 int c1 = col1.size();
	     int c2 = col2.size();
	     
	     for(int i=0;i<c1;i++)
	     {
	    	 //int value=Integer.parseInt(age.get(i).getText());
	    	 //if(value<=40)
	    	System.out.println(col1.get(i).getText() +"        " + col2.get(i).getText());
	    	
	     }
	     
	     
	     FileInputStream fis = new FileInputStream("./src/test/resources/excel1.xlsx");

	     Workbook wb = WorkbookFactory.create(fis);
	     
	     for(int i=0;i<c1;i++)
	     {
	    	 
	    	 wb.getSheet("sheet1").getRow(i).getCell(0).setCellValue(col1.get(i).getText());
	    	 wb.getSheet("sheet1").getRow(i).getCell(1).setCellValue(col2.get(i).getText());
	     }
	      
	     FileOutputStream fos=new FileOutputStream("./src/test/resources/excel1.xlsx");
	     wb.write(fos);
	     driver.close();
	      
	    
	    
	     
	     
		
	}
	
	

}

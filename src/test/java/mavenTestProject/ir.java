package mavenTestProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ir {
	@Test

	public void ir()
	{
  
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		
		List<WebElement> colunm = driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[2]"));
		  int count = colunm.size();
		
		  for(int i=0;i<count;i++)
		  {
			  System.out.println(colunm.get(i).getText());  
		  }
		  
		  FileInputStream fis=new FileInputStream("./src/test/resources/writeexcel.xlsx");
		  Workbook wb = WorkbookFactory.create(fis);
		  
		  for(int i=0;i<count;i++)
		  {
			  wb.getSheet("sheet1").getRow(i).getCell(0).setCellValue(colunm.get(i).getText());
			  
		  }
		  
		  FileOutputStream fos=new FileOutputStream("./src/test/resources/writeexcel.xlsx");                                
		  wb.write(fos);
		  driver.close();
		  
		
		
		
		
		
}

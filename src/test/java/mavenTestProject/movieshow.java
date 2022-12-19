package mavenTestProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mysql.cj.result.Row;

public class movieshow {

	@Test
	public void movieshow() throws EncryptedDocumentException, IOException {
	
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://www.bookmyshow.com/");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 //driver.findElement(By.xpath("//span[text()='Bengaluru']"));
	 driver.findElement(By.xpath("//input[@placeholder='Search for your city']")).sendKeys("bengaluru");
	 driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
	 driver.findElement(By.id("4")).click();
	 driver.findElement(By.xpath("//a[text()='Kantara (Kannada) (UA)']")).click();
	 driver.findElement(By.xpath("//div[contains(text(),'Mon')]")).click();
	 driver.findElement(By.id("wzrk-cancel")).click();
     List<WebElement> tname = driver.findElements(By.xpath("//a[@class='__venue-name']"));
     int count = tname.size();
     System.out.println(count);
     for(WebElement v:tname)
     {
    	 System.out.println(v.getText());
     }
    	 
//    List<WebElement> movietime = driver.findElements((By.xpath("//div[@class='__text']")));  
//    int time = movietime.size();
//    System.out.println(time);
//    for(WebElement t:movietime)
//    {
//    	System.out.println(t);
//    }

    FileInputStream fis = new FileInputStream("mavenTestProject\\src\\test\\resources\\bookmyshow.xlsx");
     Workbook wb = WorkbookFactory.create(fis);
         
		String sheet;
		Sheet sh = wb.getSheet(sheet);
      for(int i=1;i<tname.size();i++)
	
      {
	   Row r=sh.createRow(i);
	   r.createCell(1).setCellValue(tname.get(i-1).getText());
       r.createCell(2).setCellValue(tname.get(i-1).getText());
      }
FileOutputStream fos=new FileOutputStream("mavenTestProject\\src\test\resources\bookmyshow.xlsx");
wb.write(fos);
wb.close();

	
		
		
		
	}
}

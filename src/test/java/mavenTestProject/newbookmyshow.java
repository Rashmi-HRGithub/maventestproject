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
import org.bouncycastle.asn1.x509.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.result.Row;

public class newbookmyshow {

	
	public void newbookmyshow() throws EncryptedDocumentException, IOException 
	
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.bookmyshow.com/");
		driver.manage().window().maximize();
        driver.findElement(By.xpath("//span[text()='Search for Movies, Events, Plays, Sports and Activities']")).click();
        //driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        Thread.sleep(30);
        driver.findElement(By.xpath("//input[@placeholder=\"Search for your city\"]")).sendKeys("bangalore");
       // driver.findElement(By.xpath("//span[text()='Bengaluru']")).click();
		driver.findElement(By.xpath("//a[text()='GG - Gandhada Gudi (U)']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Fri')]")).click();
		List<WebElement> venue= driver.findElements(By.xpath("//a[@class='__venue-name']"));
		int count=venue.size();
		System.out.println(count);
		
		
		
		
		FileInputStream fis=new FileInputStream("./src/test/resources/bookmyshow.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	     Sheet sh = wb.getSheet(sheet);
	     for(int i=1;i<Tnames.size();i++)
	     {
	    	 
	    	 Row r=sh.createRow(i);
	    	 r.createCell(1).setCellValue(Tnames.get(i-1).getText());
	    	 r.createCell(2).setCellValue(Time.get(i-1).getText()); 
	     }
		FileOutputStream fos=new FileOutputStream("./src/test/resources/bookmyshow.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}
	
	
	
	
	
}

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

public class bookmyshow {
	

        @Test
	    public void bookmyshow() throws InterruptedException, EncryptedDocumentException, IOException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
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
		for(WebElement v:venue)
		{
			System.out.println(v.getText());
		}
		    FileInputStream fis = new FileInputStream("mavenTestProject\\src\\test\\resources\\bookmyshow.xlsx");
             Workbook wb = WorkbookFactory.create(fis);
		
		for(int i=0;i<count;i++)
			
		{
			wb.getSheet("Sheet1").getRow(i).getCell(2).setCellValue(venue.get(i).getText());
			
		}
		FileOutputStream fos=new FileOutputStream("mavenTestProject\\src\test\resources\bookmyshow.xlsx");
		wb.write(fos);
		wb.close();
		
        }		
		
		//List<WebElement> movietime = driver.findElements(By.xpath("class=\"__text\")"));
		
		
		
		
		

	
	
        }   
	
	









//public String writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo,String Date)  throws Throwable
//{
//FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
//Workbook wb = WorkbookFactory.create(fi);
//Sheet sh = wb.getSheet(SheetName);
//Row ro=sh.getRow(RowNo);
//Cell cell = ro.createCell(ColumnNo);
//cell.setCellValue(Date);
//FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
// wb.write(fos);	
// return Date;
//}
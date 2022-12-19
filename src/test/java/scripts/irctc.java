package scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class irctc {
	@Test
public void irctc() throws InterruptedException, AWTException

{   ChromeOptions c=new ChromeOptions(); 
     c.addArguments("--disable-notifications");
     Thread.sleep(3000);
   	WebDriver driver=new ChromeDriver();
	driver.get("https://www.irctc.co.in/nget/train-search");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);	
	driver.manage().window().maximize();
	driver.findElement(By.id("disha-banner-close")).click();
	driver.findElement(By.xpath("//img[@style=\"padding-top:-30px;cursor: grab;\"]")).click();
	driver.findElement(By.xpath("//a[text()=\" FLIGHTS \"]")).click();
	
	Set<String> parent = driver.getWindowHandles();
	System.out.println(parent.size());
	for(String s:parent)
	{
		driver.switchTo().window(s);
		System.out.println(driver.getTitle());
	}
	
	Thread.sleep(30);
	//driver.findElement(By.xpath("//button[text()='Later']")).click();
	//driver.findElement(By.xpath("//div[@class=\"FullSrchBox\"]//input[@id='stationFrom']")).click();
	driver.findElement(By.id("stationFrom")).click();
	
	
	Actions a = new Actions(driver);
	WebElement ele = driver.findElement(By.xpath("//div[text()='Bengaluru (BLR)'])"));
	a.moveToElement(ele).click().perform();
	
	driver.findElement(By.xpath("//input[@id='stationTo']")).click();
	 WebElement ele1 = driver.findElement(By.xpath("//div[text()='Mumbai (BOM)']"));
	 a.moveToElement(ele1).click().perform();
	 
	 Thread.sleep(1000);
	Robot r = new Robot();
	driver.findElement(By.xpath("//input[@placeholder='Origin']")).sendKeys("bengaluru");
	Thread.sleep(2000);
	r.keyPress(KeyEvent.VK_PAGE_DOWN);
	r.keyRelease(KeyEvent.VK_PAGE_DOWN);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	r.keyPress(KeyEvent.VK_PAGE_UP);
	r.keyPress(KeyEvent.VK_PAGE_UP);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@placeholder=\"Destination\"]")).sendKeys("Chennai");
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_PAGE_DOWN);
			r.keyRelease(KeyEvent.VK_PAGE_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.keyPress(KeyEvent.VK_PAGE_UP);
			r.keyPress(KeyEvent.VK_PAGE_UP);
     JavascriptExecutor js=(JavascriptExecutor)driver;		
           WebElement ele1=driver.findElement(By.xpath(""));
		 js.executeScript("arguments[0].click();",ele1);
		 
		 WebElement ele2 = driver.findElement(By.xpath("//button[text()='Search ']"));
		 js.executeScript("arguments[0].click();,ele2");
		 
		 
	List<WebElement> flightname = driver.findElement(By.xpath(""));
	List<WebElement> flighttime = driver.findElement(By.xpath(""));
		 WebElement ticketPrice = driver.findElement(By.xpath(""));
		 
		FileInputStream fis=new FileInputStream("./src/test/resources/IRCTC.xlsx"); 
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sh = wb.getSheet("Sheet1");
        for(int i=0;i<flightname.size();i++)
        {
        	 Row r=sh.createRow(i);
        	 r.createCell(0).setCellValue(flightname.get(i).getText());
        	 r.createCell(0).setCellValue(flighttime.get(i).getText());
        	 r.createCell(0).setCellValue(ticketPrice.get(i).getText());
        	      
        }
        
        FileOutputStream fos=new FileOutputStream("./src/test/resources/IRCTC.xlsx");
        wb.write(fos);
        driver.close();
}
}



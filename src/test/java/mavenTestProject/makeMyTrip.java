package mavenTestProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.TestyantraJavaGenericUtilities.IPathConstants;

public class makeMyTrip {

	//@Test	
	public void makeMytrip() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Search']")).click();

		// driver.findElement(By.xpath("//span[@class=\"bgProperties icon20 overlayCrossIcon\"]")).click();
		
	// driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
		driver.findElement(By.xpath("//div[@class='commonOverlay ']/span")).click();
		driver.findElement(By.id("fromCity")).click();
		Thread.sleep(30);
		
		driver.findElement(By.xpath("//input[@placeholder=\"Enter City\"]")).sendKeys("bangalore");
		driver.findElement(By.xpath("//div[@class='commonOverlay ']/span")).click();
		
		driver.findElement(By.xpath("//body[@style=\"overflow: visible;\"]")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Enter City\"]")).sendKeys("mumbai");
		driver.findElement(By.id("return")).click();
	
		driver.findElement(By.xpath("tabindex=\"-1\")")).click();
		driver.findElement(By.id("departure")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter City\"]")).click();
		driver.findElement(By.xpath("//input[@autocomplete=\"none\"]")).sendKeys("mumbai");
		driver.findElement(By.xpath("//div[@class=\"DayPicker-Months\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"DayPicker-Months\"]")).click();
		driver.findElement(By.xpath("//div[@aria-label=\"Friday, 2 December 2022\"]")).click();
		driver.findElement(By.id("search-button")).click();
		//driver.findElement(By.xpath("//div[@class=\"rangeslider__handle\"])).

		public String writeDataIntoExcel(String SheetName, int RowNo, int ColumnNo,String Date)  throws Throwable
		{
		FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		Row ro=sh.getRow(RowNo);
		
	    Cell cell = ro.createCell(ColumnNo);
	    cell.setCellValue(Date);
	    FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
	     wb.write(fos);	
	     return Date;
	}

	}	

}

package mavenTestProject;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class BaseClass {
	
	public DatabaseUtility dLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	
	
	@BeforeSuite(groups= {"smoke","regression"})
	public void connectToDB() throws SQLException
	{
		dLib.connectToDB();
		System.out.println("-----connect to database------");
		
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void launchBrowser() throws InterruptedException
	{
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
	
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
	    driver=new FirefoxDriver();	
	}
	else
	{
		System.out.println("invalid browser");
	}
	wLib.waitForPageLoad(driver);
	wLib.wait();
	String URL = fLib.readDataFromPropertyFile("url");
	driver.get(URL);
	}

	
	
	
   


   
   
   
   
   @AfterClass(groups= {"smoke","regression"})
   public void closeBrowser()
   {
	   driver.quit();
	   System.out.println("----close browser");
   
   }
   
   
   @AfterSuite(groups= {"smoke","regression"})
   public void closeDB()
   {
	   dLib.closeDB();
	   System.out.println("disconnect to database");	
   }
   }
   
	
	
	
	
	
	
	
	
	



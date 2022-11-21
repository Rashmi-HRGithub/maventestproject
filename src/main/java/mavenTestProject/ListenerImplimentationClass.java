package mavenTestProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ListenerImplimentationClass implements ITestListener {
	ExtentReports report;
    ExtentTest test; 
    
    
    
	public void onTestStart(ITestResult result) {
	    String MethodName = result.getMethod().getMethodName();
	    test = report.createTest(MethodName);
	    Reporter.log(MethodName+"------------Testscript execution started");
	    

	}

	public void onTestSuccess(ITestResult result) {
		 String MethodName = result.getMethod().getMethodName();
		 test.log(Status.PASS, MethodName+"------->Passed");
		Reporter.log(MethodName+"------->script executed sucessfully");
		
	}

	public void onTestFailure(ITestResult result) {
		String Failedscript=result.getMethod().getMethodName();
		String FScript = Failedscript+new JavaUtility().getSystemDateAndTimeInFormat();
       EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
       File src=edriver.getScreenshotAs(OutputType.FILE);
       File dst=new File(".\\screenshot\\"+FScript+".png");
       
		try {
			FileUtils.copyFile(src,dst);
		}
		catch(IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
		 String MethodName = result.getMethod().getMethodName();
		 test.log(Status.SKIP, MethodName+"--->skipped");
		 test.log(Status.SKIP, result.getThrowable());
		 Reporter.log(MethodName+"--Script Skipped");
		
	}	

	public void onStart(ITestContext context)
	{
		//execution starts here
		//configure the report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report.html");
	
		htmlreport.config().setDocumentTitle("SDET-42 execution report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTiger Execution Report");
		ExtentReports report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base_Browser", "Chorme");
		report.setSystemInfo("Base_url","jdbc:mysql://localhost:3306/Testyantra");
		report.setSystemInfo("ReporterName", "Rashmi");
		
		
		
	}

	public void onFinish(ITestContext context) 
	
	{
	   //consolidate all the parameters and generate the report
		report.flush();
		
		
	}
	
	
	
	
	
	

}

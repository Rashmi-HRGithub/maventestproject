package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(name = "user_name") 
	private WebElement usernametextfield;
	
	@FindBy(name = "user_password") 
	private WebElement passwordtextfield;
	
	@FindBy(id = "submitButton") 
	private WebElement loginbutton;
	 
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}	
	//utilization
	public WebElement get
		
		
		
		
	}
	
	
	
	

}

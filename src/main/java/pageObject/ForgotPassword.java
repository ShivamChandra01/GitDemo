package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;
	
	
	private By Email =By.id("user_email");
	private By sendmeinstruction= By.cssSelector("input[type='submit']");
	
	public ForgotPassword(WebDriver driver) {

		this.driver=driver;
		
		
	}

	public WebElement getEmail()
	{
		
		return driver.findElement(Email);
		
	}
	
	public WebElement sendmeinstruction()
	{
		
		return driver.findElement(sendmeinstruction);
		
	}
	

		
	}
	
	


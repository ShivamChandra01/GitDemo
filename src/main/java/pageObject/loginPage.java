package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver;
	
	
	private By Email =By.id("user_email");
	private By Password = By.id("user_password");
	private By login = By.xpath("//input[@data-disable-with='Log In']");
	private By forgotpassword= By.linkText("Forgot Password?");
	
	public loginPage(WebDriver driver) {

		this.driver=driver;
		
		
	}

	public WebElement getEmail()
	{
		
		return driver.findElement(Email);
		
	}
	
	public WebElement getpassword()
	{
		
		return driver.findElement(Password);
		
	}
	
	
	public WebElement getLogin()
	{
		
		return driver.findElement(login);
		
	}
	
	
	public ForgotPassword forgotpassword()
	{
		
		 driver.findElement(forgotpassword).click();
		 ForgotPassword fp=new ForgotPassword(driver);
		 return fp;
		 
		
	}
	
	
	
	
}

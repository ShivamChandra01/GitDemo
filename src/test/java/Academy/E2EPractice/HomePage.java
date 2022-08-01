package Academy.E2EPractice;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.loginPage;
import resource.Base;

public class HomePage extends Base {

	public static Logger log =LogManager.getLogger(Base.class.getName()); 
	public WebDriver driver;
	@BeforeTest

	public void Preconditions() throws IOException {
		driver = initializeDriver();
		

	}

	@Test(dataProvider = "getData")
	public void validateHomepage(String Username, String Password, String text)
			throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();

		LandingPage lp = new LandingPage(driver);
		loginPage login =lp.getLogin();
		
		login.getEmail().sendKeys(Username);
		login.getpassword().sendKeys(Password);
		log.info(text);
		login.getLogin().click();
		
ForgotPassword fp=login.forgotpassword();
		fp.getEmail().sendKeys("xxx@abc.com");
		fp.sendmeinstruction().click();
		
		

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		// data1:
		data[0][0] = "notrestricteduser@gmail.com";
		data[0][1] = "Abc@123";
		data[0][2] = "Not restricted user";
		


		// data2:
		data[1][0] = "restricteduser@df.com";
		data[1][1] = "ef@123";
		data[1][2] = "Restricted user";
		


		return data;

	}

	@AfterTest

	public void teardown() {

		driver.quit();
	}

}

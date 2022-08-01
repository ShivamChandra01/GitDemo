package Academy.E2EPractice;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resource.Base;

public class validateNavigationBar extends Base {
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest

	public void Preconditions() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();

	}

	@Test
	public void validateNavigationTest() throws IOException, InterruptedException {

		LandingPage lp = new LandingPage(driver);

		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is present");

	}

	@AfterTest

	public void teardown() {

		driver.close();
	}

}

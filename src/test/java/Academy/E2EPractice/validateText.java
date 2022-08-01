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

public class validateText extends Base {

	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	
	@BeforeTest

	public void Preconditions() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		
		driver.get(prop.getProperty("url"));
		log.info("URL is Open");
		
		
		driver.manage().window().maximize();

	}

	@Test
	public void validateTextTest() throws IOException {

		 lp = new LandingPage(driver);
		lp.getTitle().getText();

		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Featured couses text is verified");
		log.error("Text is not verified");

	}
	
	@Test
	public void validateHeader() throws IOException {

		 lp = new LandingPage(driver);
		lp.getTitle().getText();

		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Featured couses text is verified");
		log.error("Text is not verified");

	}
	

	@AfterTest

	public void teardown() {

		driver.close();
	}

}

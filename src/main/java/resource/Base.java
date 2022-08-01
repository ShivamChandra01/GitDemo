package resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	
	public WebDriver driver;
	public Properties prop;
	
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException
	{
		
		prop = new Properties();

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\data.properties");
		
		prop.load(fis);
		
//		String browserName = System.getProperty("browser");
		
	String browserName= prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))
		{
			//execute in chrome
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");
			}
			
			 driver = new ChromeDriver(options);
		}
		
		else if(browserName.equals("firefox"))
		{
			// execute in firefox
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\geckodriver.exe");
			
			
			 driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equals("IE"))
		{
			// execute in Internet Explorer
			
			System.setProperty("webdriver.IE.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resource\\IEDriver.exe");
			 driver=new InternetExplorerDriver();
			 
					
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public String getScreenshots(String testCaseName,WebDriver driver) throws IOException
	{
		
		TakesScreenshot ts =((TakesScreenshot) driver);
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinatonFile= System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinatonFile));
		return destinatonFile;
		
	}
	
	
	
	
}

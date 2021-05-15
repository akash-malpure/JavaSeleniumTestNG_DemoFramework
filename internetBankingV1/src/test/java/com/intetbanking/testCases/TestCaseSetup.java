package com.intetbanking.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.intetbanking.utils.ReadConfig;


public class TestCaseSetup{

	ReadConfig readconfig = new ReadConfig();
	
	// Fetching data from config.properties file via ReadConfig Class
	String BaseURL = readconfig.getApplicationURL();
	String username = readconfig.getUsername();
	String password = readconfig.getPassword();
	static WebDriver driver;
	public static Logger logger;

	// 	This method will execute before execution of test methods within current class
	@Parameters("browser")
	@BeforeClass
	public void initialize(String browser) {

		logger = Logger.getLogger("internetBanking");
		PropertyConfigurator.configure("Log4j.properties");

		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
				
			@SuppressWarnings("static-access")
			DesiredCapabilities caps = new DesiredCapabilities().internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);
			
			driver = new InternetExplorerDriver(caps);
		
		}
		driver.manage().window().maximize();
	}

	// 	This method will execute after execution of test methods within current class	
	@AfterClass
	public void tearDown() {

		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tcname) throws IOException {
		
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File source = takescreenshot.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+tcname+".png");
		
		FileUtils.copyFile(source, target);
		
	}

}

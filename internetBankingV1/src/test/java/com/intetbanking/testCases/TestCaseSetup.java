package com.intetbanking.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestCaseSetup {

	// Pre-defined variables mandatory for execution of every test case	
	String BaseURL = "http://demo.guru99.com/v4/index.php";
	String username = "mngr326123";
	String password = "qegagyg";
	static WebDriver driver;

	// 	This method will execute before execution of test methods within current class
	@BeforeClass
	public void initialize() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+
				"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// 	This method will execute after execution of test methods within current class	
	@AfterClass
	public void tearDown() {

		driver.quit();
	}

}

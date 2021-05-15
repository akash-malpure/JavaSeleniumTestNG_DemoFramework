package com.intetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.intetbanking.pageObjects.LoginPage;

public class TC_001_Login extends TestCaseSetup{

    // This method will attempt to login into the system & verify the page title	
	@Test
	public void testLogin() throws IOException {
		
		driver.get(BaseURL);
		
		logger.info("navigated to url: "+BaseURL);
		
		LoginPage loginObjects = new LoginPage(driver);
		
		loginObjects.setUsername(username);
		logger.info("Username set to:  "+username);
		
		loginObjects.setPassword(password);
		logger.info("Password is set");
		
		loginObjects.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("test case passed");
		}
		else {
			captureScreenshot(driver,"testLogin");
			Assert.assertTrue(false);
			logger.info("test case failed");
		}
			
	}
}

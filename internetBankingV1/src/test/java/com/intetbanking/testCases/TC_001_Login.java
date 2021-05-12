package com.intetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.intetbanking.pageObjects.LoginPage;

public class TC_001_Login extends TestCaseSetup{

    // This method will attempt to login into the system & verify the page title	
	@Test
	public void testLogin() {
		
		driver.get(BaseURL);
		LoginPage loginObjects = new LoginPage(driver);
		
		loginObjects.setUsername(username);
		loginObjects.setPassword(password);
		loginObjects.clickLogin();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
			
	}
}

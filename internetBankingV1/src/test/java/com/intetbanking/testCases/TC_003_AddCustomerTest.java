package com.intetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.intetbanking.pageObjects.AddCustomerPage;
import com.intetbanking.pageObjects.LoginPage;

public class TC_003_AddCustomerTest extends TestCaseSetup{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);

		driver.get(BaseURL);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();

		AddCustomerPage addcustomer = new AddCustomerPage(driver);
		wait.until(ExpectedConditions.visibilityOf(addcustomer.addNewCustomerLink));
		
		logger.info("Logged in to the website successfully.");

		addcustomer.clickAddNewCustomerLink();
		addcustomer.setCustomerName("Aishwarya");
		addcustomer.setCustomerGender("Female");
		addcustomer.setCustomerDOB("04","12","2000");
		Thread.sleep(3000);
		addcustomer.setCustomerAddress("India");
		addcustomer.setCustomerCity("PUN");
		addcustomer.setCustomerState("MH");
		addcustomer.setCustomerPIN("411004");
		addcustomer.setCustomerMobileNumber("6600000111");
		addcustomer.setCustomerEmail("ap"+randomString()+"@mpgroup.com");
		addcustomer.setCustomerPwd("PWD6600000111");
		Thread.sleep(3000);
		addcustomer.clickOnSubmit();

		Thread.sleep(3000);
		boolean result=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(result) {
			Assert.assertTrue(true);
			logger.info("Customer has been added successfully!!");
		}
		else {
			logger.warn("Error in adding customer!!");
			captureScreenshot(driver, "TC_003_AddCustomerTest");
			Assert.assertTrue(false);
		}
	}
	
	public String randomString() {
		String randomString =RandomStringUtils.randomAlphanumeric(5);
		return randomString;
		
	}
	
}

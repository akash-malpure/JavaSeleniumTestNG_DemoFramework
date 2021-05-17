package com.intetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intetbanking.pageObjects.LoginPage;
import com.intetbanking.utils.ExcelUtils;

public class TC_002_DDT_Login extends TestCaseSetup{
	
	@Test(dataProvider="LoginData")
	public void DDT_login(String user, String pwd) throws IOException {
		
		LoginPage loginPage = new LoginPage(driver);
		driver.get(BaseURL);
		
		loginPage.setUsername(user);
		loginPage.setPassword(pwd);
		loginPage.clickLogin();
	
		if(verifyAlertPresent()) {
			captureScreenshot(driver, "DDT_Login");
			logger.warn("Login failed due to wrong username or password");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);		
			
		}
		else {
			logger.info("Login successfull");
			Assert.assertTrue(true);
			loginPage.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Logout successfull");
		}
		
	}
	
	public boolean verifyAlertPresent() {
		
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\intetbanking\\testData\\LoginDataFile.xlsx";
		System.out.println(path);
		int rowNumber = ExcelUtils.getRowCount(path, "Sheet1");
		int colNumber = ExcelUtils.getColumnCount(path ,"Sheet1", rowNumber);
		
		String logindata[][] = new String[rowNumber][colNumber];
		
		for(int i=1;i<=rowNumber;i++) 
		{
			for(int j=0;j<colNumber;j++) 
			{
				
				logindata[i-1][j] = ExcelUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		
		return logindata;
		
	}
}

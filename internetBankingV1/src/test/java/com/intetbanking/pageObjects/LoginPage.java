package com.intetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	// Initializing the elements present in this class.	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Searching for WebElement : username input box 
	@FindBy(name="uid")
	WebElement username;

	// Searching for WebElement : password input box	
	@FindBy(name="password")
	WebElement password;

	// Searching for WebElement : Login Button
	@FindBy(name="btnLogin")
	WebElement loginButton;

	// Creating method to enter text in username input field
	public void setUsername(String uname) {
		username.click();
		username.sendKeys(uname);
	}

	// Creating method to enter text in username input field
	public void setPassword(String pwd) {
		password.click();
		password.sendKeys(pwd);
	}
	
	// Creating method to click on login button
	public void clickLogin() {
		loginButton.click();

	}
	
}

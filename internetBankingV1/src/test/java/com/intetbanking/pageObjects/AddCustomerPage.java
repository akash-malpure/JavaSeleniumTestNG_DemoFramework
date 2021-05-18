package com.intetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.LINK_TEXT, using = "New Customer")
	public
	WebElement addNewCustomerLink;

	@FindBy(how = How.NAME, using = "name")
	WebElement customerName;
	
	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	WebElement genderFemale;
	
	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	WebElement genderMale;
	
	@FindBy(how = How.NAME, using = "dob")
	WebElement dateOfBirth;
	
	@FindBy(how = How.NAME, using = "addr")
	WebElement address;
	
	@FindBy(how = How.NAME, using = "city")
	WebElement city;
	
	@FindBy(how = How.NAME, using = "state")
	WebElement state;
	
	@FindBy(how = How.NAME, using = "pinno")
	WebElement pincode;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement mobileNo;
	
	@FindBy(how = How.NAME, using = "emailid")
	WebElement emailid;
	
	@FindBy(how = How.NAME, using = "password")
	WebElement password;
	
	@FindBy(how = How.NAME, using = "sub")
	WebElement submit;
	
	
	public void clickAddNewCustomerLink() {
		addNewCustomerLink.click();
	}

	public void setCustomerName(String name) {
		customerName.click();
		customerName.sendKeys(name);
	}
	
	public void setCustomerGender(String gender) {
		
		if(gender.equalsIgnoreCase("Female"))
			genderFemale.click();
		else if(gender.equalsIgnoreCase("Male"))
			genderMale.click();
	}
	
	public void setCustomerDOB(String mm,String dd, String yyyy) {
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yyyy);
	}
	
	public void setCustomerAddress(String customerAddress) {
		address.click();
		address.sendKeys(customerAddress);
	}
	
	public void setCustomerCity(String customerCity) {
		city.click();
		city.sendKeys(customerCity);
	}
	
	public void setCustomerState(String customerState) {
		state.click();
		state.sendKeys(customerState);
	}
	
	public void setCustomerPIN(String customerPin) {
		pincode.click();
		pincode.sendKeys(customerPin);
	}
	
	public void setCustomerMobileNumber(String mobileNumber) {
		mobileNo.click();
		mobileNo.sendKeys(mobileNumber);
	}

	public void setCustomerEmail(String email) {
		emailid.click();
		emailid.sendKeys(email);
	}
	
	public void setCustomerPwd(String customerPwd) {
		password.click();
		password.sendKeys(customerPwd);
	}
	
	public void clickOnSubmit() {
		submit.click();
	}
	
}

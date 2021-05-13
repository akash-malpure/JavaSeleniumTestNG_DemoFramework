package com.intetbanking.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {

	Properties pro;

	// Creating contsructor to initialize file object associated with config.properties & to initialize properties object
	public ReadConfig(){

		File file = new File("./Configuration/config.properties");

		try {
			
			FileInputStream fis = new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is: "+e.getMessage());
		}
	}

	
	// Reading baseURL from config.pro & returning it	
	public String getApplicationURL() {

		String url = pro.getProperty("BaseURL");
		return url;

	}
	
	// Reading USERNAME from config.pro & returning it	
	public String getUsername() {

		String username = pro.getProperty("username");
		return username;

	}
	
	// Reading PASSWORD from config.pro & returning it	
	public String getPassword() {

		String pwd = pro.getProperty("password");
		return pwd;

	}
	
	// Reading CHROME WEBDRIVER PATH from config.pro & returning it	
	public String getChromePath() {

		String chromePath = pro.getProperty("chromepath");
		return chromePath;

	}
	
	// Reading IE WEBDRIVER PATH from config.pro & returning it	
	public String getIEPath() {

		String iePath = pro.getProperty("iepath");
		return iePath;

	}
	
	// Reading FIREFOX WEBDRIVER PATH from config.pro & returning it	
	public String getFirefoxPath() {

		String firefoxPath = pro.getProperty("firefoxpath");
		return firefoxPath;

	}
	
}

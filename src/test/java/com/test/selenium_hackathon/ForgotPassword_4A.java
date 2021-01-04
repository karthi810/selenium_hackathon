package com.test.selenium_hackathon;

import org.openqa.selenium.WebElement;

public class ForgotPassword_4A extends SalesforceUltility{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String[] credentials = readConfigFile().split(" ");
		
		LaunchChromeBrowser();
		gotoURL(credentials[2]);
		
		WebElement forgotPassword = setXpath("//a[@id='forgot_password_link']");
		
		forgotPassword.click();	
		WebElement username = setXpath("//input[@id='un']");
		explicitWait(5000, username);
		
		username.sendKeys(credentials[0]);
		
		WebElement continueButton = setXpath("//input[@id='continue']");
		continueButton.click();
		
		quitBrowser();
		
	}

}

package com.test.selenium_hackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Check_RemeberMe_3 extends SalesforceUltility{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		String[] credentials = readConfigFile().split(" ");

		LaunchChromeBrowser();
		gotoURL(credentials[2]);

		WebElement username = setXpath("//input[@id='username']");
		WebElement password = setXpath("//input[@id='password']");
		WebElement loginButton = setXpath("//input[@id='Login']");
		WebElement rememberMe = setXpath("//input[@id='rememberUn']");
		
		loginDetails(username, credentials[0]);
		explicitWait(5000, username);

		loginDetails(password, credentials[1]);
		explicitWait(5000, password);
		
		rememberMe.click();
		explicitWait(5000, loginButton);
		
		login(loginButton);
		
		WebElement userLabel = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		explicitWait(5000, userLabel);
		
		WebElement userProfileName = setXpath("//span[@id='userNavLabel']");
		userProfileName.click();
		
		WebElement logout = setXpath("//a[contains(text(),'Logout')]");

		logout.click();
		
		//explicitWait(5000, username);
		quitBrowser();

	}

}

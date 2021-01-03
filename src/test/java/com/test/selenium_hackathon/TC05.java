package com.test.selenium_hackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC05 extends SalesforceUltility{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		String URL = "https://login.salesforce.com/";
		String usernameVal = "karthika@betsy.com";
		String passwordVal = "*****";

		LaunchChromeBrowser();
		gotoURL(URL);

		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));

		
		loginDetails(username, usernameVal);
		explicitWait(5000, username);

		loginDetails(password, passwordVal);
		explicitWait(5000, password);
		
		login(loginButton);
		WebElement userLabel = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		explicitWait(5000, userLabel);
		
		userLabel.click();
		WebElement myProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));		
		explicitWait(5000, myProfile);
		
		quitBrowser();
	}

}

package com.test.selenium_hackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC05 extends SalesforceUltility{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		String[] credentials = readConfigFile().split(" ");

		LaunchChromeBrowser();
		gotoURL(credentials[2]);

		WebElement username = setXpath("//input[@id='username']");
		WebElement password = setXpath("//input[@id='password']");
		WebElement loginButton = setXpath("//input[@id='Login']");

		loginDetails(username, credentials[0]);
		explicitWait(5000, username);

		loginDetails(password, credentials[1]);
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

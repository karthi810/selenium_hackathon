package com.test.selenium_hackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPassword_4B extends SalesforceUltility{

		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub

			String[] credentials = readConfigFile().split(" ");
			String usernameVal = "123";
			String passwordVal = "22131";
			

			LaunchChromeBrowser();
			gotoURL(credentials[2]);
			
			WebElement username = setXpath("//input[@id='username']");
			WebElement password = setXpath("//input[@id='password']");
			WebElement loginButton = setXpath("//input[@id='Login']");

			loginDetails(username, usernameVal);
			explicitWait(5000, username);

			loginDetails(password, passwordVal);
			explicitWait(5000, password);

			login(loginButton);
			
			//WebElement userLabel = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
			//explicitWait(5000, userLabel);
			
			quitBrowser();
			
		}

}

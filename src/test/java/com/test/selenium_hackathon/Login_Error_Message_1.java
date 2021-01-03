package com.test.selenium_hackathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.test.selenium_hackathon.SalesforceUltility;

public class Login_Error_Message_1 extends SalesforceUltility{

	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub

		String URL = "https://login.salesforce.com/";
		String usernameVal = "karthika@betsy.com";
		String passwordVal = "*****";

		LaunchChromeBrowser();
		gotoURL(URL);

		WebElement username = setXpath("//input[@id='username']");
		WebElement password = setXpath("//input[@id='password']");
		WebElement loginButton = setXpath("//input[@id='Login']");

		loginDetails(username, usernameVal);
		explicitWait(5000, username);

		password.clear();

		login(loginButton);

		explicitWait(5000, password);

		quitBrowser();

	}
}

package com.test.selenium_hackathon;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC17 extends SalesforceUltility{

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
		WebElement opportunitiesTab = setXpath("//a[normalize-space()='Opportunities']");
		explicitWait(5000, opportunitiesTab);
		
		opportunitiesTab.click();
		Thread.sleep(3000);
		WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");
		explicitWait(9, closeDialog);
		closeDialog.click();
		
		WebElement oppPipelineLink = setXpath("//a[normalize-space()='Opportunity Pipeline']");
		oppPipelineLink.click();
		
		Thread.sleep(3000);

		quitBrowser();
	}

}

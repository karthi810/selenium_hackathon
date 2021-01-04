package com.test.selenium_hackathon;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC11 extends SalesforceUltility{

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
		WebElement accountsTab = setXpath("//a[@title='Accounts Tab']");
		explicitWait(5000, accountsTab);
		
		accountsTab.click();
		//Thread.sleep(2000);
		WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");
		closeDialog.click();
		
		WebElement newViewLink = setXpath("//a[contains(text(),'Create New View')]");
		explicitWait(8, newViewLink);		
		
		newViewLink.click();
		
		WebElement viewName = setXpath("//input[@id='fname']");
		viewName.sendKeys("Accounts View Test");
		
		WebElement viewUniqueName = setXpath("//input[@id='devname']");
		viewUniqueName.click();

		
		WebElement saveButton = setXpath("//input[@name='save']");
		saveButton.click();
		
		Thread.sleep(3000);

		quitBrowser();
	}

}

package com.test.selenium_hackathon;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class TC12 extends SalesforceUltility{

	public static void main(String[] args) throws Exception{
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

		loginDetails(password, passwordVal);
		explicitWait(5000, password);
		
		login(loginButton);
		WebElement accountsTab = setXpath("//a[@title='Accounts Tab']");
		explicitWait(5000, accountsTab);
		
		accountsTab.click();
		
		WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");
		explicitWait(5, closeDialog);
		closeDialog.click();
		//Thread.sleep(4000);
		
		WebElement viewDropDown = setXpath("//select[@title='View:']");
		explicitWait(8, viewDropDown);		
		
		Select selectView = new Select(viewDropDown);
		selectView.selectByVisibleText("Automation Test1");
		
		WebElement editLink = setXpath("//a[normalize-space()='Edit']");
		editLink.click();
		
		WebElement viewName = setXpath("//input[@id='fname']");
		viewName.sendKeys("Automation Test");
		
		WebElement fieldDropDown = setXpath("//select[@id='fcol1']");
		Select selectField = new Select(fieldDropDown);
		selectField.selectByVisibleText("Account Name");
		
		WebElement operatorDropDown = setXpath("//select[@id='fop1']");
		Select selectOperator = new Select(operatorDropDown);
		selectOperator.selectByVisibleText("contains");
		
		WebElement valueField = setXpath("//input[@id='fval1']");
		valueField.clear();
		valueField.sendKeys("b");
		
		
		WebElement saveButton = setXpath("//input[@name='save']");
		saveButton.click();
		
		Thread.sleep(3000);

		quitBrowser();
	}

}

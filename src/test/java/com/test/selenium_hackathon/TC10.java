package com.test.selenium_hackathon;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC10 extends SalesforceUltility{

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
		//Thread.sleep(2000);
		WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");
		closeDialog.click();
		
		WebElement newButton = setXpath("//input[@value=' New ']");
		explicitWait(8, newButton);		
		
		newButton.click();
		
		WebElement accountName = setXpath("//input[@id='acc2']");
		accountName.sendKeys("Banking");
		
		WebElement typeDropdown = setXpath("//select[@id='acc6']");
		Select selectType = new Select(typeDropdown);
		
		selectType.selectByVisibleText("Technology Partner");
		
		WebElement customerPriorityDropDown = setXpath("//select[@id='00N4x00000DW6NT']");
		Select customerPriority = new Select(customerPriorityDropDown);
		
		customerPriority.selectByVisibleText("High");
		
		WebElement saveButton = setXpath("//input[@name='save']");
		saveButton.click();
		
		Thread.sleep(3000);

		quitBrowser();
	}

}

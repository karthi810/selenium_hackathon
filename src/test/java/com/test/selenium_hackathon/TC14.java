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

public class TC14 extends SalesforceUltility{

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
		explicitWait(8, closeDialog);
		closeDialog.click();
		//Thread.sleep(4000);
		
		WebElement accountReport = setXpath("//a[contains(text(),'Accounts with last activity > 30 days')]");
		explicitWait(8, accountReport);	
		
		accountReport.click();
		
		WebElement dateField = setXpath("//input[@id='ext-gen20']");
		dateField.click();
		
		WebElement createDate = setXpath("//div[@class='x-combo-list-item x-combo-selected']");
		createDate.click();
		DateFormat dateformat = new SimpleDateFormat("MM/d/yyyy");
		Date date = new Date();
		String currDate = dateformat.format(date);
		
		WebElement fromDate = setXpath("//input[@name='startDate']");
		fromDate.sendKeys(currDate);
				
		WebElement toDate = setXpath("//input[@name='endDate']");
		toDate.clear();
		toDate.sendKeys(currDate);
		
		
		Thread.sleep(3000);
		WebElement saveButton = setXpath("//button[normalize-space()='Save']");
		saveButton.click();
		
		driver.switchTo().activeElement();
		
		WebElement reportName = setXpath("//input[@id='saveReportDlg_reportNameField']");
		WebElement reportUniqueName = setXpath("//input[@id='saveReportDlg_DeveloperName']");
			
		reportName.clear();
		reportName.sendKeys("ReportTest1");
		reportUniqueName.click();
		
		WebElement saveButton1 = setXpath("(//button[text()='Save'])[2]");
		saveButton1.click();
		Thread.sleep(3000);

		quitBrowser();
	}

}

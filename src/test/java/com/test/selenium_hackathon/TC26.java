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

public class TC26 extends SalesforceUltility {

	public static void main(String[] args) throws Exception {
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
		WebElement contactsTab = setXpath("//a[normalize-space()='Contacts']");
		explicitWait(5, contactsTab);

		contactsTab.click();
		//Thread.sleep(3000);
		try {
			explicitWait(2000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
			WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");			
			closeDialog.click();
			System.out.println("Close Dialog found");
		} catch (Exception e) {
			System.out.println("Close Dialog not found");
		}

		explicitWait(5, driver.findElement(By.xpath("//a[normalize-space()='Create New View']")));
		WebElement createNewView = setXpath("//a[normalize-space()='Create New View']");
		createNewView.click();
		
		WebElement viewName = setXpath("//input[@id='fname']");
		explicitWait(3000, viewName);

		viewName.sendKeys("Contacts View Test");
		
		WebElement viewUniqueName = setXpath("//input[@id='devname']");
		viewUniqueName.click();
		
		
		WebElement saveButton = setXpath("//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]");
		saveButton.click();

		
		
		quitBrowser();
	}

}

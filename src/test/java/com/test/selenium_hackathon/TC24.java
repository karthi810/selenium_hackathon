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

public class TC24 extends SalesforceUltility {

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

		loginDetails(password, passwordVal);
		explicitWait(5000, password);

		login(loginButton);
		WebElement leadsTab = setXpath("//a[normalize-space()='Leads']");
		explicitWait(5, leadsTab);

		leadsTab.click();
		//Thread.sleep(3000);
		try {
			explicitWait(2000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
			WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");			
			closeDialog.click();
			System.out.println("Close Dialog found");
		} catch (Exception e) {
			System.out.println("Close Dialog not found");
		}

		explicitWait(5, driver.findElement(By.xpath("//input[@title='New']")));
		WebElement newButton = setXpath("//input[@title='New']");
		newButton.click();
		
		WebElement lastName = setXpath("//input[@id='name_lastlea2']");
		explicitWait(3000, lastName);

		lastName.sendKeys("ABCD");
		
		WebElement companyName = setXpath("//input[@id='lea3']");
		companyName.sendKeys("ABCD");
		
		WebElement SaveButton = setXpath("//td[@id='topButtonRow']//input[@title='Save']");
		SaveButton.click();
		
		explicitWait(5000, driver.findElement(By.xpath("//td[@id='topButtonRow']//input[@title='Clone']")));
		
		
		quitBrowser();
	}

}

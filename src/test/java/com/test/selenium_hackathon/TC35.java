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

public class TC35 extends SalesforceUltility {

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
		
		WebElement allTab = setXpath("//img[@title='All Tabs']");
		allTab.click();
		
		Thread.sleep(2000);
		WebElement customizeMyTabs = setXpath("//input[@title='Customize My Tabs']");
		explicitWait(5000, customizeMyTabs);
		
		customizeMyTabs.click();
		WebElement selectedTabDropDown = setXpath("//select[@id='duel_select_1']");
		Select selectedTab = new Select(selectedTabDropDown);
		selectedTab.selectByVisibleText("Libraries");
		
		WebElement removeButton = setXpath("//img[@title='Remove']");
		removeButton.click();
		
		WebElement saveButton = setXpath("//input[@value=' Save ']");		
		saveButton.click();
		
		
		//Thread.sleep(3000);
//		try {
//			explicitWait(2000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
//			WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");			
//			closeDialog.click();
//			System.out.println("Close Dialog found");
//		} catch (Exception e) {
//			System.out.println("Close Dialog not found");
//		}

		//explicitWait(5, driver.findElement(By.xpath("//select[@id='fcf']")));
		
		WebElement userProfileButton = setXpath("//span[@id='userNavLabel']");
		explicitWait(5000, userProfileButton);
		
		userProfileButton.click();
		WebElement logout = setXpath("//a[normalize-space()='Logout']");
		logout.click();
		
		Thread.sleep(2000);
		WebElement username1 = setXpath("//input[@id='username']");
		WebElement password1 = setXpath("//input[@id='password']");
		WebElement loginButton1 = setXpath("//input[@id='Login']");
		
		loginDetails(username1, credentials[0]);
		explicitWait(5000, username1);

		loginDetails(password1, credentials[1]);
		explicitWait(5000, password1);

		login(loginButton1);
		WebElement leadsTab1 = setXpath("//a[normalize-space()='Leads']");
		explicitWait(5, leadsTab1);
		
		
		quitBrowser();
	}

}

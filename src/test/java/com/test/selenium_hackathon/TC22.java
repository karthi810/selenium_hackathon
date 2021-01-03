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

public class TC22 extends SalesforceUltility {

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
		Thread.sleep(3000);
		try {
			explicitWait(5000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
			WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");			
			closeDialog.click();
			System.out.println("Close Dialog found");
		} catch (Exception e) {
			System.out.println("Close Dialog not found. Retrying to find");
			explicitWait(5000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
			WebElement closeDialog1 = setXpath("//a[@id='tryLexDialogX']");			
			closeDialog1.click();
			System.out.println("Close Dialog found now ");
		}

		explicitWait(5, driver.findElement(By.xpath("//select[@id='fcf']")));
		Select selectLeads = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		
		selectLeads.selectByVisibleText("Today's Leads");
		explicitWait(2000, driver.findElement(By.xpath("//input[@title='New Lead']")));
		
		WebElement newSelect = setXpath("//select[@id='00B4x000007Wubn_listSelect']");
		Select s = new Select(newSelect);
		s.selectByVisibleText("My Unread Leads");
		
		Thread.sleep(2000);
		//explicitWait(10000, driver.findElement(By.xpath("//input[@value='New Lead']")));
		
		WebElement usernameButton = setXpath("//div[@id='userNav-arrow']");
		usernameButton.click();
		
		WebElement logout = setXpath("//a[normalize-space()='Logout']");
		logout.click();
		
		Thread.sleep(2000);//explicitWait(9000, driver.findElement(By.xpath("//input[@id='username']")));
		
		WebElement username1 = setXpath("//input[@id='username']");
		WebElement password1 = setXpath("//input[@id='password']");
		WebElement loginButton1 = setXpath("//input[@id='Login']");
		
		loginDetails(username1, usernameVal);
		explicitWait(5000, username1);

		loginDetails(password1, passwordVal);
		explicitWait(5000, password1);

		login(loginButton1);
		WebElement leadsTab1 = setXpath("//a[normalize-space()='Leads']");
		explicitWait(5, leadsTab1);

		leadsTab1.click();
		//Thread.sleep(3000);
		try {
			explicitWait(2000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
			WebElement closeDialog1 = setXpath("//a[@id='tryLexDialogX']");			
			closeDialog1.click();
			System.out.println("Close Dialog found");
		} catch (Exception e) {
			System.out.println("Close Dialog not found");
		}

		WebElement goButton = setXpath("//input[@title='Go!']");
		goButton.click();
		explicitWait(2000, driver.findElement(By.xpath("//input[@title='Change Status']")));
		
		/*List<WebElement> viewLeads = selectLeads.getOptions();
		for(int i = 0; i <viewLeads.size(); i++) {
			System.out.println(viewLeads.get(i).getText());
		}*/
		quitBrowser();
	}

}

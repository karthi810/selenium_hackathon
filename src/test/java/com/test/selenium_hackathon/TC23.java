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

public class TC23 extends SalesforceUltility {

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

		explicitWait(5, driver.findElement(By.xpath("//select[@id='fcf']")));
		Select selectLeads = new Select(driver.findElement(By.xpath("//select[@id='fcf']")));
		
		List<WebElement> viewLeads = selectLeads.getOptions();
		for(int i = 0; i <viewLeads.size(); i++) {
			System.out.println(viewLeads.get(i).getText());
		}
		
		selectLeads.selectByVisibleText("Today's Leads");
		WebElement goButton = setXpath("//input[@title='Go!']");
		goButton.click();
		explicitWait(3000, driver.findElement(By.xpath("//input[@value='New Lead']")));
		
		
		quitBrowser();
	}

}

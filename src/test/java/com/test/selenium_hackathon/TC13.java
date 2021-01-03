package com.test.selenium_hackathon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;

public class TC13 extends SalesforceUltility{

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
		
		WebElement mergeAccountLink = setXpath("//a[contains(text(),'Merge Accounts')]");
		explicitWait(8, mergeAccountLink);	
		
		mergeAccountLink.click();
		
		WebElement accountSearch = setXpath("//input[@id='srch']");
		accountSearch.sendKeys("Automotive Test");
		
		WebElement findAccountsButton = setXpath("//div[@class='pbWizardBody']//input[2]");
		findAccountsButton.click();
		
		explicitWait(6, driver.findElement(By.xpath("//th[normalize-space()='Account']")));
		
		WebElement nextButton = setXpath("//input[@value=' Next ']");
		nextButton.click();
		
		WebElement mergeButton = setXpath("//input[@value=' Merge ']");
		mergeButton.click();
		
		Alert alertPopUp = driver.switchTo().alert();
		alertPopUp.accept();
		
		
		
		Thread.sleep(3000);

		quitBrowser();
	}

}

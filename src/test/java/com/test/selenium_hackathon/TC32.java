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

public class TC32 extends SalesforceUltility {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String URL = "https://login.salesforce.com/";
		String usernameVal = "karthika@betsy.com";
		String passwordVal = "Betsy@28";

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
		WebElement contactsTab = setXpath("//a[normalize-space()='Contacts']");
		explicitWait(5, contactsTab);

		contactsTab.click();
		//Thread.sleep(3000);
		try {
			explicitWait(6000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
			WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");			
			closeDialog.click();
			System.out.println("Close Dialog found");
		} catch (Exception e) {
			System.out.println("Close Dialog not found");
		}

		//explicitWait(5, driver.findElement(By.xpath("//select[@id='fcf']")));
		
		WebElement newButton = setXpath("//input[@value=' New ']");
		newButton.click();
		
		WebElement lastName = setXpath("//input[@id='name_lastcon2']");
		explicitWait(5000, lastName);
		
		lastName.sendKeys("Indian");
		
		WebElement accountNameSearch = setXpath("//img[@title='Account Name Lookup (New Window)']");
		accountNameSearch.click();
		
		ArrayList<String> totalWindows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total no of Windows open : " + totalWindows.size());
		driver.switchTo().window(totalWindows.get(totalWindows.size() - 1));
		
		int frameCount = driver.findElements(By.tagName("frame")).size();
		System.out.println("Frame count = "+frameCount);
		
		driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
		
		WebElement serachAccountName = setXpath("//input[@id='lksrch']");
		serachAccountName.sendKeys("global media");
		
		WebElement goButton = setXpath("//input[@value=' Go! ']");
		goButton.click();

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@id='resultsFrame']")));
		Thread.sleep(2000);
		WebElement selectAccountName = setXpath("//a[@class=' dataCell ']");
		//System.out.println("Before click" +driver.getWindowHandle().toString());
		selectAccountName.click();
		
		//System.out.println(driver.getWindowHandle().toString());
		driver.switchTo().window(totalWindows.get(0));

		
		WebElement saveAndNewButton = setXpath("//div[@class='pbHeader']//input[@value='Save & New']");
		saveAndNewButton.click();
		
		explicitWait(5000, driver.findElement(By.xpath("//div[@class='pbHeader']//input[@value='Save & New']")));
				
		
		quitBrowser();
	}

}

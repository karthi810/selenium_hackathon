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

public class TC25 extends SalesforceUltility {

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

		explicitWait(5, driver.findElement(By.xpath("//input[@title='New']")));
		WebElement newButton = setXpath("//input[@title='New']");
		newButton.click();
		
		WebElement lastName = setXpath("//input[@id='name_lastcon2']");
		explicitWait(3000, lastName);

		lastName.sendKeys("ABCD");
		
		WebElement searchAccountName = setXpath("//img[@title='Account Name Lookup (New Window)']");
		searchAccountName.click();
		
		ArrayList<String> totalWindows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total no of Tabs open : " + totalWindows.size());
		driver.switchTo().window(totalWindows.get(totalWindows.size() - 1));
		
		int frameCount = driver.findElements(By.tagName("frame")).size();
		System.out.println("Frame count = "+frameCount);
		
		driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
		
		WebElement serachAccount = setXpath("//input[@id='lksrch']");
		serachAccount.sendKeys("banking");
		
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
		//driver.switchTo().getWindowHandle();
		
		WebElement saveButton = setXpath("//td[@id='bottomButtonRow']//input[@title='Save']");
		saveButton.click();

		
		
		quitBrowser();
	}

}

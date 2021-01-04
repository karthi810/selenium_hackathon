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

public class TC36 extends SalesforceUltility {

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
		WebElement homeTab = setXpath("//a[normalize-space()='Home']");
		homeTab.click();
		
		Thread.sleep(3000);
		try {
			explicitWait(2000, driver.findElement(By.xpath("//a[@id='tryLexDialogX']")));
			WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");			
			closeDialog.click();
			System.out.println("Close Dialog found");
		} catch (Exception e) {
			System.out.println("Close Dialog not found");
		}
		
		WebElement currDateTimeLink = setXpath("//a[@href='/00U/c?md3=4&md0=2021']");
		currDateTimeLink.click();
		
		explicitWait(5000, driver.findElement(By.xpath("//img[@title='Single User View - Selected']")));
		
		WebElement eightPmTab = setXpath("//div[@id='p:f:j_id25:j_id61:28:j_id64']//a[normalize-space()='8:00 PM']");
		explicitWait(5000, eightPmTab);
		
		eightPmTab.click();
		
		WebElement subjectComboButton = setXpath("//img[@title='Subject Combo (New Window)']");
		subjectComboButton.click();
		
		ArrayList<String> totalWindows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total no of Tabs open : " + totalWindows.size());
		driver.switchTo().window(totalWindows.get(totalWindows.size() - 1));
		
		WebElement othersLink = setXpath("//div[@class='choicesBox tertiaryPalette brandSecondaryBrd']//ul//li[5]//a");
		othersLink.click();
		
		Thread.sleep(2000);
		
		driver.switchTo().window(totalWindows.get(0));
		
		
		WebElement endDate = setXpath("//input[@id='EndDateTime_time']");
		endDate.click();
		
		WebElement selectEndTime = setXpath("//div[@id='timePickerItem_42']");
		selectEndTime.click();
		
		WebElement saveButton = setXpath("//td[@id='topButtonRow']//input[@title='Save']");
		saveButton.click();
		
		explicitWait(5000, driver.findElement(By.xpath("//span[contains(text(),'Other')]")));
		
		//Thread.sleep(2000);
		
		
		quitBrowser();
	}

}

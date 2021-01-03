package com.test.selenium_hackathon;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC07 extends SalesforceUltility{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		String URL = "https://login.salesforce.com/";
		String usernameVal = "karthika@betsy.com";
		String passwordVal = "******";

		LaunchChromeBrowser();
		gotoURL(URL);

		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='Login']"));

		
		loginDetails(username, usernameVal);
		explicitWait(5000, username);

		loginDetails(password, passwordVal);
		explicitWait(5000, password);
		
		login(loginButton);
		WebElement userLabel = setXpath("//span[@id='userNavLabel']");
		explicitWait(5000, userLabel);
		
		userLabel.click();
		WebElement mySettings = setXpath("//a[contains(text(),'My Settings')]");		
		explicitWait(5000, mySettings);
		mySettings.click();

		//downloadLoginHistory();
		
		//displayAndLayout();
		
		//emailSetup();
		calendarAndReminder();

		Thread.sleep(3000);
		
		quitBrowser();
	}
	

	public static void displayAndLayout() throws Exception{
		
		WebElement displayLayout = setXpath("//span[@id='DisplayAndLayout_font']");
		displayLayout.click();
		
		WebElement customizeTabs = setXpath("//span[@id='CustomizeTabs_font']");
		customizeTabs.click();
		
		WebElement customApp = setXpath("//select[@id='p4']");
		Select selectCustomApp = new Select(customApp);
		
		selectCustomApp.selectByVisibleText("Salesforce Chatter");
		
		WebElement availableTabs = setXpath("//select[@id='duel_select_0']");
		Select selectAvailableTabs = new Select(availableTabs);
		
		selectAvailableTabs.selectByVisibleText("Reports");
		WebElement addButton = setXpath("//a[@id='duel_select_0_right']");
		addButton.click();
		
		WebElement saveButton = setXpath("//input[@value=' Save ']");
		saveButton.click();
		
		Thread.sleep(3000);
	}
	
	public static void downloadLoginHistory() throws Exception{
		
		WebElement personalInfoLink = setXpath("//span[@id='PersonalInfo_font']");
		explicitWait(8, personalInfoLink);
		
		personalInfoLink.click();
		WebElement loginHistory = setXpath("//a[@id='LoginHistory_font']");
		explicitWait(7, loginHistory);
		
		loginHistory.click();
		
		WebElement downloadLoginHistory = setXpath("//a[contains(text(),'Download login history for last six months, includ')]");
		downloadLoginHistory.click();
	}
	
	public static void emailSetup() throws Exception{
		
		WebElement emailLink = setXpath("//span[@id='EmailSetup_font']");
		emailLink.click();
		
		WebElement emailSettings = setXpath("//span[@id='EmailSettings_font']");
		emailSettings.click();
		
		WebElement emailName = setXpath("//input[@id='sender_name']");
		emailName.clear();
		emailName.sendKeys("Karthika Kumaran");
		
		WebElement emailAddress = setXpath("//input[@id='sender_email']");
		emailAddress.clear();
		emailAddress.sendKeys("karthi810@gmail.com");
		
		WebElement automaticBCC = setXpath("//input[@id='auto_bcc1']");
		automaticBCC.click();
		
		WebElement saveButton = setXpath("//input[@value=' Save ']");
		saveButton.click();
	}
	
	public static void calendarAndReminder() throws Exception{
		
		WebElement calendarReminder = setXpath("//span[@id='CalendarAndReminders_font']");
		calendarReminder.click();
		
		WebElement activityReminder = setXpath("//span[@id='Reminders_font']");
		activityReminder.click();
		
		WebElement testReminderButton = setXpath("//input[@id='testbtn']");
		testReminderButton.click();
		
		Thread.sleep(3000);
		ArrayList<String> totalWindows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total no of Tabs open : " + totalWindows.size());
		driver.switchTo().window(totalWindows.get(1));
		
		driver.findElement(By.xpath("//input[@id='dismiss_all']"));
		Thread.sleep(3000);
		
		driver.close();
		//driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
	}
	
	

}

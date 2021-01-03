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

public class TC16 extends SalesforceUltility{

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
		WebElement opportunitiesTab = setXpath("//a[normalize-space()='Opportunities']");
		explicitWait(5000, opportunitiesTab);
		
		opportunitiesTab.click();
		Thread.sleep(2000);
		WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");
		explicitWait(9, closeDialog);
		closeDialog.click();
		
		WebElement newButton = setXpath("//input[@value=' New ']");
		newButton.click();
		
		WebElement oppName = setXpath("//input[@id='opp3']");
		oppName.sendKeys("Test Opportunity 1");
		
		WebElement closeDate = setXpath("//a[@tabindex='7']");
		closeDate.click();
		
		WebElement selectStage = setXpath("//select[@id='opp11']");
		Select stage = new Select(selectStage);
		stage.selectByVisibleText("Prospecting");
		
		WebElement selectLeadSource = setXpath("//select[@id='opp6']");
		Select leadSource = new Select(selectLeadSource);
		leadSource.selectByVisibleText("Web");
		
		WebElement primaryCampaign = setXpath("//img[@title='Primary Campaign Source Lookup (New Window)']");
		primaryCampaign.click();
		
		//Thread.sleep(3000);
		ArrayList<String> totalWindows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total no of Tabs open : " + totalWindows.size());
		driver.switchTo().window(totalWindows.get(totalWindows.size() - 1));
		
		int frameCount = driver.findElements(By.tagName("frame")).size();
		System.out.println("Frame count = "+frameCount);
		
		driver.switchTo().frame(driver.findElement(By.id("searchFrame")));
		
		WebElement serachcampaign = setXpath("//input[@id='lksrch']");
		serachcampaign.sendKeys("test campaign");
		
		WebElement goButton = setXpath("//input[@value=' Go! ']");
		goButton.click();

		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@id='resultsFrame']")));
		Thread.sleep(2000);
		WebElement selectTestCampaign = setXpath("//a[@class=' dataCell ']");
		//System.out.println("Before click" +driver.getWindowHandle().toString());
		selectTestCampaign.click();
		
		//System.out.println(driver.getWindowHandle().toString());
		driver.switchTo().window(totalWindows.get(0));
		//driver.switchTo().getWindowHandle();
		
		WebElement saveButton = setXpath("//td[@id='bottomButtonRow']//input[@title='Save']");
		saveButton.click();
		
		Thread.sleep(3000);

		quitBrowser();
	}

}

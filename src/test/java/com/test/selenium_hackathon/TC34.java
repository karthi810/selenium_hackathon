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

public class TC34 extends SalesforceUltility {

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
		
		WebElement userProfileName = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		WebElement myProfile = driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
		userProfileName.click();
		explicitWait(5, myProfile);
		
		myProfile.click();
		WebElement editProfileImg = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		explicitWait(3, editProfileImg);
		
		WebElement profileName = setXpath("//span[@id='tailBreadcrumbNode']");
		System.out.println("Profile name before update : "+profileName.getText());
		
		editProfileImg.click();
		
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
		
		WebElement aboutTab = driver.findElement(By.xpath("//a[normalize-space()='About']"));
		
		aboutTab.click();
		explicitWait(3, driver.findElement(By.xpath("//input[@id='firstName']")));	
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys("Ashwin");
		
		WebElement saveButton = setXpath("//div[@class='net-buttons zen-mtl']//input[@value='Save All']");
		
		saveButton.click();
		
		driver.switchTo().defaultContent();
		
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
		
		WebElement profileName1 = setXpath("//span[@id='tailBreadcrumbNode']");
		System.out.println("After updating LastName : "+profileName1.getText());
		
		
		
		quitBrowser();
	}

}

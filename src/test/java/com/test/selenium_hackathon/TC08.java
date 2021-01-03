package com.test.selenium_hackathon;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TC08 extends SalesforceUltility{

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		String URL = "https://login.salesforce.com/";
		String usernameVal = "karthika@betsy.com";
		String passwordVal = "*****";

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
		WebElement developerConsole = setXpath("//a[@title='Developer Console (New Window)']");		
		explicitWait(5000, developerConsole);
		developerConsole.click();

		//explicitWait(10, developerConsole);
		
		ArrayList<String> totalWindows = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("Total no of Tabs open : " + totalWindows.size());
		driver.switchTo().window(totalWindows.get(1));
		
		explicitWait(30, driver.findElement(By.xpath("//span[@id='editorMenuEntry-btnInnerEl']")));
		driver.close();
		
		driver.switchTo().window(totalWindows.get(0));
		
		//Thread.sleep(3000);
		quitBrowser();
	}

}

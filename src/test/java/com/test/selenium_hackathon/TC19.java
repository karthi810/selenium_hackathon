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

public class TC19 extends SalesforceUltility {

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
		WebElement opportunitiesTab = setXpath("//a[normalize-space()='Opportunities']");
		explicitWait(5000, opportunitiesTab);

		opportunitiesTab.click();
		Thread.sleep(3000);
		try {
			WebElement closeDialog = setXpath("//a[@id='tryLexDialogX']");
			explicitWait(9, closeDialog);
			closeDialog.click();
			System.out.println("Close Dialog found");
		} catch (Exception e) {
			System.out.println("Close Dialog not found");
		}

		WebElement intervalBox = setXpath("//select[@id='quarter_q']");
		Select selectInterval = new Select(intervalBox);
		selectInterval.selectByVisibleText("Current FQ");

		WebElement includelBox = setXpath("//select[@id='open']");
		Select selectInclude = new Select(includelBox);
		selectInclude.selectByVisibleText("All Opportunities");

		WebElement runButton = setXpath("//input[@title='Run Report']");
		runButton.click();
		explicitWait(5, driver.findElement(By.xpath("//select[@id='scope']")));

		// Check for another report

		WebElement opportunitiesTab1 = setXpath("//a[normalize-space()='Opportunities']");
		explicitWait(5000, opportunitiesTab1);

		opportunitiesTab1.click();
		Thread.sleep(3000);

		// check if dialog box exist
		try {
			WebElement closeDialog1 = setXpath("//a[@id='tryLexDialogX']");
			explicitWait(9, closeDialog1);

			if (closeDialog1.isDisplayed()) {
				System.out.println("close dialog exists");
				closeDialog1.click();

			}
		} catch (Exception e) {
			System.out.println("Close Dialog not found");
		}

		WebElement intervalBox1 = setXpath("//select[@id='quarter_q']");
		Select selectInterval1 = new Select(intervalBox1);
		selectInterval1.selectByVisibleText("Next FQ");

		WebElement includelBox1 = setXpath("//select[@id='open']");
		Select selectInclude1 = new Select(includelBox1);
		selectInclude1.selectByVisibleText("All Opportunities");

		WebElement runButton1 = setXpath("//input[@title='Run Report']");
		runButton1.click();
		explicitWait(5, driver.findElement(By.xpath("//select[@id='scope']")));

		// Thread.sleep(3000);

		quitBrowser();
	}

}

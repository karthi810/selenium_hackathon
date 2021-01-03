package com.test.selenium_hackathon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceUltility {

	public static WebDriver driver;

	public static void LaunchChromeBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	public static void LaunchFireFoxBrowser() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public static void gotoURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void loginDetails(WebElement elem, String val) {
		elem.clear();
		elem.sendKeys(val);
	}

	public static void login(WebElement elem) {
		elem.click();
	}

	public static void explicitWait(int sec, WebElement elem) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(elem));
	}

	public static WebElement setXpath(String xpath) {

		WebElement elemName = driver.findElement(By.xpath(xpath));
		return elemName;
	}

	public static List<WebElement> setXpath_forList(String xpath) {

		List<WebElement> elemName = driver.findElements(By.xpath(xpath));
		return elemName;
	}

	public static WebElement setId(String id) {

		WebElement elemName = driver.findElement(By.id(id));
		return elemName;
	}

	public static void quitBrowser() {
		driver.quit();
	}
}

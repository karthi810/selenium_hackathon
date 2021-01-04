package com.test.selenium_hackathon;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC06 extends SalesforceUltility{

	public static void main(String[] args) throws Exception{
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
		WebElement userLabel = setXpath("//span[@id='userNavLabel']");
		explicitWait(5000, userLabel);
		
		userLabel.click();
		WebElement myProfile = setXpath("//a[contains(text(),'My Profile')]");		
		explicitWait(5000, myProfile);
		myProfile.click();

		WebElement editProfileImg = setXpath("//a[@class='contactInfoLaunch editLink']");
		//explicitWait(15, editProfileImg);
		
		/*editProfileImg.click();
		
		driver.switchTo().frame(driver.findElement(By.id("contactInfoContentId")));
		
		WebElement aboutTab = setXpath("//a[normalize-space()='About']");
		
		aboutTab.click();
		explicitWait(3, driver.findElement(By.xpath("//input[@id='firstName']")));	
		
		WebElement lastName = setXpath("//input[@id='lastName']");
		lastName.clear();
		lastName.sendKeys("Kumaran");
		
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save All']"));
		saveButton.click();
		
		Thread.sleep(3000);
		
		driver.switchTo().defaultContent();*/
		
		//postMessage();
		
		//uploadFile();	
		
		addPhoto();
		
		quitBrowser();
	}
	
	public static void postMessage() throws Exception{
		
		WebElement postLink = setXpath("//a[@id='publisherAttachTextPost']");
		postLink.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']")));
		//explicitWait(5, driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, publisherRichTextEditor']")));
		
		WebElement textEditor = setXpath("//body[contains(text(),'Share an update, @mention someone...')]");
		textEditor.clear();
		textEditor.sendKeys(" < TEXT > ");
		
		driver.switchTo().defaultContent();
		
		WebElement shareButton = setXpath("//input[@id='publishersharebutton']");
		shareButton.click();
		explicitWait(5, driver.findElement(By.xpath("//div[@id='feedwrapper']")));
		
	}
	
	public static void uploadFile() throws Exception{
		
		WebElement fileLink = driver.findElement(By.xpath("//a[@id='publisherAttachContentPost']"));
		fileLink.click();
		
		WebElement uploadFromComputer = setXpath("//a[@id='chatterUploadFileAction']");
		explicitWait(15, uploadFromComputer);
		uploadFromComputer.click();
		
		WebElement chooseFile = setXpath("//input[@id='hiddenFileBtn']");
		//explicitWait(5, chooseFile);
		//chooseFile.click();
		
		chooseFile.sendKeys("C:\\Karthika\\TekArch\\SELENIUM HACKATHON\\Selenium_Logo.jpg");
		
		WebElement shareButton = setXpath("//input[@id='publishersharebutton']");
		shareButton.click();
		Thread.sleep(3000);
	}
	
	public static void addPhoto() throws Exception{
		
		WebElement moderatorBadge = setXpath("//span[@id='displayBadge']");
		Actions mouseHoverModerator = new Actions(driver);
		mouseHoverModerator.moveToElement(moderatorBadge).build().perform();
		
		WebElement addPhoto = setXpath("//a[@id='uploadLink']");
		addPhoto.click();
		
		driver.switchTo().frame(driver.findElement(By.id("uploadPhotoContentId")));
		
		WebElement chooseFile = setXpath("//input[@id='j_id0:uploadFileForm:uploadInputFile']");
		//explicitWait(5, chooseFile);
		//chooseFile.click();
		
		chooseFile.sendKeys("C:\\Karthika\\TekArch\\SELENIUM HACKATHON\\Selenium_Logo.jpg");
		WebElement saveButton = setXpath("//input[@id='j_id0:uploadFileForm:uploadBtn']");
		saveButton.click();
		 
		//Thread.sleep(3000);
		//explicitWait(7, saveButton);
		WebElement saveCropImage = setXpath("//input[@id='j_id0:j_id7:save']");
		
		saveCropImage.click();
		
		
		Thread.sleep(2000);
		
	}

}

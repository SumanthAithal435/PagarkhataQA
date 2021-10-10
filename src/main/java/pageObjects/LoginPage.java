package pageObjects;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;


public class LoginPage {
	Logger log = base.log;
	
	@FindBy (id= "language")
	private WebElement lanugauge;
	@FindBy(id="wzrk-cancel")
	private WebElement noThanks;
	@FindBy(xpath = "(//ul)[2]")
	private WebElement languageSelect;
	@FindBy(xpath = "//input[@type='number']")
	private WebElement phoneNumber;
	@FindBy (xpath = "//div[@class='MuiGrid-root mainContainer MuiGrid-container MuiGrid-spacing-xs-3']//button")
	private WebElement continueCTA;
	@FindBy (xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained verifyOtpButton MuiButton-containedPrimary']")
	private WebElement verifyOTPCTA;
	@FindBy (xpath = "//div[@class ='MuiGrid-root codeContainer MuiGrid-container MuiGrid-spacing-xs-3']")
	private WebElement otp;

	public LoginPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	private int langaugeSelect(String language) {
		int i=1;
		if (language.equalsIgnoreCase("English")) {
			i=1;
		} 
		else if (language.equalsIgnoreCase("Hindi")) {
			i=2;
		}
		else if (language.equalsIgnoreCase("Hinglish")) {
			i=3;
		}
		else if (language.equalsIgnoreCase("Gujarati")) {
			i=4;
		}
		else if (language.equalsIgnoreCase("Assamese")) {
			i=5;
		}
		else if (language.equalsIgnoreCase("Bengali")) {
			i=6;
		}
		else if (language.equalsIgnoreCase("Kannada")) {
			i=7;
		}
		else if (language.equalsIgnoreCase("Malayalam")) {
			i=8;
		}
		else if (language.equalsIgnoreCase("Marathi")) {
			i=9;
		}
		else if (language.equalsIgnoreCase("Odia")) {
			i=10;
		}
		else if (language.equalsIgnoreCase("Punjabi")) {
			i=11;
		}
		else if (language.equalsIgnoreCase("Tamil")) {
			i=12;
		}
		else if (language.equalsIgnoreCase("Telugu")) {
			i=13;
		}
		return i;
	}

	private void bypassOTP() {
		for(int i=1; i<=6;i++) {
			otp.findElement(By.id("otpVal"+i)).sendKeys(""+i);
		}
	}

	public void login(String lang, String number) throws InterruptedException {
		noThanks.click(); 
		log.info("Clicked on Nothanks CTA");
		lanugauge.click(); 
		log.info("Clicked on Language selection Drop down");
		int i=langaugeSelect(lang);
		Thread.sleep(3000);
		languageSelect.findElement(By.xpath("(//li["+i+"]//span)[4]")).click(); 
		log.info("Selected "+lang+" language");
		continueCTA.click(); 
		log.info("Clicked on Continue CTA");
		phoneNumber.sendKeys(number); 
		log.info("Entered "+number+" in Phone number text field");
		Thread.sleep(3000);
		continueCTA.click(); 
		log.info("Clicked on Continue CTA");
		bypassOTP();
		verifyOTPCTA.click(); 
		log.info("OTP Bypassed");
		if (noThanks.isDisplayed()) {
			noThanks.click(); 
			log.info("Clicked on Nothanks CTA");
		}
	}



}

package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;


public class BussinessAddition {
	Logger log = base.log; 
	
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained pg-pwa-button w-100 text-capitalize MuiButton-containedPrimary']")
	private WebElement newBusinessCTA;
	@FindBy(tagName = "input")
	private WebElement businessname;
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-grid-xs-12 MuiGrid-grid-sm-12']/button")
	private WebElement continueCTA;

	public  BussinessAddition(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void addNewBusiness(String businessName) throws InterruptedException {
		Thread.sleep(5000);
		newBusinessCTA.click();
		log.info("Clicked on Add New Business CTA");
		businessname.sendKeys(businessName);
		log.info("Entered "+businessName+" in Business Name text field");
		Thread.sleep(500);
		continueCTA.click();
		log.info("Clicked on Continue CTA");
		Thread.sleep(500);
		continueCTA.click();
		log.info("Clicked on Continue CTA");
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage 
{
	@FindBy (id= "language")
	private WebElement lanugauge;
	@FindBy(id="wzrk-cancel")
	private WebElement noThanks;
	@FindBy(xpath = "//span[text()='Hinglish']")
	private WebElement languageSelect;
	@FindBy (id ="language_change_button")
	private WebElement continueCTA;
	
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement NoThanksCTA() {
		 return noThanks;
	}
	public void clickNoThanks() {
		noThanks.click();
	}
	
	public void clickOnLanguage() {
		lanugauge.click();
	}
	
	public void selectLanguage() {
		languageSelect.click();
	}
	
	public void clickOnContinueCTA() {
		continueCTA.click();
	}
}

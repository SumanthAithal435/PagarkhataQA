package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class StaffAddition {
	Logger log = base.log; 

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input']")
	private WebElement staffName;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input'])[2]")
	private WebElement staffPhoneNumber;
	@FindBy (xpath = "//*[ @class='MuiButtonBase-root MuiButton-root MuiButton-contained add-staff-button MuiButton-containedPrimary']")
	private WebElement continueCTA;
	@FindBy (xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained businessContinue MuiButton-containedPrimary']")
	private WebElement continueCTA2;
	@FindBy (xpath = "//*[ @class='MuiFormGroup-root']//button")
	private WebElement continueCTA3;
	@FindBy (tagName = "input")
	private WebElement salary;
	@FindBy (xpath = "//div[@class='MuiFormGroup-root pwa-radio-group']")
	private WebElement staffType;
	public  StaffAddition(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	private int selectRadioButton(String staff) {
		int i=0;
		if (staff.equalsIgnoreCase("monthly")) {
			i= 1;
		}
		else if (staff.equalsIgnoreCase("hourly")) {
			i= 2;
		}
		else if (staff.equalsIgnoreCase("daily")) {
			i= 3;
		}
		else if (staff.equalsIgnoreCase("workbasis")) {
			i= 4;
		}
		else if (staff.equalsIgnoreCase("weekly")) {
			i= 5;
		}
		return i;
	}

	public void  addStaff(String type, String name,String number,String sal) {
		staffName.sendKeys(name);
		log.info("Entered "+name+" in Staff name textfield");

		staffPhoneNumber.sendKeys(number);
		log.info("Entered "+number+" in Staff Phone number text field");

		continueCTA.click();
		log.info("Clicked on Continue CTA in Add Staff page");

		int i=selectRadioButton(type);
		staffType.findElement(By.xpath("(//input)["+i+"]")).click();
		log.info("Selected "+type+ " Staff type");

		continueCTA2.click();
		log.info("Clicked on Continue CTA in Select type of Salary Payment page");	

		if(i!=4) {
			salary.sendKeys(sal);
			log.info("Entered "+sal+" in Salary text field");
		}

		continueCTA.click();
		log.info("Clicked on Continue CTA in Add Staff’s Salary page"); 

		continueCTA3.click();
		log.info("Clicked on Continue CTA in Opening balance page");
	}

}

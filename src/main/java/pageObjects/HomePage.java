package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.base;

public class HomePage {
	Logger log = base.log; 
	
	@FindBy (xpath = "//div[@class='MuiGrid-root staff-home-grid home-grid-padding-custom home-grid-padding-custom-mobile MuiGrid-container MuiGrid-grid-xs-12 MuiGrid-grid-sm-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-12 MuiGrid-grid-xl-12']//button[1]")
	private WebElement addStaff;
	@FindBy (xpath = "//div[@class='MuiPaper-root MuiCard-root newSms-leftBar MuiPaper-elevation1 MuiPaper-rounded']")
	private WebElement leftNavigationbar;
	@FindBy (xpath = "//div[@class='MuiToolbar-root MuiToolbar-regular jss6 MuiToolbar-gutters']")
	private WebElement topNavigationBar;
	@FindBy (xpath = "//h2[@id='transition-modal-title']/following-sibling::button[2]")
	private WebElement confirmLogoutCTA;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickAddStaffCTA() throws InterruptedException {
		Thread.sleep(7500);
		addStaff.click();
		log.info("Clicked on Add Staff CTA" );
	}
	
	private int ctaSelect(String ctaToBeClicked) {
		 int i=0;
		if (ctaToBeClicked.contains("Staff")) {
			i= 1;
		}
		else if (ctaToBeClicked.contains("Attendance")) {
			i= 2;
		}
		else if (ctaToBeClicked.contains("Bulk")) {
			i= 3;
		}
		else if (ctaToBeClicked.contains("Hire")) {
			i= 4;
		}
		else if (ctaToBeClicked.contains("Account")) {
			i= 5;
		}
		else if (ctaToBeClicked.contains("Manager")) {
			i= 6;
		}
		else if (ctaToBeClicked.contains("Subscription")) {
			i= 7;
		}
		else if (ctaToBeClicked.contains("Switch")) {
			i= 8;
		}
		else if (ctaToBeClicked.contains("Payment")) {
			i= 9;
		}
		else {
			System.out.println("Invalid Selection");
		}
		return i;
	}
	
	public void selectFromLeftNavigationBar(String ctaToBeClicked) throws InterruptedException {
		int i= ctaSelect(ctaToBeClicked);
		Thread.sleep(2500);
		leftNavigationbar.findElement(By.xpath("//button["+i+"]")).click();
		log.info("Clicked on "+ctaToBeClicked+" in Left Navigation bar" );
	}
	
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		topNavigationBar.findElement(By.xpath("//button[2]")).click();
		confirmLogoutCTA.click();
		log.info("Logged out successfully" );
	}
}

package TestCase;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.BussinessAddition;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.StaffAddition;
import resources.base;

public class AppTest extends base{
	public WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	StaffAddition staffAddition ;
	BussinessAddition businessAddition;
	@BeforeTest
	@Parameters("browser")
	public void initialize(String browser) throws IOException
	{
		driver =initializeDriver(browser); log.info("Driver is initialized");	
		driver.get(prop.getProperty("url")); log.info("Navigated to Landing page");
		homePage= new HomePage(driver);
		loginPage = new LoginPage(driver);
		staffAddition = new StaffAddition(driver);
		businessAddition = new BussinessAddition(driver);	
	}

	@Test
	@Parameters("langauge")
	public void login(String langauge) throws InterruptedException {
		loginPage.login(langauge, prop.getProperty("Phonenumber"));
	}

	@Test (dependsOnMethods = {"login"})
	public void addingBusiness() throws InterruptedException {
		homePage.selectFromLeftNavigationBar("SwitchOrAddNewBusiness");		
		businessAddition.addNewBusiness("Santosh PVT LTD");
	}

	@Test (dependsOnMethods = {"addingBusiness"})
	public void addingMonthlyStaff() throws InterruptedException {
		homePage.clickAddStaffCTA();
		staffAddition.addStaff("Monthly", "dinga", "9100000000", "15000");
	}
	@Test (dependsOnMethods = {"addingBusiness"})
	public void addingHourlyStaff() throws InterruptedException {
		homePage.clickAddStaffCTA();
		staffAddition.addStaff("hourly", "dingi", "9100000002", "20000");
	}
	@Test (dependsOnMethods = {"addingBusiness"})
	public void addingDailyStaff() throws InterruptedException {
		homePage.clickAddStaffCTA();
		staffAddition.addStaff("daily", "siddu", "1100000002", "1000");
	}
	@Test (dependsOnMethods = {"addingBusiness"})
	public void addingWorkBasisStaff() throws InterruptedException {
		homePage.clickAddStaffCTA();
		staffAddition.addStaff("workbasis", "suman", "9100000003", "0");
	}
	@Test (dependsOnMethods = {"addingBusiness"})
	public void addingWeeklyStaff() throws InterruptedException {
		homePage.clickAddStaffCTA();
		staffAddition.addStaff("weekly", "siddi", "5100000002", "1000");
	}

	@AfterTest
	public void teardown()
	{
		driver.close();
	}




}

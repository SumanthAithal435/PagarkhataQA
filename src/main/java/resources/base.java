package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	public  WebDriver driver;
	public static Properties prop;
	static
	{
		prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public WebDriver initializeDriver(String browser) throws IOException
	{
		
		if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", prop.getProperty("DriverPath"));
			driver= new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("DriverPath"));
			driver = new ChromeDriver();	
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("DriverPath"));
			driver = new FirefoxDriver();		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}


	public String getScreenShotPath(String testCaseName,WebDriver driver, Properties prop) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile =prop.getProperty("ScreenShotPath")+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}

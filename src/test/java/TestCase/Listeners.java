package TestCase;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listeners extends base implements ITestListener {
	ExtentTest test;
	 ExtentReports extent=ExtentReporterNG.getReportObject(prop);
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 test= extent.createTest(result.getMethod().getMethodName());	
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName()+ " testcase successfully executed ");
	}

	public void onTestFailure(ITestResult result) {
	
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getThrowable());
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		try {
			
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			String imgPath= getScreenShotPath(testMethodName, driver,prop);
			test.addScreenCaptureFromPath(imgPath);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}

package resources;

import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	static ExtentReports extent;
	
	public static ExtentReports getReportObject(Properties prop)
	{
	
		String path =prop.getProperty("ReportPath");
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sumanth Aithal");
		return extent;
		
	}
}

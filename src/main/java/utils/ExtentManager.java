package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getExtent() {
		
		if(extent == null) {
			ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
			spark.config().setReportName("Automation Test Results");
			spark.config().setDocumentTitle("DemoBlaze - Cucumber report");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}
	
}

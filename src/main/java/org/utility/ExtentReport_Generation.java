package org.utility;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport_Generation {
	public static ExtentReports report;
	public static void startReport() {
		ExtentHtmlReporter html = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Reports\\ExtentReport\\extent_report.html");
		html.config().setDocumentTitle("Cucumber Extent Report");
		html.config().setReportName("Facebook");
		html.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("BrowserName", "Chrome");
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Environment", "QA");
		report.setSystemInfo("Sprint", "23");
	}
	public static void createLog(ITestResult sc) {
		String name = sc.getName();
		int status = sc.getStatus();
		switch (status) {
		case 1:
			report.createTest(name).pass("Test Case Passed");
			break;

		case 2:
			report.createTest(name).fail("Test Case Failed");
			break;
		default:
			report.createTest(name).skip("Test Case Skipped");

			break;
		}
	}
	public static void endReport() {
		report.flush();
	}

}

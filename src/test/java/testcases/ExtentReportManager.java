package testcases;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	public  ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
		
		public void  onTestStart(ITestResult result) {
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Extentreports/TestReport.html");
		sparkReporter.config().setDocumentTitle("automation testing");
		sparkReporter.config().setReportName("registartion test");
		sparkReporter.config().setTheme(Theme.DARK);
		
		//configuration deatils
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("tester","deeraj");
		extent.setSystemInfo("os","windows");
		extent.setSystemInfo("browser", "chrome");
		extent.setSystemInfo("environment","qa");
	
		}
			public void onTestSuccess(ITestResult result) {
				test=extent.createTest(result.getName());
				test.log(Status.PASS, "Test is passed"+result.getName());
			}
			
			public void onTestFailure(ITestResult result) {
				test=extent.createTest(result.getName());
				test.log(Status.FAIL, "Test is failed"+result.getName());
				test.log(Status.FAIL, result.getThrowable());//get the failure exception
				try {
					String imgpath = new Baseclass().captureScreenshot();
					test.addScreenCaptureFromPath(imgpath);
				} catch (IOException e) {
					e.printStackTrace();
				}
			
						}

				public void onTestSkipped(ITestResult result) {
					test=extent.createTest(result.getName());
					test.log(Status.SKIP, "Test is skipped"+result.getName());
					try {
						String imgpath = new Baseclass().captureScreenshot();
						test.addScreenCaptureFromPath(imgpath);
					} catch (IOException e) {
						e.printStackTrace();
					}
			
			}
				public void onFinish(ITestContext context) {
					extent.flush();
				}
	}
				




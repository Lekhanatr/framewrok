package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListener interface of testNG
 * @author swaroop
 */
public class ListenersImplementationUtility implements ITestListener{
	ExtentReports report ;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - Test Execution started");
		
		//create test for extent reports
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - Test is PASS");
		
		//log the status of test to extent reports
		test.log(Status.PASS, methodName+" - Test is PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" - Test is FAIL");
		
		//log the status of test to extent reports
		test.log(Status.FAIL, methodName+" - Test is FAIL");
				
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());
		//capture the screenshot 
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		
		//configure screenshot name
		String screenShotName = methodName+j.getSystemDate();
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenShotName);
			
			//attach screenshot to extent report
			test.addScreenCaptureFromPath(path, methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName + " - Test is SKIPPED");
		
		//log the status of test to extent reports
		test.log(Status.SKIP, methodName+" - Test is SKIPPED");
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the exception in extent reports
		test.log(Status.WARNING, result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("suite execution started");
		
		//Basic configuration of Extent Report
		ExtentSparkReporter esr =  new ExtentSparkReporter(".\\ExtentReports\\Report"+new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Automation Execution Report");
		esr.config().setReportName("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		//configure Extent Reports
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Base URL", "Test URL");
		report.setSystemInfo("Reporter Name", "Lekhana");
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("suite executed finished");
		report.flush();
	}
	

}

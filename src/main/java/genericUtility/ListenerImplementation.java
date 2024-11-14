package genericUtility;

import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provide implementation for ITestListener of TestNG
 * @author CharithaM
 */
public class ListenerImplementation implements ITestListener{
	//Capture current system date to use on screenshot name and Report name
	Date d = new java.util.Date();
	SimpleDateFormat sd=new SimpleDateFormat("mm-dd-yyyy hh-mm-ss");
	String date=sd.format(d);
	/* For Extent report*/
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Test Script Execution started");
		/*Intimate @Test execution for extent Reports*/
		test=report.createTest(methodName);
		test.log(Status.INFO,methodName+"-> Test script Execution started");
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Test script is pass");
		
		 /* Log PASS status in Extent Report*/
		test.log(Status.PASS, methodName+"-> Test script is PASS");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		/*Test-Test Method has Failed*/
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Test execution is Fail");
		/*Capture the exception*/
		System.out.println(result.getThrowable());
		/* Log Skip status to Extent Reports*/
		test.log(Status.FAIL, methodName+"-> Test script FAIL");
		/* Log Skip status to Extent Reports*/
		test.log(Status.WARNING, result.getThrowable());
		/*Capture the ScreenShot*/
		SeleniumUtility s=new SeleniumUtility();
		
		String screenshotName=methodName+date;
		try {
			String path=s.captureScreenShot(BaseClass.sdriver,screenshotName);
			/* Attach the captured screenshot to extent REports*/
			test.addScreenCaptureFromBase64String(path);

		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
			}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		/*Test-test Method has Skipped*/
		String methodName=result.getMethod().getMethodName();
		System.out.println(methodName+"Test Execution is skip");
		/*Capture the exeception*/
		System.out.println(result.getThrowable());
		/*
		 * Log Skip status to Extent Reports*/
		test.log(Status.SKIP, methodName+"-> Test script skip");
		/* Log the Exception to Extent Reports*/
		test.log(Status.WARNING,result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite Execution is statred");
		/* Extent report configuration*/
		ExtentSparkReporter esr=new ExtentSparkReporter(".\\ExtentReporter\\Report-"+date+".html");
		esr.config().setTheme(Theme.DARK);
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setReportName("Swag Labs Report-Build version 1.21");
		/*Attach the configuration to extent Reports*/
	    report=new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Environment", "Test Environment");
		report.setSystemInfo("Base Browser", "Microsoft edge");
		report.setSystemInfo("Base Platform", "Windows Family");
		report.setSystemInfo("ReporterName", "Chaitra");
	}
	

	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("suite Execution is Finished");
		/*Generate Extent Report after suite execution is complete*/
		report.flush();
	}
	
}

package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersClass implements ITestListener
{
	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	 ExtentTest t;
	public void onStart(ITestContext context)
	{
		reporter = new ExtentSparkReporter("./src/test/resources/ExtentReports/Extentreport.html");
		reporter.config().setDocumentTitle("OrangeHrmTestSuite");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("TestAutomationSuite");
		
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("OS", "Win,Linux");
		reports.setSystemInfo("Browsers", "Chrome,Firefox,Operamini");
		System.out.println("All the testcase Execution");
		
	}
	public void onTestStart(ITestContext context)
	{
	System.out.println("All the test case execution START" );	
	}
	
	public void onFinish(ITestContext context)
	{
		reports.flush();
	System.out.println("On the Test case execution finished");	
	}
	
	public void onTestStart(ITestResult result)
	{
		  t = reports.createTest(result.getName());
		t.log(Status.INFO, result.getName()+" This test execution is started");
	System.out.println("All the individual Test case execution Started");	
	}
	public void onTestSuccess(ITestResult result)
	{
		
		 t = reports.createTest(result.getName());
		t.log(Status.PASS, result.getName()+" This test execution is success");
	System.out.println("All the individual Test case execution Passed "+ result.getName());	
	}
	public void onTestFailure(ITestResult result)
	{
		 t = reports.createTest(result.getName());
		t.log(Status.FAIL, result.getName()+" This test execution is FAIL");

	System.out.println("All the individual Test case execution Failed "+ result.getName());	
	try {
		GetDefect.CaptureDefect(result.getName());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void onTestSkipped(ITestResult result)
	{
		 t = reports.createTest(result.getName());
		t.log(Status.SKIP, result.getName()+" This test execution is sKIPPED");
	System.out.println("All the individual Test case execution Skipped " +result.getName());	
	}
	
	
}

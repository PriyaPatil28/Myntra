package com.qa.utilities;

import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.testscripts.TestBase;

public class Reporting extends TestBase implements ITestListener {
	
	private static String getTestMethodName(ITestResult res) {
		
		return res.getMethod().getConstructorOrMethod().getName();
		
	}


	@Override
	public void onStart(ITestContext tcon) {
		System.out.println("Iam in OnStart Method "+ tcon.getName());
		tcon.setAttribute("WebDriver", this.driver);
			}

	@Override
	public void onFinish(ITestContext tcon) {
		System.out.println("Iam in OnFinish method" + tcon.getName());
		ExtentManager.extentrep.flush();
	}
	
	@Override
	public void onTestStart(ITestResult tr) {
		System.out.println("OnTestStart Method is Started "+ getTestMethodName(tr));

	}
	
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println(getTestMethodName(tr)+" test is succeed");
		
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
		ExtentTestManager.getTest().log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));

	}

	@Override
	public void onTestFailure(ITestResult tr) {
		System.out.println("Test is failed "+getTestMethodName(tr));
		Object testclass= tr.getInstance();
		WebDriver wd = ((TestBase)testclass).getDriver();
		
		String base64Screenshot ="data:image/png;base64,"+((TakesScreenshot)Objects.requireNonNull(wd)).getScreenshotAs(OutputType.BASE64);
		
		ExtentTestManager.getTest().log(Status.FAIL," Test Failed ", 
				ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
		ExtentTestManager.getTest().log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Iam in OnTestSkipped method "+getTestMethodName(tr));

	ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	ExtentTestManager.getTest().log(Status.SKIP,MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
	}

}

package com.mywebsite.Lesner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class myLeasner implements ITestListener
{
	ExtentReports report;
	@Override
	public void onStart(ITestContext context) {
		
	// ExtentReporter report = ExtentReporter.gen
		System.err.println("Execution of Project are started ");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testaName=result.getName();
		System.err.println(testaName+"Test are started ");
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String testName=result.getName();
		System.err.println(testName+"Test is sucessfull ");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{ 
		String testNmae=result.getName();
		System.err.println(testNmae+"Test is fale");
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String testNmae=result.getName();
		System.err.println(testNmae+"Test is Skiped");
		System.err.println(result.getThrowable());
	}

	

	@Override
	public void onFinish(ITestContext context) 
	{
	  System.err.println("Test is finished...! ");
	  report.flush();
	}
	

}

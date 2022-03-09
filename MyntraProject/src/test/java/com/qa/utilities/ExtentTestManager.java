package com.qa.utilities;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
	
	    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
	    static ExtentReports extent = ExtentManager.CreateExtentReports();
	 
	    public static synchronized ExtentTest getTest() {
	        return extentTestMap.get((int)Thread.currentThread().getId());
	    }

//	    public static synchronized void endTest() {
//	        extent.endTest((ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId())));
//	        extent.flush();
//	    }
//	 
	    public static synchronized ExtentTest startTest(String testName, String desc) {
	        ExtentTest test = extent.createTest(testName, desc);
	        extentTestMap.put((int) Thread.currentThread().getId(),test);
	        return test;
	    }
	}



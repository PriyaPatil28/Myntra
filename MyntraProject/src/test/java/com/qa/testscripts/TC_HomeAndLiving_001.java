package com.qa.testscripts;

import java.lang.reflect.Method;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.pageObject.Myntra_001_Page;
import com.qa.utilities.ExtentTestManager;

public class TC_HomeAndLiving_001 extends TestBase{
	Myntra_001_Page myn;
	 
	     @Test
	     public void Myntra_001(Method method) throws Exception {
            WebDriverWait w = new WebDriverWait(driver, 30);
	    	 exTest = ExtentTestManager.startTest(method.getName(), "Myntra_001");
	    	 myn=PageFactory.initElements(driver, Myntra_001_Page.class) ;
	    	 Actions a = new Actions(driver);
	    	 a.moveToElement(myn.HomeAndLiving).pause(12000).perform();
	         a.moveToElement(myn.Tablelamp).click().perform();
	         ((JavascriptExecutor)driver).executeScript("arguments[0].click();", myn.DiscountRange);
	         Thread.sleep(10000);
	         a.moveToElement(myn.Color).pause(5000).click().perform();
	         
	         a.moveToElement(myn.Brand).pause(5000).click().perform();
	         
	         a.moveToElement(myn.PriceRange).pause(5000).click().perform();
	        
	         Thread.sleep(6000);
	         captureScreenshot(driver, method.getName());
             
             
 
	     }
}

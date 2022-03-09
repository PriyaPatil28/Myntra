package com.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myntra_001_Page {
	WebDriver driver;
	public Myntra_001_Page(WebDriver driver) {
		this.driver = driver;
	}
    
	@FindBy(xpath = "(//a[text()='Home & Living'])[1]")
	public WebElement HomeAndLiving;
	
	@FindBy(xpath = "//a[text()='Table Lamps']")
	public WebElement Tablelamp;
	
	@FindBy(xpath = "//input[@value='70.0 TO 100.0']")
	public WebElement DiscountRange;
	
	@FindBy(xpath = "(//div[@class='common-checkboxIndicator'])[14]")
	public WebElement Color;
	
	@FindBy(xpath = "(//div[@class='common-checkboxIndicator'])[2]")
	public WebElement Brand;
	
	@FindBy(xpath = "(//div[@class='common-checkboxIndicator'])[3]")
	public WebElement PriceRange;
}

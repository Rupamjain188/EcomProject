package com.mywebsite.POM_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class surchVelidation 
{	WebDriver driver;


	@FindBy(xpath = "//a[normalize-space()='HP LP3065']")
	private WebElement verifytheContect;


	@FindBy(xpath = "//h2[normalize-space()='Products meeting the search criteria']")
	private WebElement noProductmess;

    
	public surchVelidation(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displyStatusveryfy() 
	{
	
	 boolean displysts=verifytheContect.isDisplayed();
	 return displysts;
	}
	
	public String noproductMess()
	{
		String noProductAlert=noProductmess.getText();
		return noProductAlert;
	}
}

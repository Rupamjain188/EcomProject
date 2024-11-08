package com.mywebsite.POM_pages;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage 
{ WebDriver driver;
	@FindBy(xpath ="//span[normalize-space()='My Account']")
	private WebElement MyaccountButton;
   
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	private WebElement selectResister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	 private WebElement SelectLogin;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement surch1;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement surchBut;
	

	
	
	
	public homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Surchbar(String product)
	{
		surch1.sendKeys(product);
	}
	
	
	
	public void surchButton()
	{
	   surchBut.click();
	}
	
	public void clickActionMYAcc()
	{
		MyaccountButton.click();
	}
	
	public void selectResister()
	{
		selectResister.click();
	}
	
	public homePage SelectLogin()
	{
		SelectLogin.click();
		return new homePage(driver);
	}
}

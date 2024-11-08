package com.mywebsite.POM_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v126.runtime.Runtime.GetPropertiesResponse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitie.utilities;

public class resisterFrom 
{
	WebDriver driver;
	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement LastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement Email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement PhoneNo;
	
	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement Password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement ConfermPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement  PrivacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement summitButton;
	
	public  resisterFrom(WebDriver driver)   // constructior same bane as class name no return argument
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FirstNameEnter(String name)
	{
		firstName.sendKeys(name);
	}
     
	public void LastNameEnter(String last)
	{
		LastName.sendKeys(last);
	}
	
	public void EnterEmail(String email)
	{
		Email.sendKeys(email);
	}
	
	
	public void EnterPhone(String phone)
	{
		PhoneNo.sendKeys(phone);
	}
	
	public void enterpass(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void confpass(String pass)
	{
		ConfermPassword.sendKeys(pass);
		
	}
	public void  Privacy_Policy()
	{
		 PrivacyPolicy.click();
		
	}
	public void  Submit()
	{
		 summitButton.click();
		
	}
}

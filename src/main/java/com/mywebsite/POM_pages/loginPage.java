package com.mywebsite.POM_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class loginPage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailEnter;
	
	@FindBy(xpath = "/*[@id=\"input-password\"]")
	WebElement passwordEnter;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
	WebElement loginButton;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void EnterEmail()
	{
		emailEnter.sendKeys();
	}
	
	public void EnterPass()
	{
		passwordEnter.sendKeys();
	}

	public void SelectLogin()
	{
		loginButton.click();
	}
}

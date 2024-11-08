package com.mywebsite.POM_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSucess 
{
	 WebDriver driver;
 @FindBy(xpath = "//*[@id=\\\"account-register\\\"]/div[1]")
 WebElement accouctSucessful;
 
 
 public AccountSucess(WebDriver driver)
 {
	 this.driver=driver;
	 PageFactory.initElements(driver, this);
 }
 
 public String accsucessful()
 {
	 String AccsucessfulisActual=accouctSucessful.getText();
	return AccsucessfulisActual;
 }
}

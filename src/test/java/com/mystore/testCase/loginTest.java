package com.mystore.testCase;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.basePackge.base;
import com.mywebsite.POM_pages.homePage;
import com.mywebsite.POM_pages.loginPage;

import utilitie.utilities;



public class loginTest extends base
{loginPage log;

	WebDriver driver;
	public loginTest()
	{
		super();
	}
	
	@AfterMethod
	public void tearDown()
	
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void Setup()
	{
		
		driver=setUp_MultiBrows(pro.getProperty("browserName"));
		homePage home=new homePage(driver);
		home.clickActionMYAcc();  
		homePage loginpage=home.SelectLogin();
	
		
	}
	
	
	
	@Test(priority = 1, dataProvider ="validtata11" )
  public void verifyeLoginPage(String email,String password)
  {
		//loginPage log=new loginPage(driver);
		log.EnterEmail();
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		log.EnterPass();
		//driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(password);
		log.SelectLogin();
		//driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		
		//Thread.sleep(2000);      
		//Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"content\"]/ul[1]/li[1]/a")))
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Accouct informaction link is display");
		 driver.quit();
  }
	@DataProvider(name="validtata11")
	public Object[][] SupplyInpute()
	{
		Object[][] data=utilities.GetTtestDataFromExel("Login");
		return data;
	}
	
	
	
	
	
	
	
	@Test (priority = 2)
	public void invalid_login() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(utilities.RandomInput());
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(datapro.getProperty("invalidPass"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
		
		String worning=driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
        String expected ="Warning: No match for E-Mail Address and/or Password.";
	//   Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).isDisplayed(),"alert is showing corret infomaction");
	  Assert.assertTrue(worning.contains(expected),"Yes is true test is pass");
        driver.quit();
	}
	
	
	
	@Test(priority = 3)
	public void validIdAndInvalidpass() throws InterruptedException
	{
		
	
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("ccomputer170@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys(datapro.getProperty("invalidPass"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
		
		String worning=driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
        String expected ="Warning: No match for E-Mail Address and/or Password.";
	//   Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).isDisplayed(),"alert is showing corret infomaction");
	  Assert.assertTrue(worning.contains(expected),"Yes is true test is pass");
        
	}
	
	
	
	@Test(priority = 4)
	public void validateinsertNullDeta() throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("CComputer170@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("123123");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(2000);
		
		String worning=driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).getText();
        String expected ="Warning: No match for E-Mail Address and/or Password.";
	   Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-danger.alert-dismissible")).isDisplayed(),"alert is showing corret infomaction");
	  Assert.assertTrue(worning.contains(expected),"Yes is true test is pass");
        
	}
	
	
	
	
	
}

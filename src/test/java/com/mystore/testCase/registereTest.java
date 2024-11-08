package com.mystore.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.basePackge.base;
import com.mywebsite.POM_pages.AccountSucess;
import com.mywebsite.POM_pages.homePage;
import com.mywebsite.POM_pages.resisterFrom;

import utilitie.utilities;

public class registereTest extends base
{
	public  registereTest()
	{
		super();
	}
	WebDriver driver;
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	@BeforeMethod
	public void setUp()
	{
		driver=setUp_MultiBrows(pro.getProperty("browserName"));
		
	homePage home =new homePage(driver);
	home.clickActionMYAcc();
	//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
	home.selectResister();
	//driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
	}
	
	
	@Test(priority = 1)
	public void resisterAc() throws InterruptedException {
		resisterFrom regform=new resisterFrom(driver);
		regform.FirstNameEnter(datapro.getProperty("firstNmae"));
		regform.LastNameEnter(datapro.getProperty("lastName"));
		regform.EnterEmail(utilities.RandomInput());
		regform.EnterPhone(datapro.getProperty("phoneNo"));
		regform.enterpass(datapro.getProperty("validpass"));
		regform.confpass(datapro.getProperty("validpass"));
		regform.Privacy_Policy();
		regform.Submit();
		
		
     

	//driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("1234567891");
	Thread.sleep(2000);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)");
	
//	driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("Rahul@1234");
//	driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("Rahul@1234");
//	driver.findElement(By.xpath("//input[@value='0']")).click();
//	driver.findElement(By.xpath("//input[@name='agree']")).click();
//	driver.findElement(By.xpath("//input[@value='Continue']")).click();
	
	AccountSucess ac=new AccountSucess(driver);
	String Accsucessfuldone=ac.accsucessful();
    
	Assert.assertTrue(Accsucessfuldone.contains("Warning: E-Mail Address is already registered!"));
	Thread.sleep(2000);

	}
	
	@Test(priority =2 )
	public void EmteyFromfellIn_resister() throws InterruptedException
	{
	
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")).click();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,400)");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	
	
	String LastName=driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
		Assert.assertEquals(LastName,"First Name must be between 1 and 32 characters!","LastName Is not dosply The Error");
	
	String Email=driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText();
	Assert.assertEquals(Email,"E-Mail Address does not appear to be valid!","Email Is not dosply The Error");
	

	String contact=driver.findElement(By.xpath("//*[@id=\"account\"]/div[5]/div/div")).getText();
	Assert.assertEquals(contact,"Telephone must be between 3 and 32 characters!","Contact Is not dosply The Error");
	
	String Password=driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div")).getText();
	Assert.assertEquals(Password,"Password must be between 4 and 20 characters!","Password Is not dosply The Error");
	
	
	driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
	

	
	}
	
}
	

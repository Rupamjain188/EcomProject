package com.mystore.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.basePackge.base;
import com.mywebsite.POM_pages.homePage;
import com.mywebsite.POM_pages.surchVelidation;

public class surchTest extends base
{
	
	public surchTest()
	{
		super();
	}
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=setUp_MultiBrows(pro.getProperty("browserName"));
	}
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test(priority = 1)
	public void surch() throws InterruptedException
	{
	 
		homePage pgs=new homePage(driver);		
		pgs.Surchbar(datapro.getProperty("ValidProduct"));
		pgs.surchButton();
		
		Thread.sleep(2000);
        surchVelidation sc=new surchVelidation(driver);
        
        
		
		Assert.assertTrue(sc.displyStatusveryfy(),"Products meeting the search criteria");
		
	}
	
	@Test(priority = 2)
	public void non_valid_inpute_surch() throws InterruptedException
	{
		
		homePage pgs=new homePage(driver);		
	    pgs.Surchbar(datapro.getProperty("invaliProduct"));
	    pgs.surchButton();
	    
	
		
		Thread.sleep(2000);
		String actul="Products meeting the search criteria";
		
		surchVelidation verifyAlert=new surchVelidation(driver);
        String veyproductveif=verifyAlert.noproductMess();
		Assert.assertEquals(veyproductveif, datapro.getProperty("productNotValid"));
			
	}
	
	@Test(priority = 3)
	public void without_any_surch() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
		Thread.sleep(2000);
		String actul="Products meeting the search criteria";
		
		Assert.assertTrue(actul.contains("Products meeting the search criteria"));
			
	}

}

package com.mystore.basePackge;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
      WebDriver driver;
     public Properties pro;        // for url,browser Remove Hardcore
     public Properties datapro;    // password, email ect.(Remove Hardcore)
     
  //This this copy from GitHub   
     
      public base() // constructor
      {
    	   pro=new Properties();
    	  File fl=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mywebsite\\properties\\configure.propertiesFile");
    	  
    	 try {
			 FileInputStream file=new FileInputStream(fl);
    	         pro.load(file);
		} 
    	  
    	 catch (Throwable e)       // why choose throable becouse is root of interface.
    	  
    	    {
			e.printStackTrace();
			// TODO: handle exception
		}
    	  
    	  
    	  // for test Data :-
    	  datapro =new Properties();
    	  File dataprofile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mywebsite\\testdata\\testdata.properties");
    	 
    	  try {
			 FileInputStream fl2=new FileInputStream(dataprofile);
    	  datapro.load(fl2);
		} catch (Throwable e) {
			// TODO: handle exception\
			e.fillInStackTrace();
		} 
    	     	 
      }
      
      
	public WebDriver setUp_MultiBrows(String broswerN)
	{
		
		if (broswerN.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
		}
		else if (broswerN.equalsIgnoreCase("ferfox")) 
		{
		   driver=new FirefoxDriver();	
		}
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
		
		return driver;
	}
}

package utilitie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.naming.ldap.ExtendedRequest;

import org.openqa.selenium.devtools.v126.runtime.Runtime.GetPropertiesResponse;
import org.testng.internal.thread.ThreadExecutionException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtedReporter 
{     ExtentReports  report;
	public void genrateExtendReport() throws FileNotFoundException 
	{
		
	
		 report=new ExtentReports();
		File extendFile=new File(System.getProperty("user.dir")+"\\E-webApplication\\test-output\\extendReport\\extentReport.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(extendFile);
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("MyWebSiteReport");
		spark.config().setDocumentTitle("MYWebReport");
		spark.config().setTimeStampFormat("DD/MM/YYYY hh:mm:ss ");
		
		report.attachReporter(spark);
		Properties confipro=new Properties();
        File configfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mywebsite\\properties\\configure.propertiesFile");
		FileInputStream fis=new FileInputStream(configfile);
		
		try { 
			
		} catch (Throwable e)
		{
           e.printStackTrace();
		}
		
	    report.setSystemInfo("Application URL", confipro.getProperty("url"));
	    report.setSystemInfo("BroserName", confipro.getProperty("broswer"));
	    report.setSystemInfo("Email", confipro.getProperty("email"));
	    report.setSystemInfo("Email", confipro.getProperty("validpassword"));
	    
		
	}
	
	

}

package demoTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import resource.DriverFactory;
import resource.ReportFactory;

public class Guru99
{

	WebDriver driver;
	ExtentReports rpt;
	ExtentTest test;

	@BeforeClass
	public  void ReportInit()
	{
		rpt=ReportFactory.CreateReport("Guru99");
		test=rpt.startTest("GURU99");
	}

	@Test(priority = 1)
	public void LaunchYahoo()
	{
		driver = DriverFactory.LoadDriver();
		
		test.log(LogStatus.INFO, "Selected FireFox Browser");

		driver.get("https://www.yahoo.com/");
		
		test.log(LogStatus.INFO, "Url hit: "+driver.getCurrentUrl());		
	}
	
	@AfterSuite
	public void EndReport()
	{
		ReportFactory.CloseReport(rpt,test);
		driver.close();
	}
}

package demoTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import resource.DriverFactory;
import resource.ReportFactory;

public class Wikipedia
{

	WebDriver driver;
	ExtentReports rpt;
	ExtentTest test;

	@BeforeClass
	public  void ReportInit()
	{
		rpt=ReportFactory.CreateReport("WIKI");
		test=rpt.startTest("WIKI");
	}

	@Test(priority = 1)
	public void LaunchYahoo()
	{
		driver = DriverFactory.LoadDriver();

		test.log(LogStatus.INFO, "Selected FireFox Browser");

		driver.get("https://www.wikipedia.org/");

		test.log(LogStatus.INFO, "Url hit: "+driver.getCurrentUrl());		
	}

	@AfterSuite
	public void EndReport()
	{
		ReportFactory.CloseReport(rpt,test);
		driver.close();

	}
}

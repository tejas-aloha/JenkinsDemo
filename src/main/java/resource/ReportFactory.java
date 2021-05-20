package resource;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportFactory
{
	static ExtentReports report;
	static ExtentTest test;

	
	synchronized public static ExtentReports CreateReport(String name)
	{	
		String reportpath=(System.getProperty("user.dir")+"//Extent_Reports//"+name+".html");
		System.out.println(reportpath);

		report= new ExtentReports(reportpath);

		return report;
	}

	synchronized public static void CloseReport(ExtentReports rpt,ExtentTest test)
	{
		rpt.flush();
		rpt.endTest(test);
		rpt.close();
	}

}

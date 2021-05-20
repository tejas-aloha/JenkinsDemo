package resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


	static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

	static String browser= System.getProperty("Browser");
	//static String browser= "Firefox";


	public static WebDriver LoadDriver()
	{
		switch (browser.toLowerCase()) {
		case "chrome":
			System.out.println("Selected Browser is:-"+browser);
			System.setProperty("webdriver.chrome.driver","F:\\Interview Preparation\\Setup\\Drivers\\chromedriver.exe");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.out.println("Selected Browser is:-"+browser);
			System.setProperty("webdriver.gecko.driver","F:\\Interview Preparation\\Setup\\Drivers\\geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Driver Not Found!");
			break;
		}

		return driver.get();

	}

}

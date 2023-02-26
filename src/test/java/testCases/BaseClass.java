package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports r;
	
	@BeforeSuite
	public void start()
	{
		System.out.println("Test execution process started");
	}
	
	@BeforeClass
	public void initialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		ExtentHtmlReporter  report = new ExtentHtmlReporter("src/test/resources/reports/extent.html");
		r= new ExtentReports();
		r.attachReporter(report);
		test = r.createTest("Regression Test");		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
		r.flush();
	}
	
	@AfterSuite
	public void end()
	{
		System.out.println("Test execution process completed");
	}

}

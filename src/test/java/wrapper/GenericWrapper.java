package wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testCases.BaseClass;

public class GenericWrapper extends BaseClass{
	
	public static void waitUntilVisibility(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}
	
	public static String readConfigData(String key) throws Throwable
	{
		File file=new File("src/test/resources/configurations/Settings.properties");
		FileInputStream fis=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
		String value =prop.getProperty(key);
		return value;
	}
	
	public static void screenshotImage(String filename) throws Throwable
	{
		
		TakesScreenshot ss1 =(TakesScreenshot)driver;
		File virtual = ss1.getScreenshotAs(OutputType.FILE);
		File physical = new File("src/test/resources/screenshot/"+filename+".png");
		FileHandler.copy(virtual, physical);
	}
	

	
	public static void rightClick(WebElement value)
	{
		Actions a1= new Actions(driver);
		a1.contextClick(value).perform();
	}
	
	public static void dropDown(WebElement eleValue,String text)
	{
		
		Select s1= new Select(eleValue);
		   s1.selectByVisibleText(text);
	}
	
	public static void moveToElement(WebElement moveElement)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(moveElement);
		
		
		
	}
}

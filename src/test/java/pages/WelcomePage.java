package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;

public class WelcomePage extends BaseClass {
	public WelcomePage()
	{
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(linkText="Create an Account")
	WebElement createAccOption;
	
	@FindBy(xpath="//a[normalize-space()='Sign In']")
	WebElement signInOption;
	
	public void launchApplication() throws Throwable {
		try {
		driver.get(GenericWrapper.readConfigData("url"));
		test.log(Status.PASS,"Successful Website Launch");
	}
		catch(Exception e)
		{
		  System.out.println("Unable to launch the application");
		  test.log(Status.FAIL, "Invalid URL");
		}
		finally
		{
	
			GenericWrapper.screenshotImage("WelcomePage");
		}
}
	
	public void clickAccCreation()
	{
		createAccOption.click();
			
	}
	
	public void clickSignInPage()
	{
		signInOption.click();	
	}
}
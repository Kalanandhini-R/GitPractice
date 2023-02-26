package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;

public class LoginDetailspage extends BaseClass{
	public LoginDetailspage()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="email")
	WebElement emailID;
	
	@FindBy(id="pass")
	WebElement loginPsw;
	
	@FindBy(id="send2")
	WebElement clickOnSignIn;
   
	public void signInCredentials() throws Throwable {
	try {
		GenericWrapper.waitUntilVisibility(emailID);
		emailID.sendKeys(GenericWrapper.readConfigData("Email"));
		loginPsw.sendKeys(GenericWrapper.readConfigData("Password"));
		clickOnSignIn.click();
		test.log(Status.PASS,"SignIn success");
	} 
	catch (Exception e) 
	{	
		  System.out.println("SignInFailure");
		  test.log(Status.FAIL, "Account SignInFailure");
	}
	finally
	{
		GenericWrapper.screenshotImage("SignInPage");
	}
	}

}
       



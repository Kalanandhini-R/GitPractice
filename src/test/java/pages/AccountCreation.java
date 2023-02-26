package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;

public class AccountCreation extends BaseClass{
	
	public AccountCreation()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='First Name']//following::input[1]")
	WebElement firstname;
	
	@FindBy(xpath="//span[text()='First Name']//following::input[2]")
	WebElement lastname;
	
	@FindBy(xpath="//span[text()='First Name']//following::input[3]")
	WebElement newspaper;
	
	@FindBy(xpath="//span[text()='First Name']//following::input[4]")
	WebElement email;
	
	@FindBy(id="password")
	WebElement psw1;
	
	@FindBy(name="password_confirmation")
	WebElement confirmpsw1;
	
	@FindBy(xpath="//span[text()='Create an Account']")
	WebElement createacc;
	
	public void enterUserDetails() throws Throwable
	{
		try {
			GenericWrapper.waitUntilVisibility(firstname);
			firstname.sendKeys(GenericWrapper.readConfigData("Firstname"));
			lastname.sendKeys(GenericWrapper.readConfigData("Lastname"));
			newspaper.click();
			email.sendKeys(GenericWrapper.readConfigData("Email"));
			psw1.sendKeys(GenericWrapper.readConfigData("Password"));
			confirmpsw1.sendKeys(GenericWrapper.readConfigData("Password"));
			createacc.click();
			test.log(Status.PASS,"User Account creation success");
		} 
		catch (Exception e) 
		{
			System.out.println("User creation failure");
			  test.log(Status.FAIL, "User creation failure");
		}
		finally
		{
			GenericWrapper.screenshotImage("UserAccountCreation");
		}	
	}}

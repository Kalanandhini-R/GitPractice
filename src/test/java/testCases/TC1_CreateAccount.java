package testCases;
import org.testng.annotations.Test;

import pages.AccountCreation;
import pages.WelcomePage;

public class TC1_CreateAccount extends BaseClass{
	@Test
	public void WelcomePage() throws Throwable
	{
		WelcomePage firstpage= new WelcomePage();
		firstpage.launchApplication();
		firstpage.clickAccCreation();
		
		AccountCreation acc_creation=new AccountCreation();
		acc_creation.enterUserDetails();
		
	}
	


}

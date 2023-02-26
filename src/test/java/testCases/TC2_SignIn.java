package testCases;

import org.testng.annotations.Test;

import pages.LoginDetailspage;
import pages.WelcomePage;

public class TC2_SignIn extends BaseClass{
	@Test
	public void doSignIn() throws Throwable
	{
		WelcomePage firstpage= new WelcomePage();
		firstpage.launchApplication();
		firstpage.clickSignInPage();
		
		LoginDetailspage login= new LoginDetailspage();
		login.signInCredentials();
	}
}

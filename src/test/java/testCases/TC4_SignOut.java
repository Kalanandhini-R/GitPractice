package testCases;

import org.testng.annotations.Test;

import pages.CategorySelectionPage;
import pages.LoginDetailspage;
import pages.WelcomePage;

public class TC4_SignOut extends BaseClass{
	@Test
	public void clickOnSignOut() throws Throwable
	{
		
		WelcomePage firstpage= new WelcomePage();
		firstpage.launchApplication();
		firstpage.clickSignInPage();
		
		LoginDetailspage sign_in= new LoginDetailspage();
		sign_in.signInCredentials();
		
		CategorySelectionPage selectCategory=new CategorySelectionPage();
		selectCategory.signOut();
	}

}

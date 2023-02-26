package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;

public class CategorySelectionPage extends BaseClass{
	
	public CategorySelectionPage()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//span[text()='Gear']")
	WebElement gearCategory;
	
	@FindBy(xpath="//a[@id='ui-id-25']")
	WebElement bagSelection;
	
	@FindBy(xpath="//ul//li//span[1]//button")
	   WebElement clickOnAccName;
	   
	   @FindBy(xpath="//a[normalize-space()='Sign Out']")
	   WebElement signOutOption;
		
	public void categoryList() throws Throwable
	{
		try {
			GenericWrapper.waitUntilVisibility(gearCategory);
			GenericWrapper.rightClick(gearCategory);
			bagSelection.click();
			test.log(Status.PASS,"Bag Category selection success");
			
		} catch (Exception e) {
			test.log(Status.FAIL, "No such element");
		}
		finally
		{
	
			GenericWrapper.screenshotImage("BagCategorySelection");
		}
		
	}
	
public void signOut() throws Throwable
	
	{
		try {
			GenericWrapper.waitUntilVisibility(clickOnAccName);
			clickOnAccName.click();
			GenericWrapper.waitUntilVisibility(clickOnAccName);
			signOutOption.click();
			test.log(Status.PASS,"Signout success");
		} catch (Exception e)
		{
			test.log(Status.FAIL, "Signout failure");
		}
		finally
		{
	
			GenericWrapper.screenshotImage("SignoutPage");
		}
		
	}



}

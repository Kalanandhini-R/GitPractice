package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;

public class ProductSelectionPage extends BaseClass{
	public ProductSelectionPage()
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//a[normalize-space()='Fusion Backpack']")
	WebElement BagName;
	
	@FindBy(xpath="//a[text()='Search Terms']")
	WebElement move_Element;
	
	public void productList() throws Throwable 
	{
	    try {
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    	GenericWrapper.moveToElement(move_Element);
			BagName.click();
			test.log(Status.PASS,"Product selection successful");
			
		} catch (Exception e) {
			System.out.println("Unable to select the product");
			  test.log(Status.FAIL, "No such element/Unable to select the product");
		}
		
	    finally
		{
			GenericWrapper.screenshotImage("ProductSelectionPage");
		}
}

}

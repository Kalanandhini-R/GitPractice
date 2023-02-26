package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;


public class PaymentMethodPage extends BaseClass {
	
	public PaymentMethodPage()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@title='Place Order']")
	WebElement paymentMethodSelection;
	
	public void placeOrder() throws Throwable
	{
		try {
			Thread.sleep(5000);
			paymentMethodSelection.click();
			test.log(Status.PASS,"Payment selection & Successfully place the order");
		} 
		catch (Exception e) {
			test.log(Status.FAIL,"Payment selection failure");
		}
		finally
		{
	
			GenericWrapper.screenshotImage("PaymentSelection");
		}
		
	}
}

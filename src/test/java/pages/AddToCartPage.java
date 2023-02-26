package pages;


import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;

public class AddToCartPage extends BaseClass{
	public AddToCartPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement addToCart;
	
	@FindBy(xpath="//span[@class='counter-number']")
	   WebElement clickOnMyCard;

@FindBy(xpath="//button[@title='Proceed to Checkout']")
	   WebElement clickOnProceedCheckout;
	
	public void addproductToCard() throws Throwable
	{
		
		try {
			GenericWrapper.waitUntilVisibility(addToCart);
			addToCart.click();
			test.log(Status.PASS,"Add to Cart success");
		} 
		catch (Exception e) {
			System.out.println("Add to Cart failure");
			test.log(Status.FAIL,"Add to Cart failure");
		}
		finally
		{
	
			GenericWrapper.screenshotImage("AddToCardImage");
		}
		
		
	}
	
	
	
	public void clickOnMyCard() throws Throwable {
		try {
			Thread.sleep(5000);
			clickOnMyCard.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			clickOnProceedCheckout.click();
			test.log(Status.PASS,"Proceed to Checkout success");
		} catch (Exception e) {
			System.out.println("Proceed to Checkout failure");
			  test.log(Status.FAIL, "Proceed to Checkout failure");
		}	
		finally
		{

			GenericWrapper.screenshotImage("ProceedToCheckout");
		}
	}

}

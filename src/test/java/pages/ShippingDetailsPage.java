package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import testCases.BaseClass;
import wrapper.GenericWrapper;

public class ShippingDetailsPage extends BaseClass{
  public ShippingDetailsPage()
  {
	  PageFactory.initElements(driver,this);
	  
  }
  
  @FindBy(xpath="//input[@name='company']")
	WebElement companyName;
  
  @FindBy(xpath="//input[@name='street[0]']")
 	WebElement streetName;
	
  @FindBy(xpath="//input[@name='city']")
	WebElement cityName;
	
  @FindBy(xpath="//select[@class='select']")
  WebElement stateSelection;
  
  @FindBy(xpath="//input[@name='postcode']")
  WebElement postalCode;
  
  @FindBy(xpath="//select[@name='country_id']")
  WebElement country;

  @FindBy(xpath="//input[@name='telephone']")
  WebElement mobileNumber;
  
  @FindBy(xpath="//span[text()='Next']")
  WebElement nextButton;
  
  public void shippingAddress() throws Throwable
  {
	  try {
		GenericWrapper.waitUntilVisibility(companyName);
		  companyName.sendKeys(GenericWrapper.readConfigData("Companyname"));
		  streetName.sendKeys(GenericWrapper.readConfigData("Streetname"));
		  cityName.sendKeys(GenericWrapper.readConfigData("Cityname"));
		  GenericWrapper.dropDown(country,GenericWrapper.readConfigData("Country"));
		  Thread.sleep(2000);
		  GenericWrapper.dropDown(stateSelection,GenericWrapper.readConfigData("State"));
		  postalCode.sendKeys(GenericWrapper.readConfigData("Postalcode"));
		  mobileNumber.sendKeys(GenericWrapper.readConfigData("Mobilenumber"));
		  Thread.sleep(2000);
		  nextButton.click();
		  test.log(Status.PASS,"Shipping details saved successfully");
	} 
	  catch (Exception e) {
		  test.log(Status.FAIL,"Unable to Shipping details");
	}
	  
	  finally
		{
	
			GenericWrapper.screenshotImage("ShippingDetails");
		}
	}
  }
  
  
  


package testCases;

import org.testng.annotations.Test;


import pages.PaymentMethodPage;
import pages.ProductSelectionPage;
import pages.ShippingDetailsPage;
import pages.AddToCartPage;
import pages.CategorySelectionPage;
import pages.LoginDetailspage;
import pages.WelcomePage;

public class TC3_PurchaseItem extends BaseClass {
	@Test
	public void purchaseItemFromList() throws Throwable
	{
	WelcomePage firstpage= new WelcomePage();
	firstpage.launchApplication();
	firstpage.clickSignInPage();
	
	LoginDetailspage sign_in= new LoginDetailspage();
	sign_in.signInCredentials();
	
	CategorySelectionPage selectCategory=new CategorySelectionPage();
	selectCategory.categoryList();
	
	ProductSelectionPage selectProduct=new ProductSelectionPage();
	selectProduct.productList();
	
	AddToCartPage addCart = new AddToCartPage();
	addCart.addproductToCard();
	
	addCart.clickOnMyCard();
	
	ShippingDetailsPage details=new ShippingDetailsPage();
	details.shippingAddress();

	PaymentMethodPage paymentMethod = new PaymentMethodPage();
	paymentMethod.placeOrder();
	
}}

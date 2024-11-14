package Products;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.AllProductPage;
import objectRepository.CartPage;
import objectRepository.ProductPage;
@Listeners(genericUtility.ListenerImplementation.class)
public class AddProductToCartTest extends BaseClass{
	@Test(groups="SmokeSuite")
	
	public void tc001_addSingleProductToCartTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		//Read the data from Exel File
		String PRODUCTNAME=eUtil.readDataFromExcel("Sheet1", 1, 2);
		System.out.println("PRODUCTNAME name is :::"+PRODUCTNAME);
		
		//step 1:Click on Sauce Labs BagPack _product
		Thread.sleep(1000);
		AllProductPage app=new AllProductPage(driver);
		String ProductTitle=app.clickOnProduct(driver, PRODUCTNAME);
		//Step2:Add the product to cart
		System.out.println("click on product is successful");
		ProductPage pp=new ProductPage(driver);
		pp.clickOnAddToCartBtn();
		//Step3:navigate to cart
		pp.ClickOnCartContainer();
		//Assert.fail();
		//Step4:Capture the product name in cart
		CartPage co=new CartPage(driver);
		String ProductTitleInCart=co.captureProductNameInCart();
		Thread.sleep(1000);
		//Step 5:validation
		Assert.assertEquals(ProductTitleInCart,ProductTitle);
			
		}
	@Test(groups="RegressionSuite")
	public void removeProductTest() {
		System.out.println("product removed");
	}


}

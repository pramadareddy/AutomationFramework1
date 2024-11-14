package Products;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.SeleniumUtility;
import objectRepository.AllProductPage;
import objectRepository.CartPage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;


public class AddProductToCartUsingDDTAndGUI {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		//Create Object of Utility Classes
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//Read commonData data from property file
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("PASSWORD");
		//Read the data from Exel File
		String PRODUCTNAME=eUtil.readDataFromExcel("Sheet1", 1, 2);
		System.out.println(PRODUCTNAME);
		//Step 1:launch the browser
		WebDriver driver=new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlywait(driver);
		//Step2;Load the URL
		driver.get(URL);
		//Step3:Login toApplication
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);
		//Step4:Clicke on sauce Labs Bagpack-product
		Thread.sleep(1000);
		AllProductPage app=new AllProductPage(driver);
		
		String ProductTitle=app.clickOnProduct(driver,PRODUCTNAME );
		//Step 5:add the product to cart
		ProductPage pp=new ProductPage(driver);
		pp.clickOnAddToCartBtn();
		
		//Step6:Navigate to cart and validate for product
		pp.clickOnAddToCartBtn();
		CartPage co=new CartPage(driver);
		String ProductTitleInCart=co.captureProductNameInCart();
		Thread.sleep(1000);
		
		if(ProductTitleInCart.equalsIgnoreCase(ProductTitle))
		{
			System.out.println("product added and verified in cart successfully");
			System.out.println(ProductTitleInCart);
		}
		else
		{
			System.out.println("Product not verified in cart");
		}
		//Step7:Logout Application
		app.logoutApp();
		System.out.println("Logout Successful");
		
		
	}




}

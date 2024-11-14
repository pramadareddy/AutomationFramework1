package practice;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.SeleniumUtility;

public class AddProductToCartUsingDDDTAndGUI {
	public static void main(String[] args) throws IOException, InterruptedException {
		//Create Object of Utility Classes
		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		//Read commonData data from property file
		String URL=pUtil.readDataFromPropertyFile("url");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		//Read the data from Exel File
		String PRODUCTNAME=eUtil.readDataFromExcel("Sheet1", 1, 2);
		//Step 1:launch the browser
		WebDriver driver=new EdgeDriver();
	    sUtil.maximizeWindow(driver);
	    sUtil.addImplicitlywait(driver);
		//Step2;Load the URL
		driver.get(URL);
		//Step3:Login toApplication
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		//Step4:Clicke on sauce Labs Bagpack-product
		Thread.sleep(1000);
		System.out.println(PRODUCTNAME);
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		String ProductTitle=driver.findElement(By.xpath("//div[.='\"+PRODUCTNAME+\"']")).getText();
		//Step 5:add the product to cart
		driver.findElement(By.id("add-to-cart")).click();
		//Step6:Navigate to cart and validate for product
		driver.findElement(By.id("shopping_cart_container")).click();
		Thread.sleep(1000);
		
		String ProductTitleInCart=driver.findElement(By.className("inventory_item_name")).getText();
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
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logout Successful");
		
		
	}


		
	}



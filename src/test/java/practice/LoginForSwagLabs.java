package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginForSwagLabs {
	public static void main(String[]args) throws InterruptedException {
		//Step1:launch the browser
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Step2;Load the URL
		driver.get("https://www.saucedemo.com/");
		//Step3:Login toApplication
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		//Step4:Clicke on sauce Labs Bagpack
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
		String ProductTitle=driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).getText();
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

package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.google.common.collect.Table.Cell;

public class AddProductToTheCartUsingDDT {
public static void main(String[] args) throws IOException, InterruptedException {
	//Read common data from Propertyfile
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
	Properties p=new Properties();
	p.load(fisp);
	String URL=p.getProperty("url");
	String USERNAME=p.getProperty("username");
	String PASSWORD=p.getProperty("password");
	//Read Test Data from Excel file
	//C:\Users\veera\eclipse-workspace\AutomatioProgrames\src\test\resources
	FileInputStream fiso=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
    Workbook wb=WorkbookFactory.create(fiso);
    Sheet sh  = wb.getSheet("Sheet1");
    Row rw =sh.getRow(1); 
  org.apache.poi.ss.usermodel.Cell cl=rw.getCell(2);
   String PRODUCTNAME=cl.getStringCellValue();
  
	//Step1:launch the browser
			WebDriver driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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


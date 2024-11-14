package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllProductPage {
//Declaration
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	@FindBy(linkText="Logout")
	private WebElement logoutLink;
	
	//Initialization
	public  AllProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}

	
	
	//Utilization
	
	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	/**
	 * This method will click on menu button
	 */
	//Business Library
	public void ClickMenuBtn()
	{
		menuBtn.click();
	}
	/**
	 * This method will perform logout operation
	 */
	public void logoutApp()
	{
		menuBtn.click(); 
		logoutLink.click();
	}
	public String clickOnProduct(WebDriver driver, String PRODUCTNAME)
	{
		String productTitle=driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).getText();
		driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();
		return productTitle;
		
	}
}

package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
//declaration
	@FindBy(id="add-to-cart")
	private WebElement addToCartBtn;
	@FindBy(id="shopping_cart_container")
	private WebElement cartContainerBtn;
	//initialization
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getAddToCartbtn() {
		return addToCartBtn;
		
	}
	public WebElement getCartContainerBtn() {
		return cartContainerBtn;
	}
	//business library
	/**
	 * this method will click on add to cart buton
	 */
	public void clickOnAddToCartBtn()
	{
		addToCartBtn.click();
	}
	public void ClickOnCartContainer()
	{
		cartContainerBtn.click();
	}
	
}

package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//Rule1: create seperate class for webpage
	//Rule 2:Identify the web element using @FindBy,@FindBys and @FindAll
	@FindBy(id="user-name")
	private WebElement usernameEdt;
	@FindBy(id="password")
	private WebElement passwordEdt;
	@FindBy(id="login-button")
	private WebElement loginBtn;
	//Rule 3:Create Constructor to intialise web element
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
  //Rule 4:Provide getters to access to access the web elemeny
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}
	public WebElement getPasswordEdt() {
		return passwordEdt;
	}
	public WebElement getLoginbtn() {
		return loginBtn;
	}
	//Business library
	public void loginToApp(String USERNAME, String PASSWORD) {
		usernameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
}

package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.beust.jcommander.Parameters;

import objectRepository.AllProductPage;
import objectRepository.LoginPage;

public class BaseClass {
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})
public void bsConfig() {
System.out.println("Database has been sucessful");

}

//@Parameters("browser")
//@BeforeTest
@BeforeClass(alwaysRun=true)
public void bcConfig(/*String BROSERNAME*/) throws IOException {
	/*For Cross browser execution*/
	//if(BROSERNAME.equalsIgnoreCase("Edge"))
	//{
	//	driver=new EdgeDriver();
	//}
	//else if(BROSERNAME.equalsIgnoreCase("Firefox")){
		//driver=new FirefoxDriver();
	//}		
	
	String url=pUtil.readDataFromPropertyFile("url");
	driver=new EdgeDriver();
	sUtil.maximizeWindow(driver);
	sUtil.addImplicitlywait(driver);
	driver.get(url);
	System.out.println("Browser Launch sucessful");
	sdriver=driver;
	
}
@BeforeMethod(alwaysRun=true)
public void bmConfig() throws IOException{
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");
	System.out.println("Username is :"+USERNAME);
	System.out.println("PASSWORD is :"+PASSWORD);
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			System.out.println("Login to Apllication sucessful");
}
@AfterMethod(alwaysRun=true)
public void amConfig() {
	AllProductPage app=new AllProductPage(driver);
	app.logoutApp();
	System.out.println("Logout to Apllication sucessful");
}
//@AfterTest
@AfterClass(alwaysRun=true)
public void acConfig() {
	driver.quit();
	System.out.println("browser closed  sucessful");
}

@AfterSuite(alwaysRun=true)
public void asConfig() {
	System.out.println("Database closed sucessful");
}


}

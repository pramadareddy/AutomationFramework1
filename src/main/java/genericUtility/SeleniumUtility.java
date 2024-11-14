package genericUtility;


	import java.io.File;
	import java.io.IOException;
	import java.time.Duration;

	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.common.io.Files;
	public class SeleniumUtility {
	/**
	 * THis class consist of generic methods related to selenium
	 * @author Chaitra M
	 */

	/**
	 * This method will maximize the window 
	 * @param driver
	 */
		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		/**
		 * This method will minimize the window 
		 * @param driver
		 */
		public void minimizeWindow(WebDriver driver) {
			driver.manage().window().minimize();
		}
		/**This method will implicitly wait
		 * @param driver
		 */
		public void addImplicitlywait(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		/**
		 * This method will wait for the particular web element to be visible
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		/**
		 * This method will handle dropdown by index
		 * @param element
		 * @param index
		 */
			public void handleDropDown(WebElement element,int value) {
				Select s=new Select(element);
				s.selectByIndex(value);
			}
			/**
			 * This method will handle dropdown by text
			 * @param text
			 * @param element
			 */
			public void handleDropDown(String text,WebElement element) {
				Select s=new Select(element);
				s.selectByVisibleText(text);
			}
			/**
			 * This method will perform mouse overingactions on webelement
			 * @param driver
			 * @param element
			 */
			public void mouseOverActions(WebDriver driver, WebElement element) {
				Actions act=new Actions(driver);
				act.moveToElement(element);
				
			}
			/**
			 * This method will perform double click action
			 * @param driver
			 */
			public void doubleClickaction(WebDriver driver) {
				Actions act=new Actions(driver);
				act.contextClick().perform();;
				
			}
			/**
			 * this method will perform dragand drop actions
			 * @param driver
			 * @param src
			 * @param target
			 */
			public void dragAndDropAction(WebDriver driver,WebElement src,WebElement target) {
				Actions act=new Actions(driver);
				act.dragAndDrop(src, target).perform();;
				
			}
			/**
			 * this method is used to perform clickandhold action
			 * @param driver
			 * @param element
			 */
			public void clickAndHoldaActions(WebDriver driver,WebElement element) {
				Actions act=new Actions(driver);
				act.clickAndHold(element).perform();
			}
			/**
			 * This mehtod handle Fram eby Frame  index
			 * @param driver
			 * @param index
			 */
			public void handleFrame(WebDriver driver,int index) {
				driver.switchTo().frame(index);
			}
			/**
			 * This mehtod handle Fram eby Frame idorName
			 * @param driver
			 * @param idOrName
			 */
			public void handleFrame(WebDriver driver,String idOrName) {
				driver.switchTo().frame(idOrName);
			}
			/**
			 * This mehtod handle Fram eby Frame web element
			 * @param driver
			 * @param element
			 */
			public void handleFrame(WebDriver driver,WebElement element) {
				driver.switchTo().frame(element);
			}
			/**
			 * This method will perform scrolltoElment action
			 * @param driver
			 * @param element
			 */
			public void scrollToElementAction(WebDriver driver,WebElement element)
			{
				Actions act= new Actions(driver);
				act.scrollToElement(element).perform();
			}
			/**
			 * This methow will used to perform ScrollUp action
			 * @param driver
			 */
			public void scrollUpAction(WebDriver driver) {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("window.ScrollBy(0,-500)", ",");
				
				
			}
			/**
			 * This methow will used to perform ScrollDown action
			 * @param driver
			 */
			public void scrollDownAction(WebDriver driver) {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				js.executeScript("window.ScrollBy(500,0)", ",");
				}
			public String captureScreenShot(WebDriver driver,String screenshotName) throws IOException {
				TakesScreenshot ts= (TakesScreenshot) driver;
				File src=ts.getScreenshotAs(OutputType.FILE);
				File dst=new File(".//ScreenShot//"+screenshotName+".png");
				Files.copy(src, dst);
				return dst.getAbsolutePath();//extent reports
			}
	}
			




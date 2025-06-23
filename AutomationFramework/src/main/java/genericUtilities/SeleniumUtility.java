package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consists of generic methods related to selenium tool
 * @author swaroop
 */
public class SeleniumUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will fullScreen the window
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		driver.manage().window().fullscreen();
	}
	/**
	 * This method will adds the implicit wait for 10 seconds
	 * @param driver
	 */
	public void addImplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 seconds for the webelement to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * This method will wait for 10 seconds for the webelement to be click
	 * @param driver
	 * @param element
	 */
	public void waitForElementToClick(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//handleDropDown BYIndex, by value, by visibleText samemethodname with different parameters-->methodOverloading
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);
		
	}
	
	/**
	 * This method will handle dropdown by VisibleText
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
		
	}
	
	/**
	 * This method will handle dropdown by deselecting the value
	 * @param element
	 * @param value
	 */
	public void handleDropDownByDeSelectingValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.deselectByValue(value);
		
	}
	/**
	 * This method will perform mouse hovering action on a webElement
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * This method will perform dragAndDrop action on a webElement
	 * @param driver
	 * @param elementToDrag
	 * @param elementToDrop
	 */
	public void dragAndDrop(WebDriver driver, WebElement elementToDrag, WebElement elementToDrop) {
		Actions act = new Actions(driver);
		act.dragAndDrop(elementToDrag, elementToDrop).perform();
	}
	/**
	 * This method will perform doubleClick action on a webElement
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**
	 * This method will perform right click action on a webElement
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will perform click and hold action on a webElement
	 * @param driver
	 * @param element
	 */
	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	/**
	 * This method will perform release action on a webElement
	 * @param driver
	 * @param element
	 */
	public void releaseAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.release(element).perform();
	}
	/**
	 * This method will perform scroll action to a webElement
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	/**This method will handleFrame by frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void handleFrame(WebDriver driver, int frameIndex) {
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will handleFrame by frame Name or ID
	 * @param driver
	 * @param frameNameOrId
	 */
	public void handleFrame(WebDriver driver, String frameNameOrId) {
		driver.switchTo().frame(frameNameOrId);
	}
	/**
	 * This method will handleFrame by frame Element
	 * @param driver
	 * @param frameElement
	 */
	public void handleFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method is used to switch the frame to parent parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**This method is used to switch the frame to main web page
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method used to accept the alert pop up
	 * @param driver
	 */
	public void acceptTheAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method used to cancel the alert pop up
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();;
	}
	/**
	 * This method will enter the data into alert pop up
	 * @param driver
	 * @param data
	 */
	public void enterAlertData(WebDriver driver, String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method will capture the text from alert and return it to caller
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will switch to the required window
	 * @param driver
	 * @param windowId
	 */
	public void switchToWindow(WebDriver driver, String windowId) {
		driver.switchTo().window(windowId);
	}
	/**
	 * This method will scroll down the page by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500)", "");
	}
	/**
	 * This method will scroll up the page by 500 units
	 * @param driver
	 */
	public void scrollUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, -500)", "");
	}
	/**
	 * This method will scroll right to the page 
	 * @param driver
	 */
	public void scrollRight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(250, 500)", "");
	}
	/**
	 * This method will capture screenshot and return the path to the caller
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String captureScreenShot(WebDriver driver, String ScreenShotName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src =screenshot.getScreenshotAs(OutputType.FILE);
		File dest = new File(".//Screenshots//"+ScreenShotName +".png");
		FileHandler.copy(src, dest);
		
		return dest.getAbsolutePath();//For Extent reports
	}
	
	
}



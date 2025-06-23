package objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryOrProductPage extends SeleniumUtility {
	
	
	@FindBy(className="product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(className="shopping_cart_link")
	private WebElement cartContainerbtn;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement openMenuBtn;
	
	@FindBy(linkText="Logout")
	private WebElement logoutBtn;
	
	
	public InventoryOrProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getSortDropDown() {
		return sortDropDown;
	}


	public WebElement getCartContainerbtn() {
		return cartContainerbtn;
	}


	public WebElement getOpenMenuBtn() {
		return openMenuBtn;
	}


	public WebElement getLogoutBtn() {
		return logoutBtn;
	}

/**
 * This method will logout from the application
 */
	public void logoutFromApp() {
		openMenuBtn.click();
		logoutBtn.click();
	}
	
	/**
	 * This method will click on cart container btn
	 */
	public void clickOnCartContainerBtn() {
		cartContainerbtn.click();
	}
	
	/**This method will click on product name stored in excel fil
	 * @param driver
	 * @param prdName
	 */
	public void clickOnProduct(WebDriver driver,String prdName) {
		driver.findElement(By.xpath("//div[.='"+prdName+"']")).click();
	}
	
	/**This method will sort the product and click on product
	 * @param driver
	 * @param sortOption
	 * @param prdName
	 */
	public void clickOnLowestPricedProduct(WebDriver driver, String sortOption, String prdName) {
		handleDropDown(sortDropDown, sortOption);
		driver.findElement(By.xpath("//div[.='"+prdName+"']")).click();
	}

}

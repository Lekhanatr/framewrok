package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	
	@FindBy(className="inventory_item_name")
	private WebElement productName;
	
	@FindBy(className="inventory_item_price")
	private WebElement productPrice;
	
	@FindBy(id="checkout")
	private WebElement checkoutBtn;
	
	@FindBy(name="remove-sauce-labs-bike-light")
	private WebElement removeBtn;
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	/**
	 * This method will click on remove button
	 * 
	 */
	public void clickOnRemoveBtn() {
		removeBtn.click();
	}
	/**
	 * This method will capture the product name and return to caller
	 * @return
	 */
	public String captureItemName() {
		return productName.getText();
	}
}

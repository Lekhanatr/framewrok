package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	
	@FindBy(name="add-to-cart")
	private WebElement addToCartBtn;

	public InventoryItemPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAddToCartBtn() {
		return addToCartBtn;
	}
	
	//Business library
	/**
	 * This method will click on Add to cart button
	 */
	public void clickOnAddToCartButton() {
		addToCartBtn.click();
	}
}

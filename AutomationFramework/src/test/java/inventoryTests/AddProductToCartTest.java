package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepositry.CartPage;
import objectRepositry.InventoryItemPage;
import objectRepositry.InventoryOrProductPage;
import objectRepositry.LoginPage;

@Listeners(genericUtilities.ListenersImplementationUtility.class)
public class AddProductToCartTest extends BaseClass{
	@Test(groups="SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException, Throwable {
		// create object of utilities
		FileUtility fUtil = new FileUtility();

		// REad the testdata from excel file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 1, 2);

		//step4:click  on product
		InventoryOrProductPage prdPage = new InventoryOrProductPage(driver);
		prdPage.clickOnProduct(driver, PRODUCTNAME);
		
		//step5: add product to cart
		InventoryItemPage addToCartBtn = new InventoryItemPage(driver);
		addToCartBtn.clickOnAddToCartButton();

		// step6:Navigate to cart
		prdPage.clickOnCartContainerBtn();

		// step7:validate the product in cart
		Thread.sleep(2000);
		CartPage cartItem = new CartPage(driver);
		String productInCart = cartItem.captureItemName();
		Assert.assertEquals(productInCart,PRODUCTNAME );
		System.out.println(productInCart);
		Assert.assertTrue(productInCart.equals(PRODUCTNAME));

	}
	@Test
	public void sample() {
		//Assert.fail();
		System.out.println("demo");
	}

}

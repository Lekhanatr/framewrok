package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
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
public class AddLowestPriceProductToCartTest extends BaseClass{

	@Test(groups="RegressionSuite")
	public void AddLowestPriceProductToCartTests() throws Throwable {
		//creating objects of utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		//REad the testdata from excel file
		String SORTOPTION = fUtil.readDataFromExcelFile("Inventory", 5, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 5, 3);
		
		
		
		//navigate to dropdown
		InventoryOrProductPage ip = new InventoryOrProductPage(driver);
		WebElement sortDropDownElement = ip.getSortDropDown();
		sUtil.handleDropDown( sortDropDownElement,SORTOPTION);
		
		//click on sorted product
		ip.clickOnProduct(driver, PRODUCTNAME);
		
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartButton();
		//navigate to cart
		ip.clickOnCartContainerBtn();
		
		//validate the product in cart
		CartPage cp = new CartPage(driver);
		String productNameInCart = cp.captureItemName();
		if(productNameInCart.equals(PRODUCTNAME)) {
			System.out.println(PRODUCTNAME + "is in cart");
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
	}
}

package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;
import objectRepositry.CartPage;
import objectRepositry.InventoryItemPage;
import objectRepositry.InventoryOrProductPage;
import objectRepositry.LoginPage;

public class AddProductToCartUsingDDRT {

	public static void main(String[] args) throws IOException, Throwable {
	//create object of utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		//Read the common data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		/*
		 * //Read the common data from property file FileInputStream fils = new
		 * FileInputStream(".\\src\\test\\resources\\CommonData.properties"); Properties
		 * p = new Properties(); p.load(fils); String URL = p.getProperty("url"); String
		 * USERNAME = p.getProperty("username"); String PASSWORD =
		 * p.getProperty("password"); //any variable with capital letters is having DATA
		 */		
		//REad the testdata from excel file
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 1, 2);

		/*
		 * FileInputStream fis = new
		 * FileInputStream(".\\src\\test\\resources\\TestData.xlsx"); Workbook book =
		 * WorkbookFactory.create(fis); Sheet sheet= book.getSheet("Inventory"); Row row
		 * =sheet.getRow(1);//index value starts with 0 and we need to fetch index 1
		 * data(2nd row) from sheet Cell cell =row.getCell(2);//index value starts with
		 * 0 and we need to fetch index 2 data(3rd cell) from sheet String PRODUCTNAME =
		 * cell.getStringCellValue(); System.out.println(PRODUCTNAME);
		 */

		//Launch the browser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addImplicitWait(driver);
				
				//load the URL
				driver.get(URL);
				
				LoginPage login = new LoginPage(driver); //achiving encapsulation by hiding web elements
				login.loginToApp(USERNAME, PASSWORD);
				InventoryOrProductPage prdPage = new InventoryOrProductPage(driver);
				//Add Product To Cart
				//as product name is dynamic, we cannot add prdname through @findbY annotation
				//driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']")).click();//dynamic xpath, if we change productname in excelfile here the automatically product name will change
				//driver.findElement(By.xpath("//button[.='Add to cart']")).click();
				prdPage.clickOnProduct(driver, PRODUCTNAME);
				InventoryItemPage addToCartBtn = new InventoryItemPage(driver);
				addToCartBtn.clickOnAddToCartButton();
				
				//Navigate to cart
				driver.findElement(By.id("shopping_cart_container")).click();
				//driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();
				
				//validate the product
				Thread.sleep(2000);
				CartPage cartItem = new CartPage(driver);
				String productInCart = cartItem.captureItemName();
				if(productInCart.equals(PRODUCTNAME)) {
					System.out.println(productInCart);
					System.out.println("Pass");
				}else {
					System.out.println("Fail");
				}
		
				
				//logout of application
				prdPage.logoutFromApp();
	}

}

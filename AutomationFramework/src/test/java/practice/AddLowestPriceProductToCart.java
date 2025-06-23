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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import genericUtilities.FileUtility;
import genericUtilities.SeleniumUtility;

public class AddLowestPriceProductToCart {

	public static void main(String[] args) throws IOException {
		//creating objects of utilities
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		//Read the common data from property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		//REad the testdata from excel file
		String SORTOPTION = fUtil.readDataFromExcelFile("Inventory", 5, 2);
		String PRODUCTNAME = fUtil.readDataFromExcelFile("Inventory", 5, 3);
				
				//Launch the browser
				WebDriver driver = new EdgeDriver();
				sUtil.maximizeWindow(driver);
				sUtil.addImplicitWait(driver);
				
				//load the URL
				driver.get(URL);
				
				//Login to Application
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.name("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();
				
				//navigate to dropdown
				WebElement sortDropDownElement = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
				sUtil.handleDropDown( sortDropDownElement,SORTOPTION);
				
				//click on sorted product
				driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']")).click();
				driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
				//navigate to cart
				driver.findElement(By.id("shopping_cart_container")).click();
				
				//validate the product in cart
				String productNameInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
				if(productNameInCart.equals(PRODUCTNAME)) {
					System.out.println(PRODUCTNAME + "is in cart");
					System.out.println("pass");
				}else {
					System.out.println("fail");
				}
				
				//logout from application
				driver.findElement(By.className("bm-burger-button")).click();
				driver.findElement(By.id("logout_sidebar_link")).click();
		
	}

}

package practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AddProductToCart {

	public static void main(String[] args) throws Throwable {
		//Launch the browser
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//load the URL
		driver.get("https://www.saucedemo.com/");
		
		//Login to Application
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		//Add Product To Cart
		driver.findElement(By.xpath("//div[.='Sauce Labs Backpack']")).click();
		driver.findElement(By.xpath("//button[.='Add to cart']")).click();
		
		//Navigate to cart
		//driver.findElement(By.id("shopping_cart_container")).click();
		driver.findElement(By.xpath("//a[@class = 'shopping_cart_link']")).click();
		
		//validate the product
		Thread.sleep(2000);
		String productInCart = driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();
		if(productInCart.equals("Sauce Labs Backpack")) {
			System.out.println(productInCart);
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
		}
		
		
		//logout of application
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}

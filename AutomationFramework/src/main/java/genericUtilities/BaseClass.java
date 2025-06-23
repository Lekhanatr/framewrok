package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepositry.InventoryOrProductPage;
import objectRepositry.LoginPage;

/**
 * This class consists of basic configuration annotations of testng
 * @author swaroop
 */
public class BaseClass {
	
	FileUtility fUtil = new FileUtility();
	SeleniumUtility sUtil = new SeleniumUtility();
	JavaUtility jutil = new JavaUtility();
	public WebDriver driver;
	
	//for listeners
	public static WebDriver sdriver;
	
	
	//Better to use always Run in base class, otherwise if we use groups="SmokeSuite" we need to change everytime by using comma 
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void bsConfig() {
		System.out.println("------Database connection sucessfull------");
	}
	

	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig(/*String paramValue*/) throws IOException {
		String URL = fUtil.readDataFromPropertyFile("url");
		//driver =new EdgeDriver();
		driver = new FirefoxDriver();
		//For cross browser Execution
		/*if(paramValue.equals("edge")) {
			driver = new EdgeDriver();
			}else if(paramValue.equals("chrome")) {
			driver = new ChromeDriver();
		}
			else {
				driver = new EdgeDriver();
			}*/
	    sUtil.maximizeWindow(driver);
	    sUtil.addImplicitWait(driver);
	    
		driver.get(URL);
		//for listeners
		sdriver = driver;
		System.out.println("------Browser launch successfull------");
	}
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException {
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("------Login to application is successfull------");
		
	}
	@AfterMethod(alwaysRun=true)
	public void amConfig() {
		InventoryOrProductPage ip =  new InventoryOrProductPage(driver);
		ip.logoutFromApp();
		System.out.println("------Logout from application is successfull------");

	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig() {
		driver.quit();
		System.out.println("------Browser closed successfully-------");
	}
    @AfterSuite(alwaysRun=true)
	public void asConfig() {
		System.out.println("------Database connection closed------");

    }

}

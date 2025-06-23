package objectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //Rule-1->create separate POM class for every web page and class should be same as Page title end with 'page'

	//Rule2: Identitfy all the web elements in webpageusing @FindBy, @FindBys, @FindAll and make them as private
	
	//Declaratiom
	@FindBy(id="user-name")
	private WebElement userNameEdt;
	
	@FindBy(id="password")
	private WebElement passwordEdt;
	
	@FindBy(name = "login-button")
	private WebElement loginBtn;
	
	//Rule3: create constructor for element intialization
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Rule4: provide getters to access the web Elements
	
	//Utilization
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Library - reusable method - specific to project
	/**
	 * This method will perform login operation
	 * @param un
	 * @param pwd
	 */
	public void loginToApp(String un, String pwd) {
		userNameEdt.sendKeys(un);
		passwordEdt.sendKeys(pwd);
		loginBtn.click();

	}
	
	
	
}

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class LoginPage {
	 
	WebDriver driver;

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);  // Page Factory magic
	    }
	    
	    @FindBy(id = "login2")
	    WebElement loginLink;
	    
	    @FindBy(xpath = "//input[@id='loginusername']")
	    WebElement usernameField;

	    @FindBy(xpath = "//input[@id='loginpassword']")
	    WebElement passwordField;

	    @FindBy(xpath = "//button[text()='Log in']")
	    WebElement loginButton;

	    @FindBy(xpath = "//a[@id='nameofuser']")
	    WebElement nameOfUser;

	    public void enterUsername(String username) {
	    	WebElement ele = WaitUtils.waitForVisibility(driver, loginLink);
	    	ele.click();
	    	WebElement elem = WaitUtils.waitForInteractable(driver, usernameField);
	    	elem.sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        passwordField.sendKeys(password);
	    }

	    public void clickLogin() {
	        loginButton.click();
	    }
	    
	    public String getNameOfUser() {
	    	WebElement ele = WaitUtils.waitForVisibility(driver, nameOfUser);
	    	String name = ele.getText();
	    	return name;
	    }
}

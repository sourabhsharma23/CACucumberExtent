package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.LoginPage;
import utils.DriverFactory;

public class loginSteps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);
	
	@Given("User is on the Login Page")
	public void user_is_on_the_login_page() {

		driver.get("https://www.demoblaze.com/index.html");
		
	}

	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() {
		loginPage.enterUsername("admin2301");
        loginPage.enterPassword("admin");
	}

	@When("User clicks on the Login button")
	public void user_clicks_on_the_login_button() {
		loginPage.clickLogin();
	}

	@Then("User should be redirected to the Home Page")
	public void user_should_be_redirected_to_the_home_page() {
		String actual = loginPage.getNameOfUser();
		String expected = "Welcome admin2301";
		Assert.assertEquals(actual, expected);
	}

	@When("User enters username {string} and password {string}")
	public void user_enters_username_and_password(String username, String password) {
		loginPage.enterUsername(username);
	    loginPage.enterPassword(password);
	}
	
	
}

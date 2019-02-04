package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;

public class Steps {
	PageObjectManager pageObjectManager;

	@Given("^Login page is loaded$")
	public void Login_page_is_loaded() throws Throwable {
		pageObjectManager = PageObjectManager.getManager();
		pageObjectManager.getLoginPage().open();
	}

	@When("^I type username \"([^\"]*)\"$")
	public void I_type_username(String username) throws Throwable {
		pageObjectManager.getLoginPage().enterUserName(username);
	}

	@And("^I type password \"(.*)\"$")
	public void I_type_password(String password) throws Throwable {
		pageObjectManager.getLoginPage().enterPassword(password);

	}

	@And("^I click on Login button$")
	public void I_click_on_Login_button() throws Throwable {
		pageObjectManager.getLoginPage().clickLogIn();
	}

	@Then("^I should be successfully logged in$")
	public void I_should_be_successfully_logged_in() throws Throwable {
		Assert.assertTrue(pageObjectManager.getHomePage().isHomePageOnFocus());

	}

	// TC 2 Login with invalid credentials

	@Then("^I am not logged in the system$")
	public void I_am_not_logged_in_the_system() throws Throwable {
		Assert.assertTrue(pageObjectManager.getLoginPage().isLoginPageOnFocus());
	}

	// TC 3 Logout

	@And("^I am logged in with credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void I_am_logged_in_with_credentials_and(String username, String password) throws Throwable {
		pageObjectManager.getLoginPage().login(username, password);
	}

	@When("^I click on Logout$")
	public void I_click_on_Logout() throws Throwable {
		pageObjectManager.getHomePage().clickLogOut();
	}

	@And("^I confirm the logout$")
	public void I_confirm_the_Logout() throws Throwable {

		pageObjectManager.getLogoutPage().clickConfirmLogOut();
	}

	@Then("^I am succesfully logged out$")
	public void I_am_successfully_logged_out() throws Throwable {
		Assert.assertTrue(pageObjectManager.getHomePage().isLoggedOut());
	}

	@After
	public void cleanUp() {
		pageObjectManager.quit();
	}

	@Before
	public void init() {
		PageObjectManager.init();
	}

}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProviders.ConfigFileReader;

public class LoginPage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	private String pageUrl;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader = new ConfigFileReader();
		this.pageUrl = configFileReader.getHost() + configFileReader.getLoginPagePath();
	}

	@FindBy(id = "username")
	private WebElement txtbxUserName;

	@FindBy(css = "input[name='userpass']")
	private WebElement txtbxPassword;

	@FindBy(css = "input[name='ses_login']")
	private WebElement buttonLogin;

	public LoginPage open() {
		driver.get(pageUrl);
		return this;
	}

	public LoginPage enterUserName(String username) {
		txtbxUserName.sendKeys(username);
		return this;
	}

	public LoginPage enterPassword(String password) {
		txtbxPassword.sendKeys(password);
		return this;
	}

	public void clickLogIn() {
		buttonLogin.click();
	}

}
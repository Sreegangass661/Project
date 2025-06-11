package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement userNameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signInClick;
	@FindBy(xpath = "//li[text()='Dashboard']")
	private WebElement dashboard;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alert;

	public LoginPage enterUsernameOnField(String username) {
		userNameField.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnField(String password) {
		passwordField.sendKeys(password);
		return this;

	}

	public HomePagee clickOnSignInButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElementToClick(driver, signInClick);
		signInClick.click();
		return new HomePagee(driver);
	}

	public boolean isDashboardIsLoaded() {
		return dashboard.isDisplayed();
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

}

package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newUserClick;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement username;
	@FindBy(xpath = "(//input[@type='password'])[1]")
	private WebElement password;
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement selectDropdown;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement saveButton;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "(//input[@class='form-control'])[1]")
	private WebElement searchuser;
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement searchUsertype;
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[1]")
	private WebElement userSearchButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement alert;
	@FindBy(xpath = "//span[text()='Active']")
	private WebElement statustext;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	private WebElement editButton;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private WebElement usernameEdit;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordEdit;
	@FindBy(name = "Update")
	private WebElement updateClick;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement editSuccessMessage;

	public AdminUsersPage newClick() {
		newUserClick.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnField(String usernames) {
		username.sendKeys(usernames);
		return this;
	}

	public AdminUsersPage enterPasswordOnField(String passwordd) {
		password.sendKeys(passwordd);
		return this;

	}

	public AdminUsersPage userTypeDropdown() {
		pageutility.selectByDrop(selectDropdown, "Staff");
		return this;
	}

	public AdminUsersPage clickOnSaveButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementToClickonSaveButton(driver, saveButton);
		saveButton.click();
		return this;

	}

	public AdminUsersPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	public AdminUsersPage enterNameOnSearchNameField(String searchName) {
		searchuser.sendKeys(searchName);
		return this;
	}

	public AdminUsersPage selectUsertypeDropDown() {
		pageutility.selectByVisibleText(searchUsertype, "Admin");

		return this;

	}

	public AdminUsersPage clickOnUserSearchButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitforElementToClickSearchButton(driver, userSearchButton);
		userSearchButton.click();
		return this;
	}

	public AdminUsersPage clickOnEditButton() {
		editButton.click();
		return this;

	}

	public AdminUsersPage editUsernameField(String newUsername) {
		usernameEdit.sendKeys(newUsername);
		return this;

	}

	public AdminUsersPage editPasswordField(String password) {
		passwordEdit.sendKeys(password);
		return this;

	}

	public AdminUsersPage clickOnUpdateButton() {
		updateClick.click();
		return this;

	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();

	}

	public boolean isStatusDisplayed() {
		return statustext.isDisplayed();

	}

	public boolean isEditSuccessfulMessageDisplayed() {
		return editSuccessMessage.isDisplayed();
	}
}

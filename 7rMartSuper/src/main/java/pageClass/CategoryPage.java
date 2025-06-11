package pageClass;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class CategoryPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newClick;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement enterCategoryName;
	@FindBy(xpath = "main_img")
	private WebElement chooseFile;
	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement radioButton1Select;
	@FindBy(xpath = "(//input[@type='radio'])[3]")
	private WebElement radioButton2Select;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	private WebElement deleteButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement deleteSuccess;

	public CategoryPage clickonNewButton() {
		newClick.click();
		return this;

	}

	public CategoryPage enterCategoryNameOnField(String categoryName) {
		enterCategoryName.sendKeys(categoryName);
		return this;

	}

	public CategoryPage chooseFileClick() throws AWTException {
		wait.waitForElementToClick(driver, chooseFile);
		FileUploadUtility file = new FileUploadUtility();
		file.roboKeysForFileUpload(chooseFile, Constant.UPLOADFILEFORCATEGORY);
		return this;
	}

	public CategoryPage radioSelectOfTopMenu() {
		radioButton1Select.click();
		return this;

	}

	public CategoryPage radioSelectOfSideMenu() {
		radioButton2Select.click();
		return this;

	}

	public CategoryPage saveButtonClick() {
		saveButton.click();
		return this;

	}

	public CategoryPage clickOnDeleteButton() {
		deleteButton.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public boolean isDeleteSuccessfulMessageDisplayed() {
		return deleteSuccess.isDisplayed();

	}

}

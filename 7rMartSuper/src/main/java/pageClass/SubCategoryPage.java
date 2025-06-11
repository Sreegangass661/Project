package pageClass;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	WaitUtility wait = new WaitUtility();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement newSubcategoryClick;
	@FindBy(xpath = "//select[@name='cat_id']")
	private WebElement categorydropdown;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement enterCategory;
	@FindBy(xpath = "//input[@name='main_img']")
	private WebElement choosefiles;
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	private WebElement subcategorySearchButton;
	@FindBy(xpath = "//input[@class='form-control']")
	private WebElement enterSubCategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchclick;
	@FindBy(xpath = "//span[@class='badge bg-success']")
	private WebElement activeStatus;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement createsuccess;

	public SubCategoryPage newClick() {
		newSubcategoryClick.click();
		return this;
	}

	public SubCategoryPage subcategoryDropdown() {
		pageutility.subCategorySelect(categorydropdown, "554");
		return this;
	}

	public SubCategoryPage enterSubCategoryOnField(String name) {
		enterCategory.sendKeys(name);
		return this;

	}

	public SubCategoryPage chooseFilesClick() throws AWTException {
		wait.waitForElementToClick(driver, choosefiles);
		FileUploadUtility file = new FileUploadUtility();
		file.sendKeysForFileUpload(choosefiles, Constant.UPLOADFILEFORCATEGORY);
		return this;
	}

	public SubCategoryPage clickOnSaveButton() {
		saveButton.click();
		return this;

	}

//search
	public SubCategoryPage clickOnSearchButon() {
		searchButton.click();
		return this;

	}

	public SubCategoryPage searchsubcategoryDropdown() {
		pageutility.subCategorySearch(subcategorySearchButton, "554");
		return this;
	}

	public SubCategoryPage entersubCategoryOnField(String subcategory) {
		enterSubCategory.sendKeys(subcategory);
		return this;

	}

	public SubCategoryPage clickOnSearchButton() {
		searchclick.click();
		return this;

	}

	public boolean isCreateSuccessMessageDisplayed() {
		return createsuccess.isDisplayed();

	}

	public boolean isactivestatusdisplayed() {
		return activeStatus.isDisplayed();

	}
}

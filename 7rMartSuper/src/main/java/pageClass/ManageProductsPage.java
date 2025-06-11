package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageProductsPage {
	PageUtility pageutility = new PageUtility();
	public WebDriver driver;

	public ManageProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchclick;
	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement title;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement productCode;
	@FindBy(name = "cat_id")
	private WebElement categoryDropDown;
	@FindBy(xpath = "(//select[@class='form-control selectpicker'])[2]")
	private WebElement subcategory;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	private WebElement searchClickButton;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	private WebElement resultnotfoundDisplay;

	public ManageProductsPage searchClick() {
		searchclick.click();
		return this;

	}

	public ManageProductsPage enterTitleOnTitleField(String titlename) {
		title.sendKeys(titlename);
		return this;
	}

	public ManageProductsPage enterProductCodeOnField(String code) {
		productCode.sendKeys(code);
		return this;

	}

	public ManageProductsPage selectCategoryDropdown() {
		pageutility.selectCategory(categoryDropDown, 2);
		return this;
	}

	public ManageProductsPage selectSubcategoryDropDown() {
		pageutility.selectSubCategory(subcategory, 2);
		return this;
	}

	public ManageProductsPage clickOnSearchButton() {
		WaitUtility wait = new WaitUtility();
		wait.waitForElementOfClickSearchButtonOfManageProduct(driver, searchClickButton);
		searchClickButton.click();
		return this;

	}

	public boolean isImageDisplayed() {
		return resultnotfoundDisplay.isDisplayed();
	}

}

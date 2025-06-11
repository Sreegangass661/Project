package pageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;
import pageClass.HomePagee;

public class HomePagee {
	public WebDriver driver;

	public HomePagee(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='nav-link'])[2]")
	private WebElement logoutclick;
	@FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
	private WebElement clickonlogoutbutton;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	private WebElement adminUserClick;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[8]")
	private WebElement manageProductsClick;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]")
	private WebElement managenewsClick;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	private WebElement categoryclick;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[4]")
	private WebElement subcategoryClick;

	public ManageNewsPage clickOnManageNews() {
		managenewsClick.click();
		return new ManageNewsPage(driver);

	}

	public CategoryPage clickOnCategoryButton() {
		categoryclick.click();
		return new CategoryPage(driver);

	}

	public AdminUsersPage adminsUserClick() {
		adminUserClick.click();
		return new AdminUsersPage(driver);

	}

	public ManageProductsPage manageProductClick() {
		manageProductsClick.click();
		return new ManageProductsPage(driver);

	}

	public SubCategoryPage clickOnSubCategoryButton() {
		subcategoryClick.click();
		return new SubCategoryPage(driver);
	}

	public HomePagee logout() {
		logoutclick.click();
		clickonlogoutbutton.click();
		return this;

	}

}

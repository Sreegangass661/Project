package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pageClass.HomePagee;
import pageClass.LoginPage;
import pageClass.ManageProductsPage;
import utilities.ExcelUtility;

public class ManageProductsTest extends Base {
	HomePagee home;
	ManageProductsPage manage;

	@Test
	public void verifyValidProductSearch() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		manage = home.manageProductClick();
		String title = ExcelUtility.readStringData(5, 0, "LoginPage");
		String productCode = ExcelUtility.readStringData(5, 1, "LoginPage");
		manage.searchClick().enterTitleOnTitleField(title).enterProductCodeOnField(productCode).selectCategoryDropdown()
				.selectSubcategoryDropDown().clickOnSearchButton();
		boolean imagesIsDisplayed = manage.isImageDisplayed();
		Assert.assertTrue(imagesIsDisplayed, Constant.ERRORMESSAGEFORIVALIDPRODUCTSEARCH);
	}

}

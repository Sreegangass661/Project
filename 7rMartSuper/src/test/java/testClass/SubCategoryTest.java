package testClass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pageClass.HomePagee;
import pageClass.LoginPage;
import pageClass.SubCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtilities;

public class SubCategoryTest extends Base {
	HomePagee home;
	SubCategoryPage subcategory;
	FakerUtilities faker = new FakerUtilities();

	@Test
	public void verifyUserIsAbletoCreateNewSubCategory() throws IOException, AWTException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		String subCategoryNameField = faker.getFakeFirstName();
		subcategory = home.clickOnSubCategoryButton();
		subcategory.newClick().subcategoryDropdown().enterSubCategoryOnField(subCategoryNameField).chooseFilesClick()
				.clickOnSaveButton();
		boolean statusMessage = subcategory.isCreateSuccessMessageDisplayed();
		Assert.assertTrue(statusMessage, Constant.SUBCATEGORYCREATIONUNSUCCESSFUL);

	}

	@Test
	public void verifyUserIsAbleToSearchSubCategory() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		subcategory = home.clickOnSubCategoryButton();
		String subCategory = ExcelUtility.readStringData(5, 2, "LoginPage");
		subcategory.clickOnSearchButon().searchsubcategoryDropdown().entersubCategoryOnField(subCategory)
				.clickOnSearchButton();
		boolean statusMessage = subcategory.isactivestatusdisplayed();
		Assert.assertTrue(statusMessage, Constant.ERRORMESSAGEFORINVALIDSUBCATEGORYSEARCH);
	}
}
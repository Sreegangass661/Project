package testClass;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pageClass.CategoryPage;
import pageClass.HomePagee;
import pageClass.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtilities;

public class CategoryTest extends Base {
	HomePagee home;
	CategoryPage category;
	FakerUtilities faker = new FakerUtilities();

	@Test
	public void verifyNewCategoryCreation() throws IOException, AWTException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		category = home.clickOnCategoryButton();
		String categoryName = faker.getFakeFirstName();
		category.clickonNewButton().enterCategoryNameOnField(categoryName);
		category.chooseFileClick().radioSelectOfTopMenu().radioSelectOfSideMenu().saveButtonClick();
		boolean Message = category.isDeleteSuccessfulMessageDisplayed();
		Assert.assertTrue(Message, Constant.ERRORMESSAGEFORUNSUCESSFULNEWS);
	}

	@Test
	public void verifyUserIsAbleToDeleteCategory() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		category = home.clickOnCategoryButton();
		category.clickOnDeleteButton();
		boolean deleteMessage = category.isDeleteSuccessfulMessageDisplayed();
		Assert.assertTrue(deleteMessage, Constant.SUBCATEGORYDELETIONUNSUCCESSFUL);
	}
}

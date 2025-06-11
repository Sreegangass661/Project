package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pageClass.AdminUsersPage;
import pageClass.HomePagee;
import pageClass.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtilities;

public class AdminUserTest extends Base {
	HomePagee home;
	AdminUsersPage admin;
	FakerUtilities faker = new FakerUtilities();

	@Test
	public void verifynewAdminUserCreation() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		String usernameField = faker.getFakeFirstName();
		String passwordField = faker.getPassword();
		admin.newClick().enterUsernameOnField(usernameField).enterPasswordOnField(passwordField).userTypeDropdown()
				.clickOnSaveButton();
		boolean alertMessage = admin.isAlertDisplayed();
		Assert.assertTrue(alertMessage, Constant.ERRORMESSAGEFORINVALIDUSERCREATION);
	}

	@Test
	public void verifyValidsearchUser() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		String usernameCategory = ExcelUtility.readStringData(1, 0, "CategoryPage");
		admin.clickOnSearchButton().enterNameOnSearchNameField(usernameCategory).selectUsertypeDropDown()
				.clickOnUserSearchButton();
		boolean statusMessage = admin.isStatusDisplayed();
		Assert.assertTrue(statusMessage, Constant.ERRORMESSAGRFORINVALIDUSERSEARCH);
	}

	@Test
	public void verifyUserAbleToEditUserDetails() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		admin = home.adminsUserClick();
		String newUsername = ExcelUtility.readStringData(4, 0, "LoginPage");
		String newPassword = ExcelUtility.readIntegerData(4, 1, "LoginPage");
		admin.clickOnEditButton().editUsernameField(newUsername).editPasswordField(newPassword).clickOnUpdateButton();
		boolean statusMessage = admin.isEditSuccessfulMessageDisplayed();
		Assert.assertTrue(statusMessage, Constant.ERRORMESSAGRFORUNSUCCESSFULADMINUSERDETAILS);
	}

}

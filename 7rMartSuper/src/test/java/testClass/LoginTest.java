package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import pageClass.HomePagee;
import pageClass.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePagee home;

	@Test(dataProvider = "credentials")

	public void verifyCorrectUsernameAndPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		boolean isHomepageIsLoaded = login.isDashboardIsLoaded();
		Assert.assertTrue(isHomepageIsLoaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test
	@Parameters({ "username", "password" })
	public void verifyInvalidUsernameAndCorrectPassword(String username, String password) {
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		login.clickOnSignInButton();
		boolean isAlertLoaded = login.isAlertDisplayed();
		Assert.assertTrue(isAlertLoaded, Constant.ERRORMESSAGEFORLOGIN);

	}

	@Test(groups = {"smoke"})
	public void verifyCorrectUsernameAndInvalidPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readIntegerData(1, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		login.clickOnSignInButton();
		boolean isAlertloaded = login.isAlertDisplayed();
		Assert.assertTrue(isAlertloaded, Constant.ERRORMESSAGEFORINVALIDLOGIN);

	}

	@Test(groups = {"smoke"})
	public void verifyInvalidUsernameAndPassword() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readIntegerData(2, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		login.clickOnSignInButton();
		String expected = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual, Constant.ERRORMESSAGEFORINVALIDLOGIN);
	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admin" } };
		return data;

	}

}
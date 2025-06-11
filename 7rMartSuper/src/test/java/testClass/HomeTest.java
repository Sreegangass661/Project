package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClass.HomePagee;
import pageClass.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePagee home;

	@Test
	public void verifyUserIsAbletoLogOut() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		home.logout();
		String expectedTitle = "Login | 7rmart supermarket";
		String actual = driver.getTitle();
		Assert.assertEquals(expectedTitle, actual, "login failed");

	}
}

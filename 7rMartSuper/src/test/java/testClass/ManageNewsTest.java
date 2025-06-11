package testClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import pageClass.HomePagee;
import pageClass.LoginPage;
import pageClass.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	ManageNewsPage news;
	HomePagee home;

	@Test(retryAnalyzer = retry.Retry.class)
	public void verifyUserIsAbleToCreateNews() throws IOException {
		LoginPage login = new LoginPage(driver);
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		login.enterUsernameOnField(username).enterPasswordOnField(password);
		home = login.clickOnSignInButton();
		news = home.clickOnManageNews();
		String newsValue = ExcelUtility.readStringData(4, 0, "LoginPage");
		news.ClickOnNewButton().enterNewsOnField(newsValue).clickOnSaveButton();
		boolean alertMessage = news.isAlertMessageDisplayed();
		Assert.assertTrue(alertMessage, Constant.ERRORMESSAGEFORUNSUCESSFULNEWS);
	}
}

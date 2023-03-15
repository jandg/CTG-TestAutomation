import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import framework.BasicTest;
import manager.DriverManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;


public class TrainingTests {
	
	private static MenuPage menuPage;
	private static LoginPage loginPage;


	@BeforeSuite 
	public static void setup() {
		menuPage = new MenuPage(DriverManager.getDriver());
		loginPage = new LoginPage(DriverManager.getDriver());
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/#");
	}
	
	//Logging in with correct username / correct password
	@Test
	public void loginCorrect() {
		Assert.assertTrue(loginPage.loginAsAdmin().isWelcomeMessageDisplayed(),"The welcome page is not reached");
	}
	
	//Logging in with correct username / incorrect password
	@Test
	public void loginIncorrectPassword() {
		Assert.assertFalse(loginPage.loginWith("admin", "failed").isWelcomeMessageDisplayed(),"The welcome page is reached");
	}
		
	//Logging in with incorrect username
	@Test
	public void loginIncorrectUsername() {
		Assert.assertFalse(loginPage.loginWith("test","test").isWelcomeMessageDisplayed(),"The welcome page is reached");
	}
	
	@BeforeMethod
	public void logout() {
		menuPage.clickLogout();
	}
	
	@AfterSuite
	public static void shutOff() {
		DriverManager.killDriver();
	}
	

}

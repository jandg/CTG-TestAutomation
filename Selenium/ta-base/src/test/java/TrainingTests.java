import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.BasicTest;
import manager.DriverManager;


public class TrainingTests extends BasicTest{

	
	public TrainingTests() {
		super.initializePages();
	}
	
	//Logging in with correct username / correct password
	@Test
	public void loginCorrect() {
		//menuPage.clickLogout();
		loginPage.loginAsAdmin();
		Assert.assertTrue(welcomePage.isWelcomeMessageDisplayed(),"The welcome page is not reached");
	}
	
	//Logging in with correct username / incorrect password
	@Test
	public void loginIncorrectPassword() {
		//menuPage.clickLogout();
		loginPage.loginWith("admin", "failed");
		Assert.assertFalse(welcomePage.isWelcomeMessageDisplayed(),"The welcome page is reached");
	}
		
	//Logging in with incorrect username
	@Test
	public void loginIncorrectUsername() {
		//menuPage.clickLogout();
		loginPage.loginWith("test","test");
		Assert.assertFalse(welcomePage.isWelcomeMessageDisplayed(),"The welcome page is reached");
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

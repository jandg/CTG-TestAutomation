import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import dataholder.Connection;
import framework.BasicTest;
import manager.DriverManager;
import manager.UtilityManager;
import pageobjects.AdminPage;
import pageobjects.ConnectionPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;


public class TrainingTests {
	
	private static MenuPage menuPage;
	private static LoginPage loginPage;
	private static ConnectionPage connectionPage;

	@BeforeSuite 
	public static void setup() {
		menuPage = new MenuPage(DriverManager.getDriver());
		loginPage = new LoginPage(DriverManager.getDriver());
		connectionPage = new ConnectionPage(DriverManager.getDriver());
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
	
	//Create new connection after logging in
	@Test
	public void createNewConnection() {
		Connection c = new Connection("Jan", "De Geest", "M", "jan.dg@test.be", "0456/12.34.56", "CTG", "Testing", "Junior", "TEST TEXT");
		
		loginPage.loginAsAdmin();
		connectionPage = menuPage.clickNew().addConnection(c);
		
		Assert.assertTrue(connectionPage.getFeedback().equals("Connection 'Jan De Geest' added."),"The connection is not added");
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

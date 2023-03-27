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
import pageobjects.StatsPage;
import pageobjects.WelcomePage;


public class TrainingTests {
	
	private static MenuPage menuPage;
	private static LoginPage loginPage;
	private static ConnectionPage connectionPage;
	private static StatsPage statsPage;

	@BeforeSuite 
	public static void setup() {
		menuPage = new MenuPage(DriverManager.getDriver());
		loginPage = new LoginPage(DriverManager.getDriver());
		connectionPage = new ConnectionPage(DriverManager.getDriver());
		statsPage = new StatsPage(DriverManager.getDriver());
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
	
	//Check stats page after creating 2 new connections
	@Test
	public void checkStats() {
		Connection c1 = new Connection("John", "Doe", "M", "jde@test.be", "0453/12.34.56", "CTG", "Testing", "Junior", "TEST TEXT");
		Connection c2 = new Connection("Jane", "Doa", "F", "jda@test.be", "0453/44.34.56", "CTG", "Testing", "Experienced", "TEST TEXT");
		loginPage.loginAsAdmin();
		connectionPage = menuPage.clickNew().addConnection(c1);
		connectionPage = menuPage.clickNew().addConnection(c2);
		StatsPage sp = menuPage.clickStats();
		int total = Integer.valueOf(sp.getStat(0, 2));
		int men = Integer.valueOf(sp.getStat(1, 2));
		int women = Integer.valueOf(sp.getStat(2, 2));
		Assert.assertTrue( total == (men+women),"The stats are incorrect");
	}
	
	//Check connections page with js functions
	@Test
	public void testConnections() {
		loginPage.loginAsAdmin();
		connectionPage = menuPage.clickNew().resetConnections();
		statsPage = menuPage.clickStats();
		System.out.println("Total connections: " + statsPage.getStat(0, 2));
		connectionPage = menuPage.clickNew().populateConnections();
		statsPage = menuPage.clickStats();
		System.out.println("Total connections: " + statsPage.getStat(0, 2));
		int men = Integer.valueOf(statsPage.getStat(1, 2));
		int women = Integer.valueOf(statsPage.getStat(2, 2));
		Assert.assertTrue( men == 13,"The stats are incorrect");
		Assert.assertTrue( women == 3,"The stats are incorrect");
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

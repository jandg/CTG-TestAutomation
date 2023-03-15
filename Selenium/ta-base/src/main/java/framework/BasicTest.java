package framework;

import org.openqa.selenium.support.PageFactory;

import manager.DriverManager;
import pageobjects.*;

public class BasicTest {
	
	protected static MenuPage menuPage;
	protected static AdminPage adminPage;
	protected static LoginPage loginPage;
	protected static WelcomePage welcomePage;
	
	public static void initializePages() {
		
		menuPage = new MenuPage(DriverManager.getDriver());
		adminPage = new AdminPage(DriverManager.getDriver());
		loginPage = new LoginPage(DriverManager.getDriver());
		welcomePage = new WelcomePage(DriverManager.getDriver());
		
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	
	public static void initializePagesWithEventFiringDriver() {
		
		menuPage = new MenuPage(DriverManager.getEventFiringDriver());
		adminPage = new AdminPage(DriverManager.getEventFiringDriver());
		loginPage = new LoginPage(DriverManager.getEventFiringDriver());
		welcomePage = new WelcomePage(DriverManager.getEventFiringDriver());
		
		DriverManager.getEventFiringDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
		
		DriverManager.registerListener(new TrainingListener());
	}

}

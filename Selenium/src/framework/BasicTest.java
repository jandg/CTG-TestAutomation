package framework;

import org.openqa.selenium.support.PageFactory;

import manager.DriverManager;
import pageobjects.*;

public class BasicTest {
	
	protected static MenuPage menuPage = new MenuPage();
	protected static AdminPage adminPage = new AdminPage();
	protected static LoginPage loginPage = new LoginPage();
	protected static WelcomePage welcomePage = new WelcomePage();
	
	public static void initializePages() {
		
		PageFactory.initElements(DriverManager.getDriver(), menuPage);
		PageFactory.initElements(DriverManager.getDriver(), adminPage);
		PageFactory.initElements(DriverManager.getDriver(), loginPage);
		PageFactory.initElements(DriverManager.getDriver(), welcomePage);
		
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
	}
	
	
	public static void initializePagesWithEventFiringDriver() {
		
		PageFactory.initElements(DriverManager.getEventFiringDriver(), menuPage);
		PageFactory.initElements(DriverManager.getEventFiringDriver(), adminPage);
		PageFactory.initElements(DriverManager.getEventFiringDriver(), loginPage);
		PageFactory.initElements(DriverManager.getEventFiringDriver(), welcomePage);
		
		DriverManager.getEventFiringDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
		
		DriverManager.registerListener(new TrainingListener());
	}

}

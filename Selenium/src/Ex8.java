import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.support.PageFactory;

import manager.DriverManager;
import manager.UtilityManager;
import pageobjects.AdminPage;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class Ex8 {

	private static MenuPage menu;
	private static LoginPage login;
	private static WelcomePage welcome;
	private static AdminPage admin;
	
	public static void main(String[] args) {
		
		List<String> browsers = Arrays.asList("Chrome","Firefox");
		
		for (String s : browsers) {
			
			DriverManager.setDriver(s);
			
			initializePages();
			
			// execute steps
			menu.clickLogout();
			
			login.loginAsAdmin();
			
			menu.clickAdmin();
			
			UtilityManager.switchToOtherWindow(DriverManager.getDriver().getWindowHandle());
			
			// validate popup result
			String popupText = admin.clickResetUsers();
			System.out.println((popupText != null) ? popupText : "No popup shown");
			
			if (admin.createUser("jan", "jdg")) {
				UtilityManager.switchToOtherWindow(DriverManager.getDriver().getWindowHandle());
				
				menu.clickLogout();
				login.loginWith("jan", "jdg");
				
				// validate result
				System.out.println((welcome.getWelcomeMessage().equals("Welcome")) ? "Login succes" : "Login failed");
			}
			

			DriverManager.killDriver();
		}

	}

	public static void initializePages() {
		DriverManager.getDriver().get("https://satrngselcypr.z16.web.core.windows.net/");
		
		menu = new MenuPage();
		login = new LoginPage();
		welcome = new WelcomePage();
		admin = new AdminPage();
		
		PageFactory.initElements(DriverManager.getDriver(), menu);
		PageFactory.initElements(DriverManager.getDriver(), login);
		PageFactory.initElements(DriverManager.getDriver(), welcome);
		PageFactory.initElements(DriverManager.getDriver(), admin);
		
	}

}

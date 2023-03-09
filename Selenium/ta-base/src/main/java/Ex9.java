import org.openqa.selenium.By;

import framework.BasicTest;
import framework.TrainingListener;
import manager.DriverManager;

public class Ex9 extends BasicTest{

public static void main(String[] args) {
		
		initializePagesWithEventFiringDriver();
		
		menuPage.clickLogout();
		loginPage.setLanguageTo("English");
		loginPage.loginWith("admin", "superduper");
		
		System.out.println((welcomePage.getWelcomeMessage().equals("Welcome")) ? "Login succes" : "Login failed");
		
		try {
			DriverManager.getEventFiringDriver().findElement(By.id("notfoundelement"));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		DriverManager.killDriver();

	}

}

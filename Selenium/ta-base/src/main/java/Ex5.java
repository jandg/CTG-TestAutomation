import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import pageobjects.LoginPage;
import pageobjects.MenuPage;
import pageobjects.WelcomePage;

public class Ex5 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jdegeest\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");

		// Menu
		MenuPage menuPage = new MenuPage();
		PageFactory.initElements(driver, menuPage);
		
		menuPage.clickLogout();
		
		// Login
		LoginPage loginPage = new LoginPage();
		PageFactory.initElements(driver, loginPage);
		
		loginPage.loginAsAdmin();
		
		// Welcome
		WelcomePage welcomePage = new WelcomePage();
		PageFactory.initElements(driver, welcomePage);
		
		System.out.println(welcomePage.getWelcomeMessage());
		
		// bis
		menuPage.clickLogout();
		
		loginPage.loginWith("d", "d");
		String error = loginPage.getErrorMessage();
		if (!error.isEmpty()) {
			System.out.println(error);
			loginPage.loginAsAdmin();
			System.out.println(welcomePage.isTheBearDisplayed());
			welcomePage.displayTheBear();
			System.out.println(welcomePage.isTheBearDisplayed());
		}
		else {
			System.out.println("No error");
		}
		
		
		driver.quit();
	

	}
	
	

}

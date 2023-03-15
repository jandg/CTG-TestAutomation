package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

@SuppressWarnings("deprecation")
public class DriverManager {
	
	private static WebDriver driver;
	private static EventFiringWebDriver edriver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			setFirefoxDriver();
		}
		return driver;
	}
	
	public static EventFiringWebDriver getEventFiringDriver() {
		if (driver == null) {
			setChromeDriver();
		}
		if (edriver == null) {
			edriver = new EventFiringWebDriver(driver);
		}
		return edriver;
	}
	
	public static void registerListener(WebDriverEventListener listener) {
		if (edriver == null) {
			getEventFiringDriver();
		}
		edriver.register(listener);
	}
	
	public static void setDriver(String browser) {
		switch(browser) {
			case "Firefox":
	            setFirefoxDriver();
	            break;
	        case "Chrome":
	            setChromeDriver();
	            break;
	        default:
	        	setChromeDriver();
		}
	}
	
	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jdegeest\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public static void setFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jdegeest\\Downloads\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public static void killDriver() {
		if (edriver != null) {
			edriver.quit();
		}
		else driver.quit();
	}

}

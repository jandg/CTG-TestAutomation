import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex2 {
	
	public static void main(String[] args) {
		// Chrome browser
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jdegeest\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		exercise2(driver);	
		// Firefox browser
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jdegeest\\Downloads\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		WebDriver driver2 = new FirefoxDriver();
		exercise2(driver2);
	}
	
	public static void exercise2(WebDriver driver) {
		// go to google
		driver.get("https://www.google.com");
		String title1 = driver.getTitle();
		System.out.println(title1);
		System.out.println("Contains \"footer\" : " + driver.getPageSource().contains("footer"));
		// go to bing
		driver.navigate().to("https://www.bing.com");
		String title2 = driver.getTitle();
		System.out.println(title2);
		System.out.println("Contains \"sb_foot\" : " + driver.getPageSource().contains("sb_admin"));
		// check back function
		driver.navigate().back();
		System.out.println("BACK: " + ((title1.equals(driver.getTitle())) ? "OK" : "not OK"));
		// check refresh function
		driver.navigate().refresh();
		System.out.println("REFRESH: " + ((title1.equals(driver.getTitle())) ? "OK" : "not OK"));
		// quit current browser
		driver.quit();
	}

}

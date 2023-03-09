import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Ex1 {

	public static void main(String[] args) {
		
		// Firefox
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\jdegeest\\Downloads\\geckodriver-v0.32.2-win64\\geckodriver.exe");
		WebDriver driverF = new FirefoxDriver();
		driverF.get("http://www.google.com");
		System.out.println("The title in Firefox is " + driverF.getTitle());
		
		
		// Chrome
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jdegeest\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverC = new ChromeDriver();
		driverC.get("http://www.google.com");
		System.out.println("The title in Chrome is " + driverC.getTitle());
		*/
		
		
	}

}

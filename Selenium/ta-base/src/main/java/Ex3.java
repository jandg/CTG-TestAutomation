import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ex3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jdegeest\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// go to website
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
		
		// go to logout
		driver.findElement(By.id("logout")).click();
		
		// set language
		Select languageOptions = new Select(driver.findElement(By.name("language")));
		languageOptions.selectByVisibleText("French");
		
		// enter inputs
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("superduper");
		
		waitFor();
		
		// click button
		driver.findElement(By.tagName("label")).click();	
		
		// 3bis
		driver.findElement(By.id("crudConnection")).click();
		
		// enter inputs
		driver.findElement(By.id("firstName")).sendKeys("Jan");
		driver.findElement(By.id("lastName")).sendKeys("De Geest");
		driver.findElement(By.id("email")).sendKeys("jan.de.geest@ctg.com");
		WebElement e= driver.findElement(By.id("telephone"));
		e.click();
		e.sendKeys("2222/22.22.22");
		driver.findElement(By.id("company")).sendKeys("CTG");
		
		WebElement sex = driver.findElement(By.id("sex"));
		Select sexOptions = new Select(sex);
		sexOptions.selectByVisibleText("M");
		WebElement ssu = driver.findElement(By.id("SSU"));
		Select ssuOptions = new Select(ssu);
		ssuOptions.selectByVisibleText("Testing");
		WebElement seniority = driver.findElement(By.id("seniority"));
		Select seniorityOptions = new Select(seniority);
		seniorityOptions.selectByVisibleText("Junior");
		
		driver.findElement(By.id("add")).findElements(By.tagName("label")).get(0).click();
		
		waitFor();
		
		driver.quit();
	}
	
	
	public static void waitFor() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

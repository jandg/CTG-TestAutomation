import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Ex4 {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jdegeest\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// go to website
		driver.get("https://satrngselcypr.z16.web.core.windows.net/");
		
		WebElement logoutBtn = driver.findElement(By.xpath("//a[@id='logout']"));
		logoutBtn.click();

		WebElement username = driver.findElement(By.cssSelector("input#username"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		password.sendKeys("superduper");
		
		waitFor();
		
		driver.findElement(By.className("content")).click();
		
		// 3bis
		driver.findElement(By.xpath("//a[@id='crudConnection']")).click();
		
		// enter inputs
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Jan");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("De Geest");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jan.de.geest@ctg.com");
		WebElement e= driver.findElement(By.xpath("//input[@id='telephone']"));
		e.click();
		e.sendKeys("2222/22.22.22");
		driver.findElement(By.xpath("//input[@id='company']")).sendKeys("CTG");
		
		Select sexOptions = new Select(driver.findElement(By.xpath("//select[@id='sex']")));
		sexOptions.selectByVisibleText("M");
		Select ssuOptions = new Select(driver.findElement(By.xpath("//select[@id='SSU']"))); 
		ssuOptions.selectByVisibleText("Testing");
		Select seniorityOptions = new Select(driver.findElement(By.xpath("//select[@id='seniority']")));
		seniorityOptions.selectByVisibleText("Junior");
		
		driver.findElement(By.cssSelector("td#add")).click();
		
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

package framework;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.NoSuchElementException;

import manager.DriverManager;

@SuppressWarnings("deprecation")
public class TrainingListener implements WebDriverEventListener {

	public void afterAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	
	public void afterClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

	
	public void afterNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void afterNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void afterNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void afterNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeAlertAccept(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeAlertDismiss(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	
	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeNavigateBack(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeNavigateForward(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeNavigateRefresh(WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeNavigateTo(String url, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	
	public void onException(Throwable throwable, WebDriver driver) {
		if (throwable instanceof NoSuchElementException) {
			File f = ((TakesScreenshot) DriverManager.getEventFiringDriver()).getScreenshotAs(OutputType.FILE);

			try {
				Date date = new Date(System.currentTimeMillis());
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				FileHandler.copy(f,
						new File("C:\\Users\\jdegeest\\Downloads\\screenshot_" + format.format(date) + ".png"));
				System.out.println("Screenshot is taken!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}

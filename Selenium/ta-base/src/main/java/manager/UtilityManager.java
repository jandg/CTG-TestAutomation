package manager;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityManager {
	
	public static void switchToOtherWindow(String currentWindow) {
		
		Set<String> allWindows = DriverManager.getDriver().getWindowHandles();
		String newWindow = null;
		for (String window : allWindows) {
			if (!currentWindow.equals(window)) {
				newWindow = window;
				break;
			}
		}
		
		DriverManager.getDriver().switchTo().window(newWindow);
		waitFor();
		
	}
	
	public static void waitFor() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

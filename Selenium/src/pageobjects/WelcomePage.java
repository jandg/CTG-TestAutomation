package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import manager.DriverManager;

public class WelcomePage {
	
	@FindBy(how = How.XPATH, using = "//h1[.='Welcome']")
	private WebElement labelWelcome;
	@FindBy(how = How.XPATH, using = "//input[@type='button']")
	private WebElement buttonShow;
	@FindBy(how = How.ID, using = "bear")
	private WebElement imageBear;
	
	public String getWelcomeMessage() {
		return labelWelcome.getText();
	}
	
	public boolean isWelcomeMessageDisplayed() {
		return labelWelcome.isDisplayed();
	}
	
	public void displayTheBear() {
		buttonShow.click();
	}
	public boolean isTheBearDisplayed() {
		return imageBear.isDisplayed();
	}
	
	/*public String getPageSource() {
		return DriverManager.getDriver().getPageSource();
	}*/

}

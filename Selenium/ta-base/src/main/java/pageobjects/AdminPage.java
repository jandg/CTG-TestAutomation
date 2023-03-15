package pageobjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import manager.DriverManager;

public class AdminPage {
	
	@FindBy (how = How.XPATH, using = "//td[.='reset users']")
	private WebElement btnResetUsers;
	
	@FindBy (how = How.XPATH, using = "//td[.='reset connections']")
	private WebElement btnResetConnections;
	
	@FindBy (how = How.XPATH, using = "//label[.='populate records']")
	private WebElement btnPopulateRecords;
	
	@FindBy(how = How.ID, using = "new_username")
	private WebElement newUsernameFld;
	
	@FindBy(how = How.ID, using = "new_password")
	private WebElement newPasswordFld;
	
	@FindBy(how = How.XPATH, using = "//span[.='create']")
	private WebElement createBtn;
	
	@FindBy(how = How.XPATH, using = "//p[@class='feedback']")
	private WebElement labelSuccess;
	
	private WebDriver driver;
	
	public AdminPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public String handleAlert() {
		Alert popup = DriverManager.getDriver().switchTo().alert();
		if (popup != null) {
			String popupText = popup.getText();
			popup.accept();
			return popupText;
		}
		else return null;
	}
	
	public String clickResetUsers() {
		btnResetUsers.click();
		return handleAlert();	
	}
	
	public String clickResetConnections() {
		btnResetConnections.click();
		return handleAlert();
	}
	
	public String clickPopulateRecords() {
		btnPopulateRecords.click();
		return handleAlert();
	}
	
	public boolean createUser(String username, String password) {
		newUsernameFld.clear();
		newUsernameFld.sendKeys(username);
		newPasswordFld.clear();
		newPasswordFld.sendKeys(password);
		createBtn.click();
		
		return labelSuccess.isDisplayed();
	}

}

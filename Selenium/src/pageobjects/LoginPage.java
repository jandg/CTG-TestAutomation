package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	@FindBy(how = How.XPATH, using = "//label")
	private WebElement loginBtn;
	@FindBy(how = How.ID, using = "username")
	private WebElement usernameField;
	@FindBy(how = How.ID, using = "password")
	private WebElement passwordField;
	@FindBy(how = How.NAME, using = "language")
	private WebElement languageField;
	@FindBy(how = How.CSS, using = "#errors > .error")
	private WebElement errorMsg;
	
	public void loginWith(String username, String password ) {
		usernameField.clear();
		usernameField.sendKeys(username);
		passwordField.clear();
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	public void loginAsAdmin() {
		loginWith("admin", "superduper");
	}
	
	public void setLanguageTo(String lang) {
		Select languageOptions = new Select(languageField);
		languageOptions.selectByVisibleText(lang);
	}
	
	public String getErrorMessage() {
		return errorMsg.getText();
	}

}

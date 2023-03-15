package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout;
	
	@FindBy(how = How.ID, using = "crudConnections")
	private WebElement btnCrudConnections;
	
	@FindBy(how = How.XPATH, using = "//a[.='Admin']")
	private WebElement btnAdmin;
	
	private WebDriver driver;
	
	public MenuPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public WelcomePage clickLogout() {
		this.btnLogout.click();
		return new WelcomePage(driver);
	}
	
	/*public void clickNew() {
		this.btnCrudConnections.click();
	}*/
	
	public AdminPage clickAdmin() {
		this.btnAdmin.click();
		return new AdminPage(driver);
	}
	

}

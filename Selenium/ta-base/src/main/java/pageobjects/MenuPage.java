package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuPage {
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement btnLogout;
	
	@FindBy(how = How.ID, using = "crudConnections")
	private WebElement btnCrudConnections;
	
	@FindBy(how = How.XPATH, using = "//a[.='Admin']")
	private WebElement btnAdmin;
	
	public void clickLogout() {
		this.btnLogout.click();
	}
	
	public void clickNew() {
		this.btnCrudConnections.click();
	}
	
	public void clickAdmin() {
		this.btnAdmin.click();
	}
	

}

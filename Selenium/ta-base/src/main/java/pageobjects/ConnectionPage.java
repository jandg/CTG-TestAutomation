package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import dataholder.Connection;
import manager.UtilityManager;

public class ConnectionPage {
	
	@FindBy(how = How.ID, using ="firstName")
	private WebElement fldFirstName;
	
	@FindBy(how = How.ID, using ="lastName")
	private WebElement fldLastName;
	
	@FindBy(how = How.ID, using ="sex")
	private WebElement cbxSex;
	
	@FindBy(how = How.ID, using ="email")
	private WebElement fldEmail;
	
	@FindBy(how = How.ID, using ="telephone")
	private WebElement fldTelephone;
	
	@FindBy(how = How.ID, using ="company")
	private WebElement fldCompany;
	
	@FindBy(how = How.ID, using ="SSU")
	private WebElement cbxSSU;
	
	@FindBy(how = How.ID, using ="seniority")
	private WebElement cbxSeniority;
	
	@FindBy(how = How.ID, using ="interests")
	private WebElement fldAdditionalInfo;
	
	@FindBy(how = How.XPATH, using ="//td[@id='add']//label")
	private WebElement btnAdd;
	
	@FindBy(how = How.CLASS_NAME, using ="feedback")
	private WebElement lblFeedback;
	
	private WebDriver driver;
	
	public ConnectionPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Create a new connection
	 */
	public ConnectionPage addConnection(Connection connection) {
		fldFirstName.clear();
		fldFirstName.sendKeys(connection.getFirstName());
		
		fldLastName.clear();
		fldLastName.sendKeys(connection.getLastName());
		
		Select selSex = new Select(cbxSex);
		selSex.selectByVisibleText(connection.getSex());
		
		fldEmail.clear();
		fldEmail.sendKeys(connection.getEmail());
		
		fldTelephone.clear();
		fldTelephone.click();
		fldTelephone.sendKeys(connection.getTelephone());
		
		fldCompany.clear();
		fldCompany.sendKeys(connection.getCompany());
		
		Select selSSU = new Select(cbxSSU);
		selSSU.selectByVisibleText(connection.getSsu());
		
		Select selSeniority = new Select(cbxSeniority);
		selSeniority.selectByVisibleText(connection.getSeniority());
		
		fldAdditionalInfo.clear();
		fldAdditionalInfo.sendKeys(connection.getAdditionalInfo());
		
		btnAdd.click();

		return this;
		
	}
	
	public String getFeedback() {
		return this.lblFeedback.getText();
	}

}

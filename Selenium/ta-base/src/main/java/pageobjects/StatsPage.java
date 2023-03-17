package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.StatsTable;
import manager.UtilityManager;

public class StatsPage {
	
	@FindBy(how = How.ID, using = "statsConnections")
	private WebElement tableStats;
	
	private WebDriver driver;
	
	public StatsPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
	}
	
	public String getStat(int row, int col) {
		StatsTable st = new StatsTable(tableStats);
		return st.getText(row, col);
	}

}

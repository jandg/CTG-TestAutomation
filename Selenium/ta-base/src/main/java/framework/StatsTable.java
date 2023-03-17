package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StatsTable implements Table{
	
	private WebElement table;
	private List<WebElement> rows_table; 
	
	public StatsTable(WebElement table) {
		this.table = table;
		this.rows_table = this.table.findElements(By.tagName("tr"));
	}

	@Override
	public int getRowCount() {
		return this.rows_table.size();
	}

	@Override
	public String getText(int row, int column) {
		return this.rows_table.get(row).findElement(By.xpath(".//td["+(++column)+"]")).getText();
	}

}

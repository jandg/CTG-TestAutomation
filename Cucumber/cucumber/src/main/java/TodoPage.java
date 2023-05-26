
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TodoPage {
	
	@FindBy(how = How.XPATH, using = "//h1")
	private WebElement labelTitle;
	@FindBy(how = How.XPATH, using = "//input[@class='new-todo']")
	private WebElement inputTodo;
	@FindBy(how= How.XPATH, using = "//ul[@class='todo-list']/li")
	private List<WebElement> listTodo;
	
	@FindBy(how= How.XPATH, using = "//a[.='Active']")
	private WebElement buttonActive;
	@FindBy(how= How.XPATH, using = "//a[.='Completed']")
	private WebElement buttonCompleted;
	@FindBy(how= How.XPATH, using = "//a[.='All']")
	private WebElement buttonAll;
	@FindBy(how= How.CSS, using = ".clear-completed")
	private WebElement buttonClearCompleted;
	
	private WebDriver driver;
	private Actions actions;
	
	public TodoPage(WebDriver webDriver) {
		this.driver = webDriver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
	}
	
	public String getTitle() {
		return labelTitle.getText();
	}
	
	public TodoPage submitNewTodo(String text) {
		inputTodo.clear();
		inputTodo.sendKeys(text);
		inputTodo.sendKeys(Keys.RETURN);
		return new TodoPage(driver);
		//return (getErrorMessage().isEmpty()) ? new HomePage(driver) : null;
	}
	
	// getActiveTodos
	public Map<String, String> getActiveTodos() {
		Map<String, String> todos = new HashMap<String,String>();
		if (existingTodos()) {
			buttonActive.click();
		}
		else return todos;
		return getTodos();	
	}
	// getCompletedTodos
	public Map<String, String> getCompletedTodos() {
		Map<String, String> todos = new HashMap<String,String>();
		if (existingTodos()) {
			buttonCompleted.click();
		}
		else return todos;
		return getTodos();	
	}
	// getAllTodos
	public Map<String, String> getAllTodos() {
		Map<String, String> todos = new HashMap<String,String>();
		if (existingTodos()) {
			buttonAll.click();
		}
		else return todos;
		return getTodos();	
	}
	// clearCompleted
	public TodoPage clearCompleted() {
		if (buttonCompleted.isDisplayed()) {
			buttonCompleted.click();
		}
		return new TodoPage(driver);
	}
	// deleteTodo
	public TodoPage deleteTodo(String id) {
		WebElement el = driver.findElement(By.cssSelector("li[data-id='"+id+"']"));
		actions.moveToElement(el).perform();
		el.findElement(By.tagName("button")).click();
		return new TodoPage(driver);
	}
	// toggleTodo
	public TodoPage toggleTodo(String id) {
		driver.findElement(By.cssSelector("li[data-id='"+id+"']")).findElement(By.className("toggle")).click();
		return new TodoPage(driver);
	}
	// editTodo
	public TodoPage editTodo(String id, String newText) {
		WebElement elemTodo = driver.findElement(By.cssSelector("li[data-id='"+id+"']"));

		actions.doubleClick(elemTodo).perform();

		WebElement inputEdit = elemTodo.findElement(By.className("edit"));
		inputEdit.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		inputEdit.sendKeys(Keys.BACK_SPACE);
		inputEdit.sendKeys(newText);
		inputEdit.sendKeys(Keys.RETURN);
		return new TodoPage(driver);
	}
	// build map
	private Map<String, String> getTodos() {
		Map<String, String> todos = new HashMap<String,String>();
		for (WebElement element: listTodo) {
	    	String key = element.getAttribute("data-id");
	        String value = element.findElement(By.tagName("label")).getText();  
	        todos.put(key, value);
	    }
	    return todos;
	}
	// check on filters (is list empty?)
	private boolean existingTodos() {
		return (listTodo.size()>0) ? true : false;
	}
	
	/*public String getPageSource() {
		return DriverManager.getDriver().getPageSource();
	}*/

}

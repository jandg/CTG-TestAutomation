import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;
import manager.DriverManager;

@Cucumber
public class TodoStepdefinitions {
	
	private TodoList todos;
	private static TodoPage todoPage;
	private String todoText;
	private String todoId;
	
	
	public TodoStepdefinitions(TodoList tl) {
		todos = tl;
	}
 
    @Given("I open the Todo app")
    public void userOnHomePage() {
        todoPage = new TodoPage(DriverManager.getDriver());
		DriverManager.getDriver().get("https://todomvc.com/examples/vanillajs/");
    }
    
    @Given("I create {int} new todo entries")
    public void createNewEntries(int number) {
        for (int i = 0; i < number; i++) {
        	this.todoText = "random"+i;
        	submitNewTodo();
        }
    }
    
    @Given("I enter {string} into input field")
    public void enterText(String text) {
        this.todoText = text;
    }
    
    @When("I press 'Enter'")
    public void enterTodo() {
        submitNewTodo();
    }
    
    @When("I remove a random todo entry")
    public void removeRandomEntry() {
    	Map<String,String> temp = todoPage.getAllTodos();
    	List<String> keysAsArray = new ArrayList<String>(temp.keySet());
    	Random r = new Random();
    	String key = keysAsArray.get( r.nextInt(keysAsArray.size()) );
        todoPage = todoPage.deleteTodo(key);
        this.todoId = key;
    }
 
    @Then("there are {int} todo entries left")
    public void validateNumberTodos(int number) {
 
    	Map<String,String> temp = todoPage.getAllTodos();
        assertTrue(number == temp.size());
    }
    
    @Then("the removed todo entry is not present")
    public void validateRemovedEntry() {
 
    	Map<String,String> temp = todoPage.getAllTodos();
        assertFalse(temp.containsKey(todoId));
 
    }
    
    @Then("a new todo entry is added")
    public void validateNewTodo() {
 
    	Map<String,String> temp = todoPage.getAllTodos();
        assertTrue(todos.getSize()+1 == temp.size()); 
    }
    
    @Then("the text is {string}")
    public void todoText(String text) {
    	// validate
    	Map<String,String> temp = todoPage.getAllTodos();
		 Map.Entry<String,String> entry = temp.entrySet().iterator().next();
		 this.todoText=entry.getValue();
		 assertTrue(text.equals(todoText));
    }
    
    @When("I complete the third todo entry")
    public void i_complete_the_third_todo_entry() {
    	Map<String, String> temp = todoPage.getActiveTodos();
		List<String> keys = new ArrayList<String>(temp.keySet());
		todoPage.toggleTodo(keys.get(2));
		this.todoId = keys.get(2);
    }

    @Then("the third todo entry has been completed")
    public void the_third_todo_entry_has_been_completed() {
    	Map<String, String> temp = todoPage.getCompletedTodos();
		List<String> keys = new ArrayList<String>(temp.keySet());
		assertTrue(keys.get(0).equals(this.todoId));
    }

    @Then("the number of completed todo entries is {int}")
    public void the_number_of_completed_todo_entries_is(int number) {
    	Map<String, String> temp = todoPage.getCompletedTodos();
		assertTrue(temp.size() == number);
    }

    @When("I edit the second todo entry")
    public void i_edit_the_second_todo_entry() {
    	Map<String, String> temp = todoPage.getActiveTodos();
		List<String> keys = new ArrayList<String>(temp.keySet());
		this.todoId = keys.get(1);
    }

    @When("I change the text to {string}")
    public void i_change_the_text_to(String text) {
    	todoPage.editTodo(todoId,text);
    }

    @Then("the text of the second todo entry reads {string}")
    public void the_text_of_the_second_todo_entry_reads(String text) {
    	Map<String, String> temp = todoPage.getActiveTodos();
		assertTrue(temp.get(todoId).equals(text));
    }
    
    private void submitNewTodo() {
    	todoPage = todoPage.submitNewTodo(todoText);
    }
    
    @AfterAll
    public static void cleanUp() {
    	System.out.println("shutoff");
    	DriverManager.killDriver();
    }
    
    @After
    public void afterTest() {
    	WebDriver driver = DriverManager.getDriver();
    	if (driver instanceof WebStorage) {
    	    WebStorage webStorage = (WebStorage)driver;
    	    webStorage.getSessionStorage().clear();
    	    webStorage.getLocalStorage().clear();
    	}
    }
}



import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import manager.DriverManager;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	TodoPage home = new TodoPage(DriverManager.getDriver());
		
		DriverManager.getDriver().get("https://todomvc.com/examples/vanillajs/");
		
		home.submitNewTodo("tt");
		home.submitNewTodo("tt2");
		Map<String, String> todos = home.getActiveTodos();
		List<String> keys = new ArrayList<String>(todos.keySet());
		System.out.println(todos.size());
		for (String name: keys) {
		    System.out.println(name + " " + todos.get(name));
		}
		home.deleteTodo(keys.get(0));
		home.editTodo(keys.get(1),"tt3");
		todos = home.getActiveTodos();
		keys = new ArrayList<String>(todos.keySet());
		System.out.println(todos.size());
		for (String name: keys) {
		    System.out.println(name + " " + todos.get(name));
		}
		home.toggleTodo(keys.get(0));
		System.out.println(home.getActiveTodos().size());
		DriverManager.killDriver();
    	
    	
    }

}

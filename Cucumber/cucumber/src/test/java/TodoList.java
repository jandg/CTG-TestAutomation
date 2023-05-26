import java.util.HashMap;
import java.util.Map;

public class TodoList {
	
	private Map<String,String> todos;
	
	public TodoList() {
		this.todos = new HashMap<String, String>();
	}
	
	public int getSize() {
		return this.todos.size();
	}


}

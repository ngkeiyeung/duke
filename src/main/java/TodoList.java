import java.util.ArrayList;

public class TodoList {
    public static ArrayList<Task> todoList ;

    /**
     * To get the size of task
     *
     * @return int
     */
    public static Task taskSize(int description) {
        return todoList.get(description);
    }

    /**
     * Creating and initializing a new todoList
     */
    public TodoList() {
        this.todoList = new ArrayList<>();
    }

    /**
     * Creating a specified type of new todolist
     *
     * @param todo
     */
    public TodoList(ArrayList<Task> todo) { this.todoList = todo; }

    /**
     * Creating the new scope of todoList
     *
     * @param description       Adding the new task into the todoList
     */
    public static void setTodoList(Task description) {
        todoList.add(description);
    }

}

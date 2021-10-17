package project.functions;

import java.util.ArrayList;

public class TodoList {
    public static ArrayList<Task> todoList ;

    /**
     * To get the size of task
     *
     * @return int
     */
    public static int length() {
        return todoList.size();
    }

    /**
     * Creating and initializing a new todoList
     *
     * @return array
     */
    public TodoList() {
        this.todoList = new ArrayList<>();
    }



    /**
     * Creating a specified type of new todolist
     *
     * @param todo
     * @return String
     */
    public TodoList(ArrayList<Task> todo) {
        this.todoList = todo;
    }

    /**
     * to get a todolist
     *
     * @param description
     * @return String
     */
    public static Task getList(int description) {
        return todoList.get(description);
    }

    /**
     * Creating the new scope of todoList
     *
     * @param description       Adding the new task into the todoList
     * @return String
     */
    public static void setTodoList(Task description) {
        todoList.add(description);
    }

    /**
     * To get a todolist that will be removed
     *
     * @param description
     * @return String
     */
    public Task toDelete(int description) {
        return todoList.remove(description);
    }


}

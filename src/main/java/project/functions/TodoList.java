package project.functions;

import java.util.ArrayList;

public class TodoList {
    public static ArrayList<Task> todoList ;

    /**
     * To get the size of task
     *
     * @return int length of the Todolist
     */
    public static int length() {
        return todoList.size();
    }

    /**
     * Creating and initializing a new todoList
     *
     */
    public TodoList() {
        todoList = new ArrayList<>();
    }

    /**
     * Creating a specified type of new todolist
     *
     */
    public TodoList(ArrayList<Task> todo) {
        todoList = todo;
    }

    /**
     * to get a todolist
     *
     * @return String The index of the todolist e.g: 1,2,3,4,5...
     */
    public static Task getList(int description) {
        return todoList.get(description);
    }

    /**
     * Creating the new scope of todoList
     *
     * @param description  Adding the new task into the todoList
     */
    public static void setTodoList(Task description) {
        todoList.add(description);
    }

    /**
     * To get a todolist that will be removed
     *
     */
    public void toDelete(int description) {
        todoList.remove(description);
    }


}

package project.textContent;

import project.functions.TodoList;
import project.functions.Todos;
import project.functions.Function;
import project.storage.Save;
import project.ui.Ui;

public class Todo extends Function {
    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Todo(boolean isExit, String description) {
        super(isExit, description);
    }

    @Override
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception{
        if(keyword(4).equals(empty)){
            throw new Exception("The description of task cannot be empty. please try again!");
        }

        todoList.setTodoList(new Todos(keyword(5)));
        assert todoList.length() > 0;

        ui.outputDisplay("Got it. I've added this task:\n"
                + new Todos(keyword(5)).getTaskDescription()
                + "\nNow you have "
                + todoList.length()
                + " in task list.");
        storage.saveFile();
    }

}

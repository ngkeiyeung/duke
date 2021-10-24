package project.TextContent;

import project.functions.TodoList;
import project.functions.Todos;
import project.functions.function;
import project.storage.save;
import project.ui.ui;

public class todo extends function {
    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public todo(boolean isExit, String description) {
        super(isExit, description);
    }

    @Override
    public void exe(TodoList todoList, ui ui, save storage) throws Exception{
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

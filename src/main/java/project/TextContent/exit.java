package project.TextContent;

import project.functions.TodoList;
import project.functions.function;
import project.storage.save;
import project.ui.ui;

public class
exit extends function {

    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public exit(boolean isExit, String description) {
        super(isExit, description);
    }

    public void exe(TodoList todoList, ui ui, save storage) {
        ui.exitMessage();
    }
}

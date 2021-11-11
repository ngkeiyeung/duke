package project.textContent;

import project.functions.TodoList;
import project.functions.Function;
import project.storage.Save;
import project.ui.Ui;

public class
Exit extends Function {

    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Exit(boolean isExit, String description) {
        super(isExit, description);
    }

    public void exe(TodoList todoList, Ui ui, Save storage) {
        ui.byeBye();
    }
}

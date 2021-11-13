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

    /**
     * To display the goodbye message
     *
     * @param todoList the todolist in the system
     * @param ui connect to the UI interface GUI
     * @param storage to load the todolist file from the system
     * @throws Exception To handle the error code if function incorrect
     */
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {
        if(TodoList.length() == 0){
            throw new Exception("Error, please try again later");
        }
        ui.byeBye();
    }
}

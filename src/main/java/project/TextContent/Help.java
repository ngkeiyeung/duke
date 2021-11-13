package project.textContent;

import project.functions.Function;
import project.functions.TodoList;
import project.storage.Save;
import project.ui.Ui;


public class Help  extends Function {
    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Help(boolean isExit, String description) {
        super(isExit, description);
    }

    @Override
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {

        if (TodoList.length() == 0) {
            throw new Exception("Type wrongly, please try it again!");
        }
        ui.outputDisplay("Here is the command:"
                + "command '" + "add" + "' " + "to add new task\n"
                + "command '" + "event" + "' " + "to add new event\n"
                + "command '" + "deadline" + "' " + "to add new deadline\n"
                + "command '" + "done" + "' " + "to mark task or event as done\n"
                + "command '" + "delete" + "' " + "to delete the task or event\n"
                + "command '" + "find" + "' " + "to find the task or event\n"
                + "command '" + "event" + "' " + "to add new event\n"
                + "command '" + "help" + "' " + "to view help page\n"
                + "command '" + "bye" + "' " + "to exit the program\n");
    }
}

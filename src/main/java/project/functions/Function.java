package project.functions;

import project.storage.Save;
import project.ui.Ui;

public class Function {
    public boolean isExit;
    public String description;
    public String empty = "";
    public String dateTimeFormat = "DD/MM/YYYY HHmm";
    public int i = 0;

    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Function(boolean isExit, String description) {
        this.isExit = isExit;
        this.description = description;
    }

    /**
     * to decide true or false
     *
     * @return boolean the function will be activated when isExit is true.
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * To give a warning message that if the function does not exist.
     *
     * @param todoList to load the todolist
     * @param ui connect to the UI interface GUI
     * @param storage to load the todolist file from the system
     * @throws Exception To display the wrong function error message
     */
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {
        throw new Exception("The function was not found. Please try again!");
    }

    /**
     * To provides coefficients for listing functions as well as finding lists
     *
     * @param word the input from the user
     * @return String for list index, and list function
     */
    public String keyword(int word) {
        return description.substring(word);
    }
}

package project.functions;

import project.storage.Save;
import project.ui.Ui;

import java.io.IOException;

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
     * @return boolean
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * To give a warning message that if the function does not exist.
     *
     * @param todoList
     * @param ui
     * @param storage
     * @throws Exception
     * @throws IOException
     */
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {
        throw new Exception("The function was not found. Please try again!");
    }

    public String keyword(int word) {
        String keyword = description.substring(word);
        return keyword;
    }
}

package project.functions;

import project.storage.save;
import project.ui.ui;

import java.io.IOException;

public abstract class function {
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
    public function(boolean isExit, String description) {
        this.isExit = isExit;
        this.description = description;
    }


    public String empty(String empty) {
        return this.empty = empty;
    }

    public int i(int i) {
        return this.i = i;
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
    public void exe(TodoList todoList, ui ui, save storage) throws Exception, IOException {
        throw new Exception("The function was not found. Please try again!");
    }

    public String keyword(int word) {
        String keyword = description.substring(word);
        return keyword;
    }
}

package project.textContent;

import project.functions.TodoList;
import project.functions.Function;
import project.storage.Save;
import project.ui.Ui;

public class Completed extends Function {

    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Completed(boolean isExit, String description) {
        super(isExit, description);
    }

    /**
     * To mark todolist as completed status.
     *
     * @param todoList the todolist in the system
     * @param ui connect to the UI interface GUI
     * @param storage to load the todolist file from the system
     * @throws Exception To handle the error code if function incorrect
     */
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception{
        if(keyword(4).equals(empty)){
            throw new Exception("The Task cannot be done. Please re-enter the task.");
        }

        i = Integer.parseInt(keyword(5));
        i--;

        TodoList.getList(i).markCompleted();
        ui.outputDisplay("Nice! I have marked this task as done:\n"
                + TodoList.getList(i).getTaskDescription());
        storage.saveFile();
    }

}

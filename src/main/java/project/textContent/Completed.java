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

    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception{
        if(keyword(4).equals(empty)){
            throw new Exception("The Task cannot be done. Please re-enter the task.");
        }

        i = Integer.parseInt(keyword(5));
        i--;

        todoList.getList(i).markCompleted();
        ui.outputDisplay("Nice! I have marked this task as done:\n"
                + todoList.getList(i).getTaskDescription());
        storage.saveFile();
    }

}

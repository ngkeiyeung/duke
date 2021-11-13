package project.textContent;

import project.exception.Exception;
import project.functions.TodoList;
import project.functions.Function;
import project.storage.Save;
import project.ui.Ui;

public class Delete extends Function {

    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Delete(boolean isExit, String description) {
        super(isExit, description);
    }

    @Override
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {
        if(description.substring(7).equals(empty)){
            throw new Exception("Which task to delete?");
        }
        i = Integer.parseInt(description.substring(7));
        i--;

        ui.outputDisplay("Noted. I've removed this task:\n"
                + "\t"
                + TodoList.getList(i).getTaskDescription());
        todoList.toDelete(i);
        storage.saveFile();
    }
}

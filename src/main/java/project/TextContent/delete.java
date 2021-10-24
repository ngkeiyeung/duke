package project.TextContent;

import project.Duke;
import project.Exception.Exception;
import project.functions.TodoList;
import project.functions.function;
import project.storage.save;
import project.ui.ui;

public class delete extends function {

    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public delete(boolean isExit, String description) {
        super(isExit, description);
    }

    public void exe(TodoList todoList, ui ui, save storage) throws java.lang.Exception {
        if(description.substring(7).equals(empty)){
            throw new Exception("Which task to delete?");
        }
        i = Integer.parseInt(description.substring(7));
        i--;

        ui.outputdisplay("Noted. I've removed this task:\n"
                + "\t"
                + todoList.getList(i).getTaskDescription());
        todoList.toDelete(i);
        storage.saveFile();
    }
}

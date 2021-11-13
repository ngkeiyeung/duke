package project.textContent;

import project.functions.Task;
import project.functions.TodoList;
import project.functions.Function;
import project.ui.Ui;
import project.storage.Save;

import java.util.ArrayList;
import java.util.List;

import static project.textContent.Lists.getNumber;

public class Find extends Function {
    private boolean match;
    /**
     * Return user input and initialize the status of the description
     *  @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Find(boolean isExit, String description) {
        super(isExit, description);
    }

    @Override
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {
        List<String> matchList = new ArrayList<>();
        String str = description.substring(4);

        if (str.equals(empty)){
            throw new Exception("The task was not found, please try again!");
        }

        for (int i = TodoList.length() - 1; i >= 0; i--) {
            Task task = TodoList.getList(i);
            if (task.getTaskDescription().contains(str)) {
                matchList.add(task.getTaskDescription());
                match = true;
            }
        }

        if(match) {
            ui.outputDisplay("Here is your todo list: " + getNumber(matchList));
        } else {
            System.out.println("No record! Please try again later!\n");
        }
    }

}

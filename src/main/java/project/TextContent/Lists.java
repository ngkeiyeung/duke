package project.textContent;

import project.functions.Function;
import project.functions.TodoList;
import project.storage.Save;
import project.ui.Ui;


import java.util.ArrayList;
import java.util.List;

public class Lists extends Function {


    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Lists(boolean isExit, String description) {
        super(isExit, description);
    }


    public String listDetail(TodoList todoList) {
        List<String> item = new ArrayList<>();
        for (int i = 0; i< todoList.length(); i++) {
            item.add(todoList.getList(i).getTaskDescription());
        }
        return getNumber(item);
    }

    public static String getTodoList(int number, String list){
        return String.format("%1$d. %2$s", number, list);
    }

    public static String getNumber(List<String> lists){
        //initialize number of list, starting from 1
        int number = 1;
        String item = "";
        for (String list : lists){
            item = item + ("\n" + getTodoList(number, list));
            number++;
        }
        return item;
    }

    @Override
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {
        if (todoList.length() == 0) {
            throw new Exception("There is no todo list, please try again!");
        }
        ui.outputDisplay("The todo list as below: " + listDetail(todoList));
    }
}

package project.textContent;

import project.functions.Deadlines;
import project.functions.Function;
import project.functions.TodoList;
import project.ui.Ui;
import project.storage.Save;
import project.exception.Exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class Deadline extends Function {
    public Deadlines deadline;

    /**
     * Return user input and activate deadline function
     *
     * @param isExit The boolean value if the exit condition is true.
     * @param description task description
     */
    public Deadline(boolean isExit, String description) {
        super(isExit, description);
    }

    public LocalDateTime stringFormat(String date) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new Exception("The format of the date and time is not " + dateTimeFormat);
        }
    }

    @Override

    public void exe (TodoList todoList, Ui ui, Save storage) throws Exception {

        if (description.substring(8).equals(empty)) {
            throw new Exception("The deadline cannot be null. Please re-enter the deadline");
        } else if (!description.contains("by")) {
            throw new Exception("The date cannot be null, please re-entry the date.");
        }

        deadline = new Deadlines(description.substring(9, description.indexOf("by") - 1), stringFormat(description.substring(description.indexOf("by") + 3)));
        TodoList.setTodoList(deadline);

        assert TodoList.length() > 0;
        ui.outputDisplay("Got it. I've added this task:\n"
                + deadline.getTaskDescription()
                + "\nNow you have "
                + TodoList.length()
                + " in task list.");
        storage.saveFile();
    }

}

package project.TextContent;

import project.functions.Deadlines;
import project.functions.function;
import project.functions.TodoList;
import project.ui.ui;
import project.storage.save;
import project.Exception.Exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class deadline extends function{
    public Deadlines deadline;

    public deadline(boolean isExit, String description) {
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
    public void exe (TodoList todoList, ui ui, save storage) throws Exception{

        if (description.substring(8).equals(empty)) {
            throw new Exception("The deadline cannot be null. Please re-enter the deadline");
        } else if (!description.contains("by")) {
            throw new Exception("The date cannot be null, please re-entry the date.");
        }

        deadline = new Deadlines(description.substring(9, description.indexOf("by") - 1), stringFormat(description.substring(description.indexOf("by") + 3)));
        todoList.setTodoList(deadline);

        assert todoList.length() > 0;
        ui.outputDisplay("Got it. I've added this task:\n"
                + deadline.getTaskDescription()
                + "\nNow you have "
                + todoList.length()
                + " in task list.");
        storage.save();
    }

}

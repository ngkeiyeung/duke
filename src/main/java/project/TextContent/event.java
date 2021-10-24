package project.TextContent;

import project.Exception.Exception;
import project.functions.Events;
import project.functions.TodoList;
import project.functions.function;
import project.storage.save;
import project.ui.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class event extends function{
    public Events events;
    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public event(boolean isExit, String description) {
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
    public void exe(TodoList todoList, ui ui, save storage) throws java.lang.Exception {
        if (description.substring(5).equals(empty)) {
            throw new Exception("The description of event cannot be empty.");
        } else if (!description.contains("at")) {
            throw new Exception("The event date cannot be empty.");
        }

        events = new Events(description.substring(6, description.indexOf("at") - 1), stringFormat(description.substring(description.indexOf("at") + 3)));
        todoList.setTodoList(events);

        assert todoList.length() > 0;
        ui.outputDisplay("Got it. I've added this task:\n"
                + events.getTaskDescription()
                + "\nNow you have "
                + todoList.length()
                + " in task list.");
        storage.saveFile();
    }


}

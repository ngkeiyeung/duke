package project.textContent;

import project.exception.Exception;
import project.functions.Events;
import project.functions.TodoList;
import project.functions.Function;
import project.storage.Save;
import project.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Function {
    public Events events;
    /**
     * Return user input and initialize the status of the description
     *
     * @param isExit      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public Event(boolean isExit, String description) {
        super(isExit, description);
    }

    /**
     * To convert date and time format to String format
     *
     * @param date the event data and time
     * @return String date and time for the event
     * @throws Exception Error message if it is not format
     */
    public LocalDateTime stringFormat(String date) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new Exception("The format of the date and time is not " + dateTimeFormat);
        }
    }

    @Override
    public void exe(TodoList todoList, Ui ui, Save storage) throws Exception {
        if (description.substring(5).equals(empty)) {
            throw new Exception("The description of event cannot be empty.");
        } else if (!description.contains("at")) {
            throw new Exception("The event date cannot be empty.");
        }

        events = new Events(description.substring(6, description.indexOf("at") - 1), stringFormat(description.substring(description.indexOf("at") + 3)));
        TodoList.setTodoList(events);

        assert TodoList.length() > 0;
        ui.outputDisplay("Got it. I've added this task:\n"
                + events.getTaskDescription()
                + "\nNow you have "
                + TodoList.length()
                + " in task list.");
        storage.saveFile();
    }


}

package project.functions;

import project.Exception.Exception;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadlines extends Task {
    public LocalDateTime timing;
    private String deleted = "[D]";

    /**
     * The purpose of new task description is
     * Initializing the new task and mark the progress as incomplete.
     *
     * @param description
     */
    public Deadlines(String description, LocalDateTime timing) {
        super(description);
        this.timing = timing;
    }

    /**
     * Return the deadline of the task
     *
     * @return String
     */
    @Override
    public String getTaskDescription() {
        return deleted + getTaskDescription();
    }

    /**
     * To get the date and time
     *
     * @return String
     */
    public LocalDateTime DateTime() {
        return this.timing;
    }

    /**
     * To convert date and time as string
     *
     * @param time
     * @return String
     */
    public String dateFormat(LocalDateTime time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        return timing.format(dateFormat);
    }

}

package project.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Deadlines extends Task {
    public LocalDateTime deadlineTime;
    private String deleted = "[D]";

    /**
     * The purpose of new task description is
     * Initializing the new task and mark the progress as incomplete.
     *
     * @param description
     */
    public Deadlines(String description, LocalDateTime deadlineTime) {
        super(description);
        this.deadlineTime = deadlineTime;
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
    public LocalDateTime deadlineTime() {
        return this.deadlineTime;
    }

    /**
     * To convert date and time as string
     *
     * @param time
     * @return String
     */
    public String dateFormat(LocalDateTime time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        return time.format(dateFormat);
    }

}

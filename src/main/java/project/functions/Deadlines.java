package project.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Deadlines extends Task {

    /**
     * The purpose of new task description is
     * Initializing the new task and mark the progress as incomplete.
     *
     * @param description Task description
     */
    public Deadlines(String description, LocalDateTime deadlineTime) {
        super(description);
        this.deadlineTime = deadlineTime;
    }

    /**
     * Return the deadline of the task
     *
     * @return String task description
     */
    @Override
    public String getTaskDescription() {
        String deleted = "[D]";
        return deleted + getTaskDescription() + " by the date/time: " + dateFormat(deadlineTime);
    }

    /**
     * To convert date and time as string
     *
     * @param time tasks/ events data and time
     * @return String convert from other format to time format
     */
    public String dateFormat(LocalDateTime time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        return time.format(dateFormat);
    }

}

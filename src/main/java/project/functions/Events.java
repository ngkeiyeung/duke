package project.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    public LocalDateTime eventTime;

    /**
     * The purpose of new task description is
     * Initializing the new task and mark the progress as incomplete.
     *
     * @param description
     */
    public Events(String description, LocalDateTime eventTime) {
        super(description);
        this.eventTime = eventTime;
    }



    /**
     * Return the deadline of the task
     *
     * @return
     */
    @Override
    public String getTaskDescription() {
        return "[E]" + getTaskDescription();
    }

    /**
     * To get the date and time
     *
     * @return String
     */
    public LocalDateTime eventTime() {
        return this.eventTime;
    }

    /**
     * To convert date and time as string
     *
     * @param time
     * @return String
     */
    public String dateFormat(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        return time.format(formatter);
    }
}

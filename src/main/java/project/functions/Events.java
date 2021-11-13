package project.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    public LocalDateTime eventTime;

    /**
     * The purpose of new task description is
     * Initializing the new task and mark the progress as incomplete.
     *
     * @param description event description
     */
    public Events(String description, LocalDateTime eventTime) {
        super(description);
        this.eventTime = eventTime;
    }

    /**
     * Return the deadline of the task
     *
     * @return String task description
     */
    @Override
    public String getTaskDescription() {
        return "[E]" + getTaskDescription() + " time at:" + dateFormat(eventTime);
    }

    /**
     * To convert date and time as string
     *
     * @param time the event data and time
     * @return String convert from other format to time format
     */
    public String dateFormat(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
        return time.format(formatter);
    }
}

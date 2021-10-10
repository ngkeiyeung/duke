package project.functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Events extends Task {
    public LocalDateTime eventTime;
    private String dateTimeFormat = "DD/MM/YYYY HHmm";

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
     * @param eventTime
     * @return String
     */
    public String dateToString(LocalDateTime eventTime) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        return eventTime.format(dateFormat);
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

    public String dateFormat(LocalDateTime dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm");
        return dateTime.format(formatter);
    }
}

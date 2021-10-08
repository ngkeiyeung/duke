package functions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadlines extends Task {
    public LocalDateTime timing;
    private String dateTimeFormat = "DD/MM/YYYY HHmm";

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
        return "[D]" + getTaskDescription();
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
     * @param timimg
     * @return String
     */
    public String dateToString(LocalDateTime timimg) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        return timing.format(dateFormat);
    }

}

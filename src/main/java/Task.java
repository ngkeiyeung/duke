

public class Task {
    public String description;
    public boolean isCompleted;
    /**
     * The purpose of new task description is
     *  Initializing the new task and mark the progress as incomplete.
     */
    public Task(String description) {
        this.description = description;
        this.isCompleted = false; //default is false
    }

    /**
     * Return the String type of task
     *
     * @return String       Return the task description
     */
    public String getTaskDescription(){
        return "[" + getTaskStatus() + "]" + this.description;
    }

    /**
     * Mark completed task as completed status
     *
      */
    public void markCompleted() { isCompleted = true; }

    /**
     * Return the task status
     *
     * @return String       Return the task status, Either "Yes" or "No"
     */
    public String getTaskStatus(){
        return (isCompleted ? "X" : " ");
    }
}

package project.functions;

public class Todos extends Task {

    /**
     * Creating a todolist from the input
     *
     * @param description tasks/ events
     */
    public Todos (String description) {
        super(description);
    }

    /**
     * return a status of the task
     *
     * @return String return the status of the todolist
     */
    @Override
    public String getTaskDescription() {
        return "[T]" + super.getTaskDescription();
    }

}

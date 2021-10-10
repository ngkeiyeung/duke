package functions;

import functions.Task;

public class Todos extends Task {

    /**
     * Creating a todolist from the inpute
     *
     * @param description
     */
    public Todos (String description) {
        super(description);
    }

    /**
     * return a status of the task
     *
     * @return String
     */
    @Override
    public String getTaskDescription() {
        return "[" + "T" + "]" + super.getTaskDescription();
    }

}

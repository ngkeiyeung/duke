public class Todos extends Task {

    public Todos (String description) {
        super(description);
    }

    @Override
    public String getTaskDescription() {
        return "[" + "T" + "]" + super.getTaskDescription();
    }

}

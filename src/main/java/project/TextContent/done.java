package TextContent;

public class done extends Duke {
    /**
     * Creates DoneCommand and initialise the isExit boolean value and description according to user input.
     *
     * @param isCompleted      The boolean value if the exit condition is true.
     * @param description The task description/command from user.
     */
    public done(boolean isCompleted, String description) {
        super(isCompleted, description);
    }

    /**
     * Marks the task as done, check the task number if empty prior marking it as done.
     *
     * @param taskList The array of tasks stored in as an ArrayList.
     * @param ui       The User Interface (UI) to handle the interaction with user.
     * @param storage  The storage to handle storing and reading of task from the file.
     * @throws DukeException To handle error and exception, if the user inputs an empty description.
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        int index = 0;
        if (description.substring(4).equals("")) {
            throw new DukeException("Which task is done?");
        }
        index = Integer.parseInt(description.substring(5)) - 1;
        (taskList.getATask(index)).setDone();
        ui.showOutputToUser(DONE_MSG + taskList.getATask(index).getDescription());
        storage.save();
    }
}

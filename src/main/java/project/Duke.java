package project;

import project.functions.Function;
import project.functions.TodoList;
import project.storage.Save;
import project.ui.Ui;
import project.parser.Parser;

public class Duke {
    private Ui ui;
    private Save save;
    private TodoList todoList;

    /**
     * main function to run the program
     *
     * @param args argument to provided by user to run the program
     */
    public static void main(String[] args) {
        new Duke("data/TodoList.txt").runningProgram();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

    }

    /**
     * Display the welcome message and create the duke text file
     * and initialize withe function, user interface and save files
     *
     * @param filepath storage file
     */
    public Duke(String filepath) {
        ui = new Ui();
        save = new Save(filepath);

        try {
            todoList = new TodoList(save.loadFile());
        } catch (Exception e) {
            ui.errorMsg(e.getMessage());
            todoList = new TodoList();
        }
    }

    /**
     *  running the programming and display the specific output
     */
    public void runningProgram() {
        ui.welcome();
        boolean isExit = false;

        while (isExit) {
            try {
                String programInput = ui.userManual();
                Function functionInput = Parser.Parser(programInput);
                functionInput.exe(todoList, ui, save);
                isExit = functionInput.isExit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * get user input
     *
     * @param input user input
     * @return String user input
     */
    public String getResponse(String input) {
        try {
            Function command = Parser.Parser(input);
            command.exe(todoList, ui, save);
            return ui.output();
        } catch (Exception e) {
            return ui.output();
        }
    }
}


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
    private boolean isExit = true;

    public static void main(String[] args) {
        new Duke("data/TodoList.txt").runningProgram();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

    }

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


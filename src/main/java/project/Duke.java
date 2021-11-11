package project;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
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

    private ScrollPane scrollPane;
    private VBox dialogContainer;
    private TextField userInput;
    private Button sendButton;
    private Scene scene;

    public static void main(String[] args) {
        new Duke("data/TodoList.txt").runningProgram();

        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Here is the command:"
                + "command '" + "add" + "' " + "to add new task\n"
                + "command '" + "event" + "' " + "to add new event\n"
                + "command '" + "deadline" + "' " + "to add new deadline\n"
                + "command '" + "done" + "' " + "to mark task or event as done\n"
                + "command '" + "delete" + "' " + "to delete the task or event\n"
                + "command '" + "find" + "' " + "to find the task or event\n"
                + "command '" + "event" + "' " + "to add new event\n"
                + "command '" + "sort" + "' " + "to sort the sort the deadlines chronologically\n"
                + "command '" + "bye" + "' " + "to exit the program\n");
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


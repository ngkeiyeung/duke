package project.parser;

import project.textContent.*;
import project.functions.Function;


public class Parser {
    public static Function Parser(String input) throws Exception {
        String command;
        String commandList = input.split(" ")[0];
        command = commandList.toLowerCase();

        switch(command){
            case "add" :
                return new Todo(false, input);
            case "event":
                return new Event(false, input);
            case "deadline" :
                return new Deadline(false, input);
            case "done":
                return new Completed(false, input);
            case "bye" :
                return new Exit(false, input);
            case "delete":
                return new Delete(false, input);
            case "find" :
                return new Find(false, input);
            case "list" :
                return new Lists(false, input);
            case "help":
                return new Help(false, input);
            default:
                throw new Exception("The command is invalid, please try again!\n"
                        + "command '" + "add" + "' " + "to add new task\n"
                        + "command '" + "event" + "' " + "to add new event\n"
                        + "command '" + "deadline" + "' " + "to add new deadline\n"
                        + "command '" + "done" + "' " + "to mark task or event as done\n"
                        + "command '" + "delete" + "' " + "to delete the task or event\n"
                        + "command '" + "find" + "' " + "to find the task or event\n"
                        + "command '" + "event" + "' " + "to add new event\n"
                        + "command '" + "Help" + "' " + "to view the help page\n"
                        + "command '" + "bye" + "' " + "to exit the program\n");
        }
    }
}

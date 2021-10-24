package project.parser;

import project.TextContent.*;
import project.functions.function;


public class parser {
    public static function Parser(String input) throws Exception {
        String command;
        String commandList = input.split(" ")[0];
        command = commandList.toLowerCase();

        switch(command){
            case "add" :
                return new todo(false, input);
            case "event":
                return new event(false, input);
            case "deadline" :
                return new deadline(false, input);
            case "done":
                return new completed(false, input);
            case "bye" :
                return new exit(false, input);
            case "delete":
                return new delete(false, input);
            case "find" :
                return new find(false, input);
            case "list" :
                return new list(false, input);
            case "sort":
                return new sort(false, input);
            default:
                throw new Exception("The command is invalid, please try again!\n"
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
    }
}

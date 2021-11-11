package project.ui;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.*;

public class Ui {

    private Scanner input;
    private String output;

    public static void welcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo);

        out.println("Here is the command:"
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

    public Ui(){
        this(System.in);
    }

    public Ui(InputStream input) {
        this.input = new Scanner(input);
    }

    /**
     *  Print bye bye message
     */
    public void byeBye() {
        out.println("Bye. Hope to see you again soon.");
    }

    /**
     * print error message
     * @param errorMessage
     */
    public String errorMsg(String errorMessage) {
        return errorMessage + "\n" + "Error!!!!\n"  + "Please try again\n";
    }

    public String output(){
        return this.output;
    }

    public void outputDisplay(String output) {
        this.output = output;
    }

    public static boolean checkInput(String input) {
        return input.trim().isEmpty();
    }

    public String userManual() {
        String manual = input.nextLine();
        while (checkInput(manual)) {
            manual = input.nextLine();
        }
        return manual;
    }
}

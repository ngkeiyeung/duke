package project.ui;

import java.io.InputStream;
import java.util.Scanner;

import static java.lang.System.*;

public class Ui {

    private Scanner input;
    private String output;

    /**
     * Shows welcome message
     *
     */
    public static void welcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        out.println("Hello from\n" + logo);

    }

    public Ui(){
        this(System.in);
    }

    /**
     * Represents a stream of the input, which is an abstract class
     *
     * @param input user input
     */
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
     *
     * @param errorMessage Error message
     */
    public String errorMsg(String errorMessage) {
        return errorMessage + "\n" + "Error!!!!\n"  + "Please try again\n";
    }

    /**
     * output message
     *
     * @return output message
     */
    public String output(){
        return this.output;
    }

    /**
     * Display output message
     *
     * @param output display the out message
     */
    public void outputDisplay(String output) {
        this.output = output;
    }

    /**
     * check the input, make sure the input is not empty
     *
     * @param input check input message
     * @return boolean true or false
     */
    public static boolean checkInput(String input) {
        return input.trim().isEmpty();
    }

    /**
     * to check the user input, and display specific functions
     *
     * @return String user input
     */
    public String userManual() {
        String manual = input.nextLine();
        while (checkInput(manual)) {
            manual = input.nextLine();
        }
        return manual;
    }

}

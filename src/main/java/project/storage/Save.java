package project.storage;

import project.functions.Deadlines;
import project.functions.Events;
import project.functions.Task;
import project.functions.TodoList;
import project.functions.Todos;
import project.exception.Exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Save {

    private static File file;
    private static Scanner scan;
    private static String filePath;
    private static final String empty = "";
    private static final String dateTimeFormat = "DD/MM/YYYY HHmm";

    /**
     * To create a text file if there is no historical data
     *
     * @param filePath the folder direction of the todolist.txt
     */
    public Save(String filePath){
        try{
            Save.filePath = filePath;
            file = new File(filePath);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            try{
                file.createNewFile();
                throw new IOException();
            } catch (IOException ioException) {
                System.out.println("Created failed, Please try again!");
            }
        }
    }

    /**
     * To define the status of the task completion
     *
     * @param status true or false.
     * @return boolean The status of the task completion
     */
    public boolean status(boolean status){
        return status;
    }

    /**
     * To get the date and time of task
     *
     * @param time The data dn time for each of task
     * @return String The day and time of the task
     */
    public String dateFormat(LocalDateTime time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        return time.format(dateFormat);
    }

    /**
     * To convert the time format as string format
     *
     * @return String the task date and time
     * @throws Exception when the input is not type of the data and time format such as DD/MM/YYYY HHmm
     */
    public LocalDateTime stringFormat(String date) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new Exception("The format of the date and time is not " + dateTimeFormat);
        }
    }

    /**
     * Save the todolist when interactive with user
     *
     */
    public void saveFile() {
        try{
            FileWriter fw = new FileWriter(filePath);
            int i = 0;

            while (i <TodoList.length()) {
                String inputCommand = null;
                String taskDate = null;

                Task task = TodoList.getList(i);

                if (task instanceof Todos) {
                    inputCommand = "T";
                } else {
                    if (task instanceof Events) {
                        inputCommand = "E";
                        taskDate = dateFormat(((Events) task).eventTime);
                    } else if (task instanceof Deadlines) {
                        inputCommand = "D";
                        taskDate = dateFormat(task.deadlineTime);
                    }
                }
                boolean b = status(task.isCompleted);
                int boolToInt = b ? 1 : 0;


                assert taskDate != null;
                if (taskDate.equals(empty)) {
                    fw.write(inputCommand
                            + " | "
                            + boolToInt
                            + " | "
                            + TodoList.getList(i).description
                            + "\n");
                } else {fw.write(inputCommand
                        + " | "
                        + boolToInt
                        + " | "
                        + TodoList.getList(i).description
                        + " | "
                        +taskDate
                        + "\n");
                }
                ++i;
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Save files failed, Please try again later.");
        }

    }

    /**
     * To check the existing todolist text file
     *
     * @param filePath Check if there are files in the storage folder
     * @return boolean if it is false,will create a new file
     */
    public static boolean checkFileExists(File filePath){
        return filePath.isFile() || filePath.exists() || filePath.length() > 0;
    }

    /**
     * To load the todolist.txt from storage folder
     *
     * @return ArrayList todolist as Array format
     * @throws Exception if there is no existing file inside the storage folder
     */
    public ArrayList<Task> loadFile() throws Exception {
        ArrayList<Task> taskArrayList = new ArrayList<>();
        if(!checkFileExists(file)) {
            return taskArrayList;
        }

        while(scan.hasNext()){
            String taskLine = scan.nextLine();
            String[] args = taskLine.split(" \\| ");

            String taskType = args[0];
            String check = args[1];
            String des = args[2];
            String checkDate = args[3];

            switch (taskType){
                case "T":
                    Todos updateTodo= new Todos(des);
                    if(check.equals("1")) {updateTodo.markCompleted();}
                    taskArrayList.add(updateTodo);
                    break;

                case "D":
                    Deadlines updateDeadlines= new Deadlines(des, stringFormat(checkDate));
                    if(check.equals("1")) {updateDeadlines.markCompleted();}
                    taskArrayList.add(updateDeadlines);
                    break;

                case "E":
                    Events updateEvent= new Events(des, stringFormat(checkDate));
                    if(check.equals("1")) {updateEvent.markCompleted();}
                    taskArrayList.add(updateEvent);
                    break;
            }
        }
        return taskArrayList;
    }
}

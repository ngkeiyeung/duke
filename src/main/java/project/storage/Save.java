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
    private static String empty = "";
    private static String dateTimeFormat = "DD/MM/YYYY HHmm";

    public Save(String filePath){
        try{
            this.filePath = filePath;
            this.file = new File(filePath);
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

    public boolean status(boolean status){
        boolean isDone = status;
        if (isDone) {
            return true;
        } else {
            return false;
        }
    }

    public String dateFormat(LocalDateTime time) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(dateTimeFormat);
        return time.format(dateFormat);
    }

    public LocalDateTime stringFormat(String date) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
            return LocalDateTime.parse(date, formatter);
        } catch (DateTimeParseException e) {
            throw new Exception("The format of the date and time is not " + dateTimeFormat);
        }
    }


    public void saveFile() throws Exception {
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
                        taskDate = dateFormat(((Deadlines) task).deadlineTime);
                    }
                }
                boolean b = status(task.isCompleted);
                int boolToInt = b ? 1 : 0;


                if (taskDate.equals(empty)) {
                    fw.write(inputCommand
                            + " | "
                            + Integer.toString(boolToInt)
                            + " | "
                            + TodoList.getList(i).description
                            + "\n");
                } else {fw.write(inputCommand
                        + " | "
                        + Integer.toString(boolToInt)
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

    public static boolean checkFileExists(File filePath){
        if (filePath.isFile() || filePath.exists() || filePath.length()>0){
            return true;
        } else { return false;}
    }

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

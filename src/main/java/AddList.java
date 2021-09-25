import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddList {
    public static String[] addList = new String[100];
    public static int number = 0;

    String line = "    ____________________________________________________________\n";

    public void welcome(){
        System.out.println(line + "     Hello! I'm Duke\n" +  "     What can I do for you?\n" + line);
    }

    public void goodbye(){
        System.out.println(line + "    Bye. Hope to see you again soon!\n" + line);
    }

    public void printOutput(String input){

        System.out.println(line + "    " + "added: " + input + "\n" + line);
    }

    public void StoreList(String list){
        this.addList[number] = list;
        this.number++;
    }

    public void NumberExtra(String s){
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        System.out.println(m.replaceAll("").trim());
        //return extra;
    }

    public boolean XCompleted (){
        return true;
    }


    public void PrintList (String markDone) {
        String done = " ";

        System.out.print(line);
        if(number > 0) {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < number; i++) {
                System.out.print("    " + (i+1) + "." + "[");
                System.out.println(done + "]" +addList[i]);
            }
        } else {
            System.out.println("    " + "The list is empty!");
        }
        System.out.println(line);
    }

    public void IsDone (){
        System.out.println(line);
        int index = Integer.parseInt(line.split(" ")[1]);
        done(index -p 1);
    }

    public void done() {
        this.completed = true;
    }

    public void MarkDone (int seq) {

        String done = " ";

        System.out.println(line);
        if(seq > 0 && seq > number) {
            System.out.println("    " + "Nice! I've marked this task as done:");
            System.out.println("    " + seq + "." + "[" + "X" + "]" +addList[seq]);
        } else {
            System.out.println("    " + "The list is empty, please add your task!");
        }
    }

}


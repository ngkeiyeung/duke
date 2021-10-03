import java.util.Scanner;

public class Task {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // Welcome message
        AddList welcome = new AddList();
        welcome.welcome();

        // Goodbye message
        AddList goodBye = new AddList();

        //create input
        String input;
        String pattern = "(^done)(\\s)(\\d+$*)";

        AddList addList = new AddList();

        while (true){
            input = in.nextLine();

            if (input.equals("bye")) {
                goodBye.goodbye();
                break;
            } else if (input.equals("list")) {
                addList.PrintList(input);
            } else if (input.matches(pattern)){
                addList.NumberExtra(pattern);
                //int taskNumber = Integer.parseInt(seq);
                addList.MarkDone(1);
            }

            if (!input.equals("list") && !input.matches(pattern)){
                addList.StoreList(input);
                addList.printOutput(input);
            }
        }

    }
}

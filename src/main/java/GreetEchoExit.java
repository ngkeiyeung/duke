import java.util.Scanner;

public class GreetEchoExit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        // Welcome message
        AddList welcome = new AddList();
        welcome.welcome();

        // Goodbye message
        AddList goodBye = new AddList();

        //create input
        String input;

        AddList addList = new AddList();

        while (true){
            input = in.nextLine();

            if (input.equals("bye")) {
                goodBye.goodbye();
                break;
            } else if (input.equals("list")) {
                addList.PrintList();
            }

            if (!input.equals("list")){
                addList.StoreList(input);
                addList.printOutput(input);
            }
        }

    }
}

import java.util.Scanner;

public class GreetEchoExit {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        System.out.println("    ____________________________________________________________\n" +
                "     Hello! I'm Duke\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________\n");
        String input;
        do{
            input = in.nextLine();
            System.out.println("    ____________________________________________________________\n" +
                    "    " + input + "\n" +
                    "    ____________________________________________________________");
        }while(!input.equals("bye"));{
            System.out.println("    ____________________________________________________________\n" +
                "    Bye. Hope to see you again soon!\n" +
                "    ____________________________________________________________\n");
            }
        }
}

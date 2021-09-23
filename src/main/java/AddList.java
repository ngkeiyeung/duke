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
        //System.out.println("added: " + list);
    }

    public void PrintList () {
        System.out.println(line);
        for (int i = 0; i < number; i++){
            System.out.println("    " + (i+1) + ". " + addList[i]);
        }
        System.out.println(line);

    }
}


package part3.ToDoListApplication.Utilities;

import java.util.Scanner;

public class UtilitiesDiStampa {

    public void stampaTitolo(){
        System.out.println("--------------");
        System.out.println("---ToDoList---");
        System.out.println("--------------");
    }
    public void stampaMenu(String[]opzioni){
        for(int i = 0; i < opzioni.length; i++){
            System.out.println(i + 1 + "." + opzioni[i]);
        }
    }
    public void spazio(){
        System.out.println("");
    }
    public void display(String printLine){ System.out.println(printLine);}

    public static void displayy( String msg ){
        System.out.println( msg );
    }
    public String Scan() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}

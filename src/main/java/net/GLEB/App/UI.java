package net.GLEB.App;
import java.util.Scanner;

//UI - class working with console

public class UI {
    private final Scanner in;

    public UI(){
        in = new Scanner(System.in);
    }

    //method for reading something from console

    public String readField(String fieldName){
        System.out.print("Введите значение поля "+fieldName+": ");
        return in.nextLine().toUpperCase();
    }

    // Method for reading line with command

    public String getNextCommand(){
        System.out.print(">> ");
        return in.nextLine();
    }

    //Method for printing something to console

    public void print(String string){
        System.out.println(string);
    }

}
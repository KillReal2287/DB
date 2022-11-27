package Homework12;

import java.util.Scanner;

public class Parent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List list = new List();
        String str = "";
        Thread child = new Thread(new Child(list));
        child.start();
        while (true){
            str = scanner.nextLine();
            if (str.equals("")){
                list.display();
            }
            else{
                list.insertFirst(str);
            }
        }
    }
}

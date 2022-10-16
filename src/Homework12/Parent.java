package Homework12;

import java.util.Scanner;

public class Parent {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Scanner scanner = new Scanner(System.in);
        String str;
        Thread thread = new Thread(new Child(parent));
        thread.start();
        while(true){
            str = scanner.nextLine();
            if(str.equals("")){
                System.out.println(Child.list);
            }
            else {
                    Child.list.addFirst(str);
            }
        }
    }
}

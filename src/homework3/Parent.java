package homework3;

import java.util.ArrayList;
import java.util.Arrays;

public class Parent {
    public static void main(String[] args) {
        ArrayList<Child> childs = new ArrayList<>();
        Child child1 = new Child("Antonio");
        Child child2 = new Child("Margaretti");
        Child child3 = new Child("Dominic");
        Child child4 = new Child("Decoco");
        childs.addAll(Arrays.asList(child1,child2,child3,child4));
        for (Child child: childs) {
            Thread thread = new Thread(child);
            thread.start();
        }

    }

    static synchronized void writer(String str){
        System.out.println(str);
    }
}

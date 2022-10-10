package howework2;

public class Parent {

    public static void main(String[] args) {

        Child t1 = new Child();
        try {
            t1.getThread().join();
        } catch (InterruptedException e) {
            System.out.println("Error.");
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello world from parent");
        }
    }
}

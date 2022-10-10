package howework1;
public class Parent {
    public static void main(String[] args) {
        Thread t = new Thread(new Child());
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello world from parent");
        }

    }
}

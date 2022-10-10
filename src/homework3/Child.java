package homework3;

public class Child implements Runnable {
    String str;
    Child(String str){
        this.str = str;
    }
    @Override
    public void run() {
        Parent.writer(str);
    }
}

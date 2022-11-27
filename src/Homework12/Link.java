package Homework12;

public class Link {
    Link next;
    String value;

    public Link(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

package Homework12;


public class List {

    Link first;
    int nElems;

    public List() {
        this.first = null;
        nElems = 0;
    }

    public void insertFirst(String value){
            Link item = new Link(value);
            if (first == null){
                first = item;
            }
            else{
                synchronized (first){
                    item.next = first;
                    first = item;
                }
            }
            nElems++;
    }

    public void display(){
            Link current;
            if (first != null) {
                synchronized (first){
                    current = first;
                    while (current != null){
                        System.out.println(current);
                        current = current.next;
                    }
                }
            } else {
                System.out.println("list is empty");
            }
    }

    public void sorter(){
        Link current;
        if (first != null) {
            synchronized (first) {
                current = first;
                for (int out = nElems -1; out>1; out--){
                    for (int in = 0; in<out; in++){
                        if (current.value.compareTo(current.next.value) > 0){
                            String tmp = current.value;
                            current.value = current.next.value;
                            current.next.value = tmp;
                        }
                        current = current.next;
                    }
                    current = first;
                }
            }
        } else {
            System.out.println("nothing to sort");
        }
    }


}

package linkedlist;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList ll = new LinkedList(15);
        ll.append(100);
        ll.prepend(50);
        ll.getHead();
        ll.getTail();
        ll.getLength();
        ll.printList();
    }
}

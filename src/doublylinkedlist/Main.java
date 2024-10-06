package doublylinkedlist;

public class Main {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList dll = new DoublyLinkedList(10);
        dll.getHead();
        dll.getTail();
        dll.getLength();

        dll.append(4);
        dll.prepend(10);
        dll.printList();
    }
}

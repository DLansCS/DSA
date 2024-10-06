package queue;

/*
QUEUE TIP

Enqueue (insert at back): If you maintain a pointer to the tail of the linked list,
adding an element to the back can be done in constant time.

Dequeue (remove from front): Removing an element from the front (head) is also O(1)
since you simply adjust the head pointer to the next node.

If you were to enqueue at the front and dequeue from the back, you would generally need to traverse
the entire list to find the last node, which results in O(n) time for enqueue operations.
Thus, the typical approach for a queue using a linked list is to enqueue at the tail and dequeue from the head.

 */

import stack.Stack;

public class Queue {
    private Node first;
    private Node last;
    int length;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }

    public Queue(int value){
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue(){
        Node temp = first;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getLength(){
        System.out.println("Length: " + length);
    }

    public void getFirst(){
        System.out.println("first: " + first.value);
    }

    public void getLast(){
        System.out.println("last: " + last.value);
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            first = newNode;
            last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if(length == 0){
            return null;
        }
        Node temp = first;
        if (length == 1){
            first = null;
            last = null;
        }else{
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }
}

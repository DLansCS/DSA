package stack.stackwithlinkedlist;
/*
STACK NOTES
Pushing to the top (head) allows for efficient O(1) time complexity for both push and pop operations,
since you only need to adjust a few pointers. Popping an element also removes it from the head, maintaining
the LIFO (Last In, First Out) behavior of the stack.

Pushing from the bottom would complicate the operations and could lead to O(n) time complexity,
as you'd have to traverse the entire list to add an element at the bottom.
*/
public class Stack {
    private Node top;
    private int height;

    class Node{
        int value;
        Node next;

        Node(int value){
            this.value=value;
        }
    }

    public Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height=1;
    }

    // Time: O(n) -  Space O(1)
    public void printStack(){
        Node current = top;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    // Time: O(1) -  Space O(1)
    public void getTop(){
        System.out.println("Top: " + top.value);
    }

    // Time: O(1) -  Space O(1)
    public void getHeight(){
        System.out.println("Height: " + height);
    }

    // Time: O(1) -  Space O(1)
    public void push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    // Time: O(1) -  Space O(1)
    public Node pop(){
        if(height == 0){
            return null;
        }
        Node temp = top;
        top = top.next;
        temp.next = null;

        height--;
        return temp;
    }


}

package doublylinkedlist;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public class Node {
        int value;
        Node next;
        Node prev;
     
        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    // DoubleyLinkedList constructor - new updated
    public DoublyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        length = 1;
    }

    // Time O(n) - Space O(1)
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    // Time O(1) - Space O(1)
    public void getHead(){
        System.out.println("Head: " + head.value);
    }

    // Time O(1) - Space O(1)
    public void getTail(){
        System.out.println("Tail: " + tail.value);
    }

    // Time O(1) - Space O(1)
    public void getLength(){
        System.out.println("Length: " + length);
    }

    // Time O(1) - Space O(1)
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
        length++;
    }
    // Time O(1) because tail is accessible - Space O(1)
    public Node removeLast(){
        if(length == 0){
            return null;
        }
        Node temp = tail;
        if(length == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length--;
        return temp;
    }

    // Time O(1) - Space O(1)
    public void prepend(int value){
	    Node newNode = new Node(value);
	    if(length == 0){
	        head = newNode;
	        tail = newNode;
	    }else{
	        head.prev = newNode;
	        newNode.next = head;
	        head = newNode;
	    }
	    length++;
	}

    // Time O(n) - Space O(1)
    public Node removeFirst(){
	    if(length == 0){
	        return null;
	    }
	    Node temp = head;
	    if(length == 1){
	        head = null;
	        tail = null;
	    }else{
	        head = head.next;
	        head.prev = null;
	        temp.next = null;
        }
	    length--;
	    return temp;
	}
    // Time O(n) - Space O(1)
    public Node get(int index){
	    if(index < 0 || index >= length){
	        return null;
	    }
	    Node temp = head;
	    if(index < length / 2){
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }	    
	    }else{
	        temp = tail;
	        for(int i = length-1; i > index; i--){
                temp = temp.prev;
            }	  
	    }
        return temp;
	}

    // Time O(n) - Space O(1)
    public boolean set(int index, int value){
	    Node temp = get(index);
	    if(temp != null){
	        temp.value = value;
	        return true;
	    }
	    return false;
    }

    // Time O(n) - Space O(1)
	public boolean insert(int index, int value){
	    if(index < 0 || index > length){ 
	        return false;
	    }
	    if(index == 0){
	        prepend(value);
	        return true;
	    }
	    if(index == length){
	        append(value);
	        return true;
	    }
	    Node newNode = new Node(value);
	    Node before = get(index-1);
	    Node after = before.next;
	    newNode.prev = before;
	    newNode.next = after;
	    before.next = newNode;
	    after.prev = newNode;
	    length++;
	    return true;
	}

    // Time O(n) - Space O(1)
    public Node remove(int index){
	    if(index < 0 || index >= length){
	        return null;
	    }
	    if(index == 0){
	        return removeFirst();
	    }
	    if(index == length-1){
	        return removeLast();
	    }
	    Node temp = get(index);
	    Node before = temp.prev;
	    Node after = temp.next;
	    before.next = after;
	    after.prev = temp;
	    temp.prev = null;
	    temp.next = null;
	    length--;
	    return temp;
	    /*
	    can also work with 
        Node temp = get(index);
	    temp.next.prev = temp.prev;
	    temp.prev.next = temp.next;
	    temp.next = null;
	    temp.prev = null;
	    length--;
	    return temp;
	    */
	}

    // Time O(1) - Space O(1)
    public void swapFirstLast(){
	    if(length < 2) return;
	    
	    int temp = head.value;
	    head.value = tail.value;
	    tail.value = temp;
	}

    // Time O(n) - Space O(1)
    public void reverse() {
	    
        Node current = head;
        Node temp = null;
     
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;         
            current = current.prev;
        }
        temp = head;
        head = tail;
        tail = temp;
        }

    // Time O(n) - Space O(1)
    public boolean isPalindrome(){
        if (length <= 1) return true;
        
        Node forwardNode = head;
        Node backwardNode = tail;
        for (int i = 0; i < length / 2; i++) {
            if (forwardNode.value != backwardNode.value) return false;
            forwardNode = forwardNode.next;
            backwardNode = backwardNode.prev;
        }
        return true;
    }
    
    // Time O(n) - Space O(1)
    public void swapPairs() {
    Node dummyNode = new Node(0);
    dummyNode.next = head;
    Node previousNode = dummyNode;

    while (head != null && head.next != null) {
        Node firstNode = head;
        Node secondNode = head.next;

        previousNode.next = secondNode;
        firstNode.next = secondNode.next;
        secondNode.next = firstNode;

        secondNode.prev = previousNode;
        firstNode.prev = secondNode;
        
        if (firstNode.next != null) {
            firstNode.next.prev = firstNode;
        }

        head = firstNode.next;
        previousNode = firstNode;
    }

    head = dummyNode.next;
    if (head != null) head.prev = null;
    }
}

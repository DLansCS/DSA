package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {
    
    private Node head;
    private Node tail;
    private int length;
     
    public class Node {
        int value;
        Node next;
     
        Node(int value) {
            this.value = value;
        }
    }
    
    LinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length=1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    // Time: O(1) because tail is tracked - Space O(1)
    public void append(int value){
	    Node newNode = new Node(value);
	    if(length == 0){
	        head = newNode;
	        tail = newNode;
	    }else{
	        tail.next = newNode;
	        tail = newNode;
	    }
	    length++;
    }
    // Time: O(1) -  Space O(1)
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length==0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    // Time: O(n) -  Space O(1)
    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
            for(int i = 0; i < index; i++){
                temp = temp.next;
            }
        return temp;
    }
    // Time: O(n) -  Space O(1)
    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }
    // Time: O(n) -  Space O(1)
    public Node findMiddleNode(){
	    
	    Node fast = head;
	    Node slow = head;
	    
	    while(fast != null && fast.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    return slow;
	    
	}
    // Time: O(n) -  Space O(1)
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
       Node temp = get(index-1);
       newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }
    // Time: O(1) -  Space O(1)
    public Node removeFirst(){
        if(length==0){
            return null;
        }
        Node temp = head;
        head = head.next;
        // removes reference from first node to second node
        temp.next = null;
        length--;
        if(length==0){
            tail = null;
        }
        return temp;
    }

    // Time: O(n) -  Space O(1)
    public Node removeLast(){

        if(length == 0){
            return null;
        }
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp=temp.next;
        }
        tail = pre;
        tail.next=null;
        length--;
        if(length==0){
            head = null;
            tail = null;
        }
        return temp;
    }

    // Time: O(1) -  Space O(1)
    public Node remove(int index){
        if(index < 0 || index >= length){
            return null;
        }
        if(index == 0){
            return removeFirst();
        }
        if(index == length - 1){
            return removeLast();
        }
        Node pre = get(index-1);
        Node temp = pre.next;

        pre.next=temp.next;
        temp.next=null;
        length--;
        return temp;
    }

    // Time: O(n) -  Space O(1)
    public void reverse(){
        Node current = head;
        head = tail;
        tail = current;
        Node after = current.next;
        Node before = null;
        for(int i = 0; i < length; i++){
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }
    }

    // Time: O(n) -  Space O(1)
    public boolean hasLoop(){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            if(fast.next == slow){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    // Time: O(n) -  Space O(1)
    public void printList() {
        System.out.println("");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Time: O(n) -  Space O(1)
    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    // Time: O(n) -  Space O(1)
    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;
     
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
     
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
     
        return slow;
        }
    
        // Time: O(n) -  Space O(1)
    public void partitionList(int x) {
        if (head == null) return;

            Node dummy1 = new Node(0);
            Node dummy2 = new Node(0);

            Node prev1 = dummy1;
            Node prev2 = dummy2;
         
            Node current = head;
         
        while (current != null) {
         
            if (current.value < x) {
                    prev1.next = current;
                    prev1 = current; 
            } else {
                    prev2.next = current;
                    prev2 = current;   
            }
            current = current.next;
            }

            prev2.next = null;
            prev1.next = dummy2.next;
            head = dummy1.next;
        }

    // Time: O(n) -  Space O(n)
    public void removeDuplicates() {
        Set<Integer> s = new HashSet<>();
        Node previous = null;
        Node temp = head;
        while (temp != null) {
            if (s.contains(temp.value)) {
                previous.next = temp.next;
                length -= 1;        
            } else {
                s.add(temp.value);
                previous = temp;
            }
            temp = temp.next;
        }
    }

    // Time: O(n) -  Space O(1)
    public int binaryToDecimal(){
        int num = 0;
        Node temp = head;
        while(temp != null){
            num = num * 2 + temp.value;
            temp=temp.next;
        }
        return num;
    }

    // Time: O(n) -  Space O(1)
    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;
    
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }
                Node currentNode = previousNode.next;
        
        // endIndex = 5. Start Index = 2. I will run until i is no longer < 3 IE loops runs three times
        // 0 -> 1 -> (2) -> 3 -> 4 -> (5) -> 6 ->7
        //     pN     c    nTM
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }
        head = dummyNode.next;
    }

    // Time: O(n + m) -  Space O(1)
    public Node mergeTwoLists(Node list1, Node list2) {

        Node dummy = new Node(0);
        Node current = dummy;

        while(list1 != null && list2 != null){
            if(list1.value > list2.value){
                current.next = list2;
                list2 = list2.next;
            }else{
                current.next = list1;
                list1 = list1.next;  
            }
            current = current.next;
        }
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }

    // Time: O(n + m) -  Space O(1)
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;
        
        Node a = headA;
        Node b = headB;
        
        while (a != b) {
            a = (a == null) ? headB : a.next;
            b = (b == null) ? headA : b.next;    
        }
        return a;
    }
    // 0 -> 1 -> (2) -> 3 -> 4 -> (5) -> 6 ->7
    // pN   c    sN
    // Time: O(n) -  Space O(1)
    public Node swapPairs() {
        Node dummy = new Node(0);
        dummy.next = head;
        Node previousNode = dummy;
        Node current = head;
            
        while(current != null && current.next != null){
            Node secondNode = current.next;
            current.next = secondNode.next;
            previousNode.next = secondNode;
            secondNode.next = current;
            previousNode = current;
            current = current.next;
            }
            return dummy.next;
        }
    

}


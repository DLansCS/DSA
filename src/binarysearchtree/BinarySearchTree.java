package binarysearchtree;

// Perfect Tree (balanced) - Time: O(log (n)) -  Space O(1)
// Worst case (unbalanced) - Time O(n) - Space O(1)
public class BinarySearchTree {
    Node root;

    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value=value;
        }
    }

    //Worst Time O(n) - Space O(1)
    //Best Time O(log(n)) - Space O(1)
    public boolean insert(int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true) {
            if(newNode.value == temp.value){
                return false;
            }
            if (newNode.value < temp.value) {
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    //Worst Time O(n) - Space O(1)
    //Best Time O(log(n)) - Space O(1)
    public boolean contains(int value){
        Node temp = root;
        while(temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            }else if (value > temp.value){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;
    }

    //Time O(log (n)) - Space O(1)
    public void lookup(){

    }

    //Time O(log(n)) - Space O(1)
    public void remove(){

    }
}

package stack;

import stack.stackarraylist.StackArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Stack myStack = new Stack(5);

        System.out.println();

        myStack.getTop();
        myStack.getHeight();

        myStack.push(10);
        myStack.printStack();

        System.out.println("Popped value: "+myStack.pop().value);
        myStack.printStack();
    }
}

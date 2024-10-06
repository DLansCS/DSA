package stack.stackarraylist;

import java.util.ArrayList;

public class StackArrayList<T> {

    private final ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T value) {
        stackList.add(value);
    }

    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }

    public String reverseString(String string) {
        // Create a new stack of characters.
        StackArrayList<Character> stack = new StackArrayList<>();
        // Create an empty string for the reversed characters.
        String reversedString = "";

        // Loop through each character in the original string and push it onto the stack.
        for (char c : string.toCharArray()) {
            stack.push(c);
        }

        // Pop each character off the stack and add it to the reversed string.
        // This will reverse the order of the characters in the original string.
        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        // Return the reversed string.
        return reversedString;
    }


    public boolean isBalancedParentheses(String parentheses) {
        StackArrayList<Character> stack = new StackArrayList<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public  void sortStack(StackArrayList<Integer> stack) {
        StackArrayList<Integer> additionalStack = new StackArrayList<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!additionalStack.isEmpty() && additionalStack.peek() > temp) {
                stack.push(additionalStack.pop());
            }

            additionalStack.push(temp);
        }

        while (!additionalStack.isEmpty()) {
            stack.push(additionalStack.pop());
        }
    }



}

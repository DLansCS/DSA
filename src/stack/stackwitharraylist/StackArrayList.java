package stack.stackwitharraylist;

import java.util.ArrayList;

public class StackArrayList<T> {

    private final ArrayList<T> stackList = new ArrayList<>();

    // Time: O(1) -  Space O(1)
    public ArrayList<T> getStackList() {
        return stackList;
    }

    // Time: O(n) -  Space O(1)
    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    // Time: O(1) -  Space O(1)
    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    // Time: O(1) -  Space O(1)
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    // Time: O(1) -  Space O(1)
    public int size() {
        return stackList.size();
    }

    // Time: O(1) amortised -  Space O(1)
    public void push(T value) {
        stackList.add(value);
    }

    // Time: O(1) amortised -  Space O(1)
    public T pop() {
        if (isEmpty()) return null;
        return stackList.remove(stackList.size() - 1);
    }

    // Time: O(n) -  Space O(n)
    public String reverseString(String string) {
        StackArrayList<Character> stack = new StackArrayList<>();
        String reversedString = "";

        for (char c : string.toCharArray()) {
            stack.push(c);
        }

        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }
        return reversedString;
    }


    // Time: O(n) -  Space O(n)
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

    // Time: O(n^2) -  Space O(n)
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

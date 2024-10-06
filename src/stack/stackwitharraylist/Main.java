package stack.stackwitharraylist;

public class Main {
    public static void main(String[] args) throws Exception {
        StackArrayList<Character> stackArrayList = new StackArrayList<>();

        System.out.println(stackArrayList.reverseString("Hello"));
        System.out.println(stackArrayList.isBalancedParentheses("((()))"));
        System.out.println();
    }
}

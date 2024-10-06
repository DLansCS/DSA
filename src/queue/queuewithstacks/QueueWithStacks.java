package queue.queuewithstacks;
import java.util.Stack;

    public class QueueWithStacks {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public QueueWithStacks() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        // Time: O(n) -  Space O(n)
        public void enqueue(int value) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(value);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        // Time: O(1) -  Space O(1)
        public Integer dequeue(){
            if(stack1.isEmpty()){
                return null;

            }
            return stack1.pop();
        }

        // Time: O(1) -  Space O(1)
        public int peek() {
            return stack1.peek();
        }

        // Time: O(1) -  Space O(1)
        public boolean isEmpty() {
            return stack1.isEmpty();
        }
    }

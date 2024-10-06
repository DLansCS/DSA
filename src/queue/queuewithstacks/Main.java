package queue.queuewithstacks;

public class Main {
    public static void main(String[] args) throws Exception {
        QueueWithStacks myQueue = new QueueWithStacks();

        myQueue.enqueue(5);
        myQueue.enqueue(10);
        myQueue.enqueue(200);

        myQueue.dequeue();
        myQueue.isEmpty();
    }
}

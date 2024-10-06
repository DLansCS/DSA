package queue;

public class Main {
    public static void main(String[] args) throws Exception {
        Queue myQueue = new Queue(5);

        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();

        myQueue.printQueue();
    }
}

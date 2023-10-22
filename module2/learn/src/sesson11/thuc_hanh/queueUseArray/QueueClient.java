package sesson11.thuc_hanh.queueUseArray;

public class QueueClient {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.display();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.display();
        queue.display();
    }
}

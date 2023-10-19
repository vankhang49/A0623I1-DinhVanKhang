package sesson11.bai_tap.deploymentQueue;

public class TestQueue {
    public static void main(String[] args) {
        Solution queue = new Solution();
        queue.enQueue(1);
        queue.enQueue(1);
        queue.enQueue(1);
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);
        queue.enQueue(7);
        queue.enQueue(8);
        queue.displayQueue();
    }
}

package sesson11.thuc_hanh.queueUseArray;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int head;
    private int tail;
    private int currentSize;
    public MyQueue(){
        this.capacity = 0;
        this.head = 0;
        this.tail = -1;
        this.currentSize = 0;
        this.queueArr = new int[this.capacity];
    }
    public MyQueue(int queueSize){
        this.capacity = queueSize;
        this.head = 0;
        this.tail = -1;
        this.currentSize = 0;
        this.queueArr = new int[this.capacity];
    }
    public boolean isQueueFull(){
        return this.currentSize == this.capacity;
    }
    public boolean isQueueEmpty(){
        return this.currentSize == 0;
    }
    public void enQueue(int item){
        if (isQueueFull()){
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            tail++;
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }
    public void deQueue(){
        if(isQueueEmpty()){
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            if(head == (capacity-1)){
                System.out.println("Pop operation done ! removed: " + queueArr[head]);
                queueArr[head] = 0;
            } else {
                System.out.println("Pop operation done ! removed: " + queueArr[head]);
                pop();
            }
            currentSize--;
        }
    }
    public void pop(){
       for(int i = 0; i<capacity-1; i++){
           queueArr[i] = queueArr[i+1];
           queueArr[i+1] = 0;
       }
    }
    public void display(){
        for(int i = 0; i<capacity; i++){
            System.out.print(queueArr[i] + " ");
        }
    }
}

package sesson11.bai_tap.deploymentQueue;

public class Solution {
    public Queue queue;
    public Solution() {
        queue = new Queue();
    }
    public void enQueue(int in){
        Node temp = new Node(in);
        if(queue.front == null){
            queue.front = queue.rear = temp;
        } else {
            queue.rear.link = temp;
            queue.rear = temp;
            queue.rear.link = queue.front;
        }
        queue.size++;
    }
    public Node deQueue(){
        if(queue.front == null){
            queue.size = 0;
            return null;
        } else{
            Node temp = queue.front;
            if(queue.front == queue.rear){
                queue.front = queue.rear = null;
            } else {
                queue.front = queue.front.link;
                queue.rear.link = queue.front;
            }
            queue.size--;
            return temp;
        }
    }
    public void displayQueue(){
        int size = queue.size;
        Node temp = queue.front;
        for (int i = 0; i < size; i++){
            System.out.print(temp.data + " ");
            temp = temp.link;
        }
    }
}

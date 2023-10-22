package sesson11.thuc_hanh.stackUseArray;

public class MyStack {
    private int[] arr;
    private int size;
    private int index;
    public MyStack(){
        this.size = 0;
        this.index = -1;
        this.arr = new int[size];
    }
    public MyStack(int size){
        this.size = size;
        this.index = -1;
        this.arr = new int[size];
    }
    public void push(int element){
        if(isFull()){
            throw new StackOverflowError("Stack is full");
        }
        index++;
        arr[index] = element;
    }
    public int pop() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is null");
        }
        int temp = arr[index];
        arr[index] = 0;
        index--;
        return temp;
    }
    public int size(){
        return index + 1;
    }
    public boolean isFull(){
        return this.index == this.size;
    }
    public boolean isEmpty(){
        return this.index == -1;
    }
    public void displayStack(){
        for (int  i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
}

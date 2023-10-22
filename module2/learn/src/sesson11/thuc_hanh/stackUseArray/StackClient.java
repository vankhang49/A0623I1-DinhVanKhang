package sesson11.thuc_hanh.stackUseArray;

public class StackClient {
    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.displayStack();
        System.out.println("Pop element: " +stack.pop());
        System.out.println("Pop element: " +stack.pop());
        System.out.println("Pop element: " +stack.pop());
        System.out.println("Pop element: " +stack.pop());
        System.out.println("Pop element: " +stack.pop());
        stack.displayStack();
    }
}

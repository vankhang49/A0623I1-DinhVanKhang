package sesson10.bai_tap.linkedList;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(13);
        linkedList.printList();
        System.out.println("\n");
        linkedList.add(3,10);
        linkedList.add(4,9);
        linkedList.printList();
        System.out.println("\n");
        System.out.println("---------------");
        System.out.println("---------------");
        System.out.println("---------------");
        linkedList.addLast(8);
        linkedList.printList();
        System.out.println("\n");
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.contain(9));
        System.out.println(linkedList.add(8));
        System.out.println("---------------");
        MyLinkedList<Integer> linkedList1 = linkedList.clone();
        linkedList1.printList();
        System.out.println("\n");
        System.out.println("---------------");
        linkedList.clear();
        linkedList.printList();
    }
}

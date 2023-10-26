package sesson12.bai_tap.postorder;

public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree intTree = new BinarySearchTree();
        intTree.insert(4);
        intTree.insert(3);
        intTree.insert(2);
        intTree.insert(1);
        intTree.insert(5);
        intTree.insert(6);
        intTree.insert(7);
        System.out.println("Browse the tree in order postorder");
        intTree.postorder();
        System.out.println();
        System.out.println(intTree.containKey(2));
        System.out.println(intTree.containKey(8));
    }
}

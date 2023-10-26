package sesson12.bai_tap.preorder;

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
        System.out.println("Browse the tree in order preorder");
        intTree.preorder();
        System.out.println("Delete element");
        intTree.delete(5);
        intTree.preorder();
    }
}

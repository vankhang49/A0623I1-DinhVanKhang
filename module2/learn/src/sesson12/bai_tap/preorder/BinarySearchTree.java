package sesson12.bai_tap.preorder;

public class BinarySearchTree {
    protected TreeNode<Integer> root;
    protected int size;
    public BinarySearchTree(){
    }
    protected TreeNode<Integer> create(int e) {
        return new TreeNode<>(e);
    }
    public boolean insert(Integer e){
        if (root == null){
            root = create(e);
        } else {
            TreeNode<Integer> parent = null;
            TreeNode<Integer> current = root;
            while (current != null){
                if (e.compareTo(current.element)<0){
                    parent = current;
                    current = current.left;
                } else if(e.compareTo(current.element)>0){
                    parent = current;
                    current = current.right;
                }else {
                    return false;
                }
            }
            if (e.compareTo(parent.element)<0){
                parent.left = create(e);
            } else {
                parent.right = create(e);
            }
        }
        size++;
        return true;
    }
    public int getSize(){
        return size;
    }
    // Hàm duyệt theo thứ tự postorder (trái, phải, gốc)
    public void preorderTraversal(TreeNode<Integer> node) {
        if (node == null){
            return;
        }
        System.out.print(node.element + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }
    public void preorder() {
        preorderTraversal(root);
    }
    private TreeNode<Integer> minValueNode(TreeNode<Integer> node) {
        TreeNode<Integer> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    public void delete(int key) {
        root = deleteRec(root, key);
    }
    private TreeNode<Integer> deleteRec(TreeNode<Integer> root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.element) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.element) {
            root.right = deleteRec(root.right, key);
        } else {
            // Trường hợp 1: Nút có một hoặc không có con
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Trường hợp 2: Nút có hai con
            root.element = minValueNode(root.right).element;
            root.right = deleteRec(root.right, root.element);
        }

        return root;
    }
}

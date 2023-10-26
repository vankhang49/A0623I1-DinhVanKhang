package sesson12.bai_tap.removeInBST;

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
    public void postorderTraversal(TreeNode<Integer> node) {
        if (node == null){
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.element + " ");
    }
    public void postorder() {
        postorderTraversal(root);
    }
    // Tìm nút có giá trị nhỏ nhất trong cây
    private TreeNode<Integer> minValueNode(TreeNode<Integer> node) {
        TreeNode<Integer> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    // Xoá một nút có giá trị là key từ BST
    public void delete(int key) {
        root = deleteRec(root, key);
    }
    // Phương thức đệ quy để xoá một nút có giá trị là key
    private TreeNode<Integer> deleteRec(TreeNode<Integer> root, int key) {
        if (root == null) {
            return root;
        }
        // Duyệt cây để tìm nút cần xoá
        if (key < root.element) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.element) {
            root.right = deleteRec(root.right, key);
        } else {
            // Nút này là nút cần xoá
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

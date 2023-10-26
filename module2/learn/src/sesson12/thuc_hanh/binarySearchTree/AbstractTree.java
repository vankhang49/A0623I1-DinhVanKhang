package sesson12.thuc_hanh.binarySearchTree;

public abstract class AbstractTree<E> implements Tree<E>{

    @Override
    public boolean insert(E e) {
        return false;
    }

    @Override
    public void inorder() {

    }

    @Override
    public int getSize() {
        return 0;
    }
}

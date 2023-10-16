package sesson10.bai_tap.arrayList;

import java.util.Arrays;
public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }
    public boolean add(E e){
        if(size == elements.length) {
            return false;
        }
        elements[size++] = e;
        return true;
    }
    public void add(int index, E element){
        if (index<0){
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        } else {
            if (size == elements.length){
                ensureCapacity(size + 1);
            }
            for(int i = size; i>=index; i--){
                elements[i] = elements[i-1];
            }
            elements[index] = element;
            size++;
        }
    }
    public E remove(int index){
        checkIndex(index);
        for (int i = index; i < size -1; i++){
            elements[i] = elements[i+1];
        }
        elements[size - 1] = null;
        size--;
        return (E) elements;
    }
    public int size(){
        return size;
    }
    public MyList<E> clone() {
        MyList<E> cloneList = new MyList<>(elements.length);
        cloneList.size = this.size;
        if (size >= 0) System.arraycopy(this.elements, 0, cloneList.elements, 0, size);
        return cloneList;
    }
    public boolean contains(E e) {
        for (int i = 0; i < size; i++){
            if (e.equals(elements[i])){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E e){
        for (int i = 0; i < size; i++){
            if (e.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }
    public void ensureCapacity(int minCapacity) {
        if(minCapacity > elements.length){
            int length = elements.length;
            length = length*2 + 1;
            if(length < minCapacity){
                length = minCapacity;
            }
            elements = Arrays.copyOf(elements, length);
        }
    }
    public void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }
    public E get(int i){
        checkIndex(i);
        return (E) elements[i];
    }
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}

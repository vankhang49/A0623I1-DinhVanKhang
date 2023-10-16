package sesson9.DTO;

import java.util.Arrays;
public class StudentList<Student> {
    private static int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Student[] students;
    public StudentList(){
        students = (Student[]) new Object[DEFAULT_CAPACITY];
    }
    public StudentList(int capacity){
        students = (Student[]) new Object[capacity];
    }
    private void ensureCapa() {
        int newSize = students.length * 2;
        students = Arrays.copyOf(students, newSize);
    }
    public void add(Student e){
        if(size == students.length){
            ensureCapa();
        }
        students[size++] = e;
    }
    public Student remove(int index){
        checkIndex(index);
        for (int i = index; i < size -1; i++){
            students[i] = students[i+1];
        }
        students[size - 1] = null;
        size--;
        return students[index];
    }
    public int indexOf(Student e){
        for (int i = 0; i < size; i++){
            if (e.equals(students[i])){
                return i;
            }
        }
        return -1;
    }
    public void add(int index, Student element){
        if (index<0){
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        } else {
            if (size == students.length){
                ensureCapa();
            }
            for(int i = size; i>=index; i--){
                students[i] = students[i-1];
            }
            students[index] = element;
            size++;
        }
    }
    public Student get(int i) {
        checkIndex(i);
        return students[i];
    }
    public StudentList<Student> cloneList(){
        StudentList<Student> printStudent = new StudentList<>(size());
        printStudent.size = this.size();
        if (size >= 0) System.arraycopy(this.students, 0, printStudent.students, 0, size);
        return printStudent;
    }
    public static void checkIndex(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
        }
    }
    public int size(){
        return size;
    }
    public boolean contains(Student e) {
        for (int i = 0; i < size; i++){
            if (e.equals(students[i])){
                return true;
            }
        }
        return false;
    }
    public void clear() {
        students = (Student[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}

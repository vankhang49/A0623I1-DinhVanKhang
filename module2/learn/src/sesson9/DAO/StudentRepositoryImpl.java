package sesson9.DAO;

import sesson9.DTO.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class StudentRepositoryImpl implements StudentRepository{
    //kết nối DB
    private static final List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1, "Nguyễn Văn A"));
        studentList.add(new Student(2, "Trần Văn B"));
        studentList.add(new Student(3, "Lê Văn C"));
        studentList.add(new Student(4, "Bùi Văn D"));
    }

    @Override
    public List<Student> findAll(){
        return cloneList();
    }

    @Override
    public Student findStudent(int index) {
        return studentList.get(index);
    }

    @Override
    public int sizeOfStudentList() {
        return studentList.size();
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void updateStudent(int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to edit id or name of student? 'id' or 'name' ");
        String choice = sc.nextLine();
        if(Objects.equals(choice, "id")){
            System.out.println("Enter the id that you want to edit");
            int id = Integer.parseInt(sc.nextLine());
            Student student = studentList.get(i);
            student.setId(id);
        } else {
            System.out.println("Enter the name that you want to edit");
            String name = sc.nextLine();
            Student student = studentList.get(i);
            student.setName(name);
        }
    }

    @Override
    public void removeStudent(int index) {
        studentList.remove(index);
    }

    @Override
    public List<Student> cloneList() {
        List<Student> printStudent = new ArrayList<>(studentList.size());
        printStudent.addAll(studentList);
        return printStudent;
    }
}

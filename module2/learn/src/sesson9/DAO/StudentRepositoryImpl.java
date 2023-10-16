package sesson9.DAO;

import sesson9.DTO.Student;
import sesson9.DTO.StudentList;

import java.util.Objects;
import java.util.Scanner;

public class StudentRepositoryImpl implements StudentRepository{
    //kết nối DB
    private static final StudentList studentList = new StudentList<>();
    static {
        studentList.add(new Student(1, "Nguyễn Văn A"));
        studentList.add(new Student(2, "Trần Văn B"));
        studentList.add(new Student(3, "Lê Văn C"));
        studentList.add(new Student(4, "Bùi Văn D"));
    }

    @Override
    public StudentList findAll() {
        return studentList.cloneList();
    }

    @Override
    public Student findStuden(int index) {
        return (Student) studentList.get(index);
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
            Student student = (Student) studentList.get(i);
            student.setId(id);
        } else {
            System.out.println("Enter the name that you want to edit");
            String name = sc.nextLine();
            Student student = (Student) studentList.get(i);
            student.setName(name);
        }
    }

    @Override
    public void removeStudent(int index) {
        studentList.remove(index);
    }

    public static void main(String[] args) {
        StudentList studentListC = studentList.cloneList();
        for (int i = 0; i < studentListC.size(); i++){
            System.out.println(studentListC.get(i));
        }
    }
}

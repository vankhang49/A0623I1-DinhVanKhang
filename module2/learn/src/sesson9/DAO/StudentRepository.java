package sesson9.DAO;

import sesson9.DTO.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student findStudent(int index);
    int sizeOfStudentList();
    void addStudent(Student student);
    void updateStudent(int i);
    void removeStudent(int id);
    List<Student> cloneList();
}

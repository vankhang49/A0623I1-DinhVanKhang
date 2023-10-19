package sesson9.BO;

import sesson9.DTO.Student;

import java.util.List;

public interface StudentService{
    /* CRUD */
    List<Student> findAll();

    void addStudent(Student student);
    void removeStudent(int id);
    void updateStudent(int i);
}

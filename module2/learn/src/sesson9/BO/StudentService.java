package sesson9.BO;

import sesson9.DTO.Student;
import sesson9.DTO.StudentList;

public interface StudentService{
    /* CRUD */
    StudentList findAll();

    void addStudent(Student student);
    void removeStudent(int id);
    void updateStudent(int i);
}

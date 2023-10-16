package sesson9.DAO;
import sesson9.DTO.Student;
import sesson9.DTO.StudentList;

public interface StudentRepository {
    StudentList findAll();
    Student findStuden(int index);
    int sizeOfStudentList();
    void addStudent(Student student);
    void updateStudent(int i);
    void removeStudent(int id);
}

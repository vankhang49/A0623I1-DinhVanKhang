package StudentManagement.service;

import StudentManagement.models.Student;

public interface Service {
    void addNewStudent(Student student);
    Student removeStudent(int id);
    void displayStudentList();
    void showTeacherInfo(int teacherId);
    Student searchStudent(String name);
    int getSize();
}

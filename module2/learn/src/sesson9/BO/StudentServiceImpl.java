package sesson9.BO;

import sesson9.DAO.StudentRepository;
import sesson9.DAO.StudentRepositoryImpl;
import sesson9.DTO.Student;

import java.util.List;
import java.util.Objects;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository = new StudentRepositoryImpl();


    @Override
    public List<Student> findAll(){
        return repository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        int flag = 1;
        for (int i = 0; i < repository.sizeOfStudentList(); i++){
            if(Objects.equals(repository.findStudent(i).getName(), student.getName())) {
                System.out.println("Students already exist!");
                flag = 0;
            }
        }
        if(flag == 1){
            repository.addStudent(student);
        }
    }

    @Override
    public void updateStudent(int id) {
        int flag = 0;
        for (int i = 0; i < repository.sizeOfStudentList(); i++){
            if(repository.findStudent(i).getId() == id) {
                repository.updateStudent(i);
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println("Id does not exist!");
        }
    }

    @Override
    public void removeStudent(int id) {
        int flag = 0;
        for (int i = 0; i < repository.sizeOfStudentList(); i++){
            if(repository.findStudent(i).getId() == id) {
                repository.removeStudent(i);
                flag = 1;
            }
        }
        if(flag == 0){
            System.out.println("Id does not exist!");
        }
    }
}

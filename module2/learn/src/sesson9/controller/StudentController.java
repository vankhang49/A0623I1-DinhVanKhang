package sesson9.controller;

import sesson9.BO.StudentService;
import sesson9.BO.StudentServiceImpl;
import sesson9.DTO.Student;
import sesson9.DTO.StudentList;

import java.util.Scanner;

public class StudentController {
    private static final StudentService service = new StudentServiceImpl();

    public void function(int select){
        Scanner scanner = new Scanner(System.in);
        switch (select){
            case 1: //list
                StudentList studentList = service.findAll();
                System.out.println(studentList.size());
                for(int i = 0; i < studentList.size(); i++){
                    System.out.println(studentList.get(i));
                }
                break;
            case 2: //add new
                System.out.print("Input id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Input name: ");
                String name = scanner.nextLine();
                Student student = new Student(id, name);
                service.addStudent(student);
                break;
            case 3: //update
                System.out.println("Enter id of student that you want to update: ");
                id = Integer.parseInt(scanner.nextLine());
                service.updateStudent(id);
                break;
            case 4: // remove
                System.out.println("Enter id of student that you want to remove: ");
                id = Integer.parseInt(scanner.nextLine());
                service.removeStudent(id);
                break;
            case 5:// exit
                System.exit(0);
        }
    }
}

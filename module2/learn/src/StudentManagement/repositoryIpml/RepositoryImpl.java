package StudentManagement.serviceImpl;

import StudentManagement.models.Student;
import StudentManagement.models.StudyClass;
import StudentManagement.models.Teacher;
import StudentManagement.service.Service;
import StudentManagement.until.Regex;
import caseStudy.untils.Validate;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ServiceImpl implements Service {
    static Scanner sc = new Scanner(System.in);
    private static final List<Student> studentList;
    private static final String STUDENT_SRC = "H:\\codegym\\module2\\learn\\src\\StudentManagement\\data\\students.csv";
    private static final String TEACHER_SRC = "H:\\codegym\\module2\\learn\\src\\StudentManagement\\data\\teachers.csv";
    private static final String CLASS_SRC = "H:\\codegym\\module2\\learn\\src\\StudentManagement\\data\\class.csv";
    static {
        studentList = readFromFile();
    }
    private static List<Student> readFromFile(){
        List<Student> students = new ArrayList<>();
        try {
            File file = new File(STUDENT_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Student's file does not found!");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = " ";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                String born = arr[2];
                String gender = arr[3];
                String phoneNumber = arr[4];
                int classId = Integer.parseInt(arr[5]);
                Student student = new Student(id,name,born,gender,phoneNumber,classId);
                students.add(student);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
        return students;
    }
    private void writeToFile(Student student){
        try {
            File file = new File(STUDENT_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Student's file does not found!");
            }
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.newLine();
            bw.write(student.toString());
            bw.close();
        }catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
    }
    private void updateInFile(Student student){
        try {
            File inputFile = new File(STUDENT_SRC);
            File tempFile = new File("temp.csv");
            if (!inputFile.exists()){
                throw new FileNotFoundException("Student's file not found!");
            }
            if (tempFile.exists()){
                throw new FileNotFoundException("temp file does exist!");
            }
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            while ((currentLine = reader.readLine()) != null){
                String[] arr = currentLine.split(",");
                int id = Integer.parseInt(arr[0]);
                if (student.getId() == id){
                    System.out.println("Deleted student in file!");
                } else {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
            if (!inputFile.delete()) {
                System.out.println("Error deleting original file");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error renaming temporary file");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addNewStudent(Student student) {
        try {
            int id = studentList.size() + 1;
            System.out.print("Enter name of student: ");
            String name = Validate.validate(Regex.STUDENT_NAME, sc.nextLine());
            System.out.print("\nEnter student's born: ");
            String born = Validate.validate(Regex.STUDENT_BORN, sc.nextLine());
            System.out.println("\nEnter student' gender: ");
            String gender = sc.nextLine();
            System.out.println("\nEnter student's phone number: ");
            String phoneNumber = Validate.validate(Regex.PHONENUMBER, sc.nextLine());
            System.out.println("Enter class id: ");
            int classId = Integer.parseInt(sc.nextLine());
            Student student1 = new Student(id, name, born, gender, phoneNumber, classId);
            studentList.add(student1);
            writeToFile(student1);
            System.out.println("Add new successfully!");
        }
        catch (InputMismatchException e){
            System.out.println("Please enter a integer!");
        }
    }

    @Override
    public Student removeStudent(int id) {
        for (int i = 0; i < studentList.size(); i++){
            Student student = studentList.get(i);
            if (student.getId() == id){
                System.out.println("Student found! Let's enter 'Y' for remove student or 'N' for exit function!");
                String select = sc.nextLine();
                if (select.toLowerCase().equals("y")){
                    studentList.remove(student);
                    updateInFile(student);
                    return student;
                }
            }
        }
        return null;
    }

    @Override
    public void displayStudentList() {
        List<StudyClass> studyClasses = readClassFile();
        if (studentList.isEmpty()){
            System.out.println("Student's list is empty!");
        } else {
            for (Student stu: studentList){
                for (StudyClass study: studyClasses){
                    int classId = study.getId();
                    if (stu.getClassId() == study.getId()){
                        String name = study.getName();
                        System.out.println(stu.showInfo() + "\nClassname: " + name);
                    }
                }
            }
        }
    }
    private List<Teacher> readTeacherFile(){
        List<Teacher> teachers = new ArrayList<>();
        try {
            File file = new File(TEACHER_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Teacher's file does not found!");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = " ";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                String born = arr[2];
                String gender = arr[3];
                String phoneNumber = arr[4];
                Teacher teacher = new Teacher(id,name,born,gender,phoneNumber);
                teachers.add(teacher);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
        return teachers;
    }
    private List<StudyClass> readClassFile(){
        List<StudyClass> studyClasses = new ArrayList<>();
        try {
            File file = new File(CLASS_SRC);
            if (!file.exists()){
                throw new FileNotFoundException("Class file does not found!");
            }
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = " ";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int teacherId = Integer.parseInt(arr[2]);
                StudyClass studyClass = new StudyClass(id, name, teacherId);
                studyClasses.add(studyClass);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("IO exception!");
        }
        return studyClasses;
    }
    @Override
    public void showTeacherInfo(int teacherId) {
        List<Teacher> teacherList = readTeacherFile();
        for (Teacher t: teacherList){
            if (t.getId() == teacherId){
                System.out.println(t.showInfo());
            }
        }
    }

    @Override
    public Student searchStudent(String name) {
        for (Student str: studentList){
            if (str.getName().equals(name)){
                return str;
            }
        }
        return null;
    }

    @Override
    public int getSize() {
        return studentList.size();
    }

    public static void main(String[] args) {
        Service service = new ServiceImpl();
        service.displayStudentList();
    }
}

package caseStudy.services;

import caseStudy.models.Employee;

import java.io.*;
import java.util.*;

public class EmployeeServiceImpl implements EmployeeService {
    static Scanner sc = new Scanner(System.in);
    private static final List<Employee> employeesList;
    private static final String src = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\employee.csv";
    static {
        employeesList = createEmployeeData();
    }
    private static List<Employee> createEmployeeData(){
        List<Employee> employeesList = new ArrayList<>();
        try {
            File file = new File(src);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                String id = arr[0];
                String name = arr[1];
                String born = arr[2];
                String gender = arr[3];
                String identifier = arr[4];
                String phoneNumber = arr[5];
                String email = arr[6];
                String level = arr[7];
                String position = arr[8];
                int salary = Integer.parseInt(arr[9]);
                employeesList.add(new Employee(id, name, born, gender, identifier, phoneNumber,
                        email, level, position, salary));
            }
            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }
        catch (IOException e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Read write error");
        }
        return employeesList;
    }
    private void writeEmployee(Employee e){
        try {
            File writeFile = new File(src);
            if (!writeFile.exists()){
                throw new FileNotFoundException();
            }
            FileWriter writer = new FileWriter(src, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line = e.getId() + "," + e.getName() + "," + e.getBorn() + "," + e.getGender() + "," +
                    e.getIdentifier() + "," + e.getPhoneNumber() + "," + e.getEmail() + "," + e.getLevel() + "," +
                    e.getPosition() + "," + e.getSalary();
            bufferedWriter.write("\n" + line);
            bufferedWriter.close();
        }
        catch (Exception ex) {
            System.err.println("The source file does not exist!");
        }
    }
//    private void removeEmpInList(String id){
//        ArrayList<String> list = new ArrayList<>();
//        try {
//            File file = new File(src);
//            if (!file.exists()) {
//                throw new FileNotFoundException();
//            }
//            FileReader fileReader = new FileReader(src);
//            BufferedReader br = new BufferedReader(fileReader);
//            String line;
//            while ((line = br.readLine()) != null) {
//                String[] arr = line.split(",");
//                if (!Objects.equals(arr[0], id)) {
//                    list.add(line);
//                }
//            }
//            br.close();
//            FileWriter writer = new FileWriter(src, false);
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//            for (int i = 0; i < list.size(); i++) {
//                if (i == (list.size() - 1)) {
//                    bufferedWriter.write(list.get(i));
//                } else
//                    bufferedWriter.write(list.get(i) + "\n");
//            }
//            bufferedWriter.close();
//        } catch (Exception ex) {
//            System.err.println("The source file does not exist!");
//        }
//    }
    private void updateEmployeeInFile(Employee e) {
        try {
            File inputFile = new File(src);
            File tempFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] arr = currentLine.split(",");
                if (Objects.equals(arr[0], e.getId())) {
                    writer.write(e.getId() + "," + e.getName() + "," + e.getBorn()
                            + "," + e.getGender() + "," + e.getIdentifier() + ","
                            + e.getPhoneNumber() + "," + e.getEmail() + ","
                            + e.getLevel() + "," + e.getPosition() + ","
                            + e.getSalary() + "\n");
                } else {
                    writer.write(currentLine + "\n");
                }
            }
            writer.close();
            reader.close();
            if (!inputFile.delete()) {
                System.out.println("Error deleting original file");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Error renaming temporary file");
            }
        } catch (IOException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    @Override
    public void displayList() {
        Collections.sort(employeesList);
        for (Employee e: employeesList){
            System.out.println(e.inforPerson() + "\n");
        }
    }

    @Override
    public void addNew(Employee e) {
        try{
            for (Employee emp: employeesList){
                if (Objects.equals(emp.getId(), e.getId())) {
                    throw new IllegalArgumentException("Employee code is duplicated");
                }
            }
            writeEmployee(e);
            employeesList.add(e);
            System.out.println("Adding new employee successfully");
        }
        catch (IllegalArgumentException t){
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void editEmployee(String id) {
        try {
            boolean found = false;
            for (Employee emp: employeesList){
                if (Objects.equals(emp.getId(), id)) {
                    System.out.println("Enter the item you want to edit: ");
                    String select = sc.nextLine();
                    switch (select.toLowerCase()) {  // Convert to lowercase for case-insensitive comparison
                        case "id":
                            System.out.println("Enter a new id");
                            String newId = sc.nextLine();
                            emp.setId(newId);
                            break;
                        case "name":
                            System.out.println("Enter a new name");
                            String newName = sc.nextLine();
                            emp.setName(newName);
                            break;
                        case "born":
                            System.out.println("Enter a new Born");
                            String newBorn = sc.nextLine();
                            emp.setBorn(newBorn);
                            break;
                        case "gender":
                            System.out.println("Enter a new gender");
                            String newGender = sc.nextLine();
                            emp.setGender(newGender);
                            break;
                        case "identifier":
                            System.out.println("Enter a new identifier");
                            String newIdentifier = sc.nextLine();
                            emp.setIdentifier(newIdentifier);
                            break;
                        case "phone number":
                            System.out.println("Enter a new phoneNumber");
                            String PhoneNumber = sc.nextLine();
                            emp.setPhoneNumber(PhoneNumber);
                            break;
                        case "email":
                            System.out.println("Enter a new email");
                            String newEmail = sc.nextLine();
                            emp.setEmail(newEmail);
                            break;
                        case "level":
                            System.out.println("Enter a new level");
                            String newLevel = sc.nextLine();
                            emp.setLevel(newLevel);
                            break;
                        case "position":
                            System.out.println("Enter a new position");
                            String position = sc.nextLine();
                            emp.setPosition(position);
                            break;
                        case "salary":
                            System.out.println("Enter a new salary");
                            int salary = sc.nextInt();
                            emp.setSalary(salary);
                            break;
                        default:
                            System.out.println("Invalid input");
                            return;
                    }
                    updateEmployeeInFile(emp);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}

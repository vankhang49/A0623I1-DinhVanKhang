package caseStudy.serviceImpl;

import caseStudy.models.Customer;
import caseStudy.services.CustomerService;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static Scanner sc = new Scanner(System.in);
    private static final List<Customer> customerList;
    private static final String src = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\customer.csv";
    static {
        customerList = createCustomerData();
    }
    private static List<Customer> createCustomerData(){
        List<Customer> customersList = new LinkedList<>();
        try {
            File file = new File(CustomerServiceImpl.src);
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
                String typeOfGuest = arr[7];
                String address = arr[8];
                customersList.add(new Customer(id, name, born, gender, identifier, phoneNumber,
                        email, typeOfGuest, address));
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
        return customersList;
    }
    private void writeCustomer(Customer c){
        try {
            File writeFile = new File(src);
            if (!writeFile.exists()){
                throw new FileNotFoundException();
            }
            FileWriter writer = new FileWriter(src, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line = c.getId() + "," + c.getName() + "," + c.getBorn() + "," + c.getGender() + "," +
                    c.getIdentifier() + "," + c.getPhoneNumber() + "," + c.getEmail() + "," + c.getTypeOfGuest() + "," +
                    c.getAddress();
            bufferedWriter.write("\n" + line);
            bufferedWriter.close();
        }
        catch (Exception ex) {
            System.err.println("The source file does not exist!");
        }
    }
    private void updateCustomerInFile(Customer c) {
        try {
            File inputFile = new File(src);
            File tempFile = new File("temp.csv");
            if (!inputFile.exists()){
                System.out.println("File not found!");
            }
            if (tempFile.exists()){
                System.out.println("Temp file exist!");
            }
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] arr = currentLine.split(",");
                if (Objects.equals(arr[0], c.getId())) {
                    writer.write(c.getId() + "," + c.getName() + "," + c.getBorn() + "," + c.getGender() + "," +
                            c.getIdentifier() + "," + c.getPhoneNumber() + "," + c.getEmail() + "," +
                            c.getTypeOfGuest() + "," + c.getAddress() + "\n");
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
        for (Customer cus: customerList){
            System.out.println(cus.inforPerson() + "\n");
        }
    }
    @Override
    public void addNew(Customer c) {
        try{
            for (Customer cus: customerList){
                if (Objects.equals(cus.getId(), c.getId())) {
                    throw new IllegalArgumentException("Employee code is duplicated");
                }
            }
            customerList.add(c);
            writeCustomer(c);
            System.out.println("Adding new employee successfully");
        }
        catch (IllegalArgumentException t){
            System.out.println(t.getMessage());
        }
    }

    @Override
    public void editCustomer(String id) {
        try {
            boolean found = false;
            for (Customer cus : customerList) {
                if (Objects.equals(cus.getId(), id)) {
                    System.out.println("Enter the item you want to edit: ");
                    String select = sc.nextLine();
                    switch (select.toLowerCase()) {
                        case "id":
                            System.out.println("Enter a new id");
                            String newId = sc.nextLine();
                            cus.setId(newId);
                            break;
                        case "name":
                            System.out.println("Enter a new name");
                            String newName = sc.nextLine();
                            cus.setName(newName);
                            break;
                        case "born":
                            System.out.println("Enter a new Born");
                            String newBorn = sc.nextLine();
                            cus.setBorn(newBorn);
                            break;
                        case "gender":
                            System.out.println("Enter a new gender");
                            String newGender = sc.nextLine();
                            cus.setBorn(newGender);
                            break;
                        case "identifier":
                            System.out.println("Enter a new identifier");
                            String newIdentifier = sc.nextLine();
                            cus.setIdentifier(newIdentifier);
                            break;
                        case "phone number":
                            System.out.println("Enter a new phoneNumber");
                            String PhoneNumber = sc.nextLine();
                            cus.setPhoneNumber(PhoneNumber);
                            break;
                        case "email":
                            System.out.println("Enter a new email");
                            String newEmail = sc.nextLine();
                            cus.setEmail(newEmail);
                            break;
                        case "type":
                        case "type of customer":
                            System.out.println("Enter a new type of customer");
                            String type = sc.nextLine();
                            cus.setTypeOfGuest(type);
                            break;
                        case "address":
                            System.out.println("Enter a new address");
                            String address = sc.nextLine();
                            cus.setAddress(address);
                            break;
                        default:
                            System.out.println("Invalid input");
                            return;
                    }
                    updateCustomerInFile(cus);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Customer not found");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
}

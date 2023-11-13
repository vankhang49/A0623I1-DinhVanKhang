package caseStudy.controller;

import caseStudy.models.Customer;
import caseStudy.models.Employee;
import caseStudy.services.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuramaController {
    private static final EmployeeService employeeService = new EmployeeServiceImpl();
    private static final CustomerService customerService = new CustomerServiceImpl();
    private static final FacilityService facilityService = new FacilityServiceImpl();
    private static final BookingService bookingService = new BookingServiceImpl();
    private static final ContractService contractService = new ContractServiceImpl();
    private static final PromotionService promotionService = new PromotionServiceImpl();
    public static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu(){
        int select;
        do{
            try {
                System.out.println("-----Main Menu--------");
                System.out.println("1. Employee Management");
                System.out.println("2. Customer Management");
                System.out.println("3. Facility Management");
                System.out.println("4. Booking Management");
                System.out.println("5. Promotion Management");
                System.out.println("6. Exit");
                System.out.print("Please input number: ");
                select = scanner.nextInt();
                switch (select){
                    case 1: // Call Employee Menu
                        displayEmployeeMenu();
                        break;
                    case 2: // Call Customer Menu
                        displayCustomerMenu();
                        break;
                    case 3: // Call Facility Menu
                        displayFacilityMenu();
                        break;
                    case 4: // Call Booking Menu
                        displayBookingMenu();
                        break;
                    case 5: // Call Promotion Menu
                        displayPromotionMenu();
                        break;
                    case 6:
                        System.exit(0);
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
                scanner.nextLine();
            }
        }while (true);
    }

    public static void displayEmployeeMenu(){
        int select;
        do{
            try {
                System.out.println("-----Employee Menu--------");
                System.out.println("1. Display list employees");
                System.out.println("2. Add new employee");
                System.out.println("3. Edit employee");
                System.out.println("4. Return main menu");
                System.out.print("Please input number: ");
                select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1: // Display list employees
                        System.out.println("List employees: ");
                        employeeService.displayList();
                        break;
                    case 2: // Add new employee
                        System.out.println("Enter id of employee: ");
                        String id = scanner.nextLine();
                        System.out.println("Enter name of employee: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter born of employee: ");
                        String born = scanner.nextLine();
                        System.out.println("Enter gender of employee: ");
                        String gender = scanner.nextLine();
                        System.out.println("Enter identifier of employee: ");
                        String identifier = scanner.nextLine();
                        System.out.println("Enter phone number of employee: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter email of employee: ");
                        String email = scanner.nextLine();
                        System.out.println("Enter level of employee: ");
                        String level = scanner.nextLine();
                        System.out.println("Enter position of employee: ");
                        String position = scanner.nextLine();
                        System.out.println("Enter salary of employee: ");
                        int salary = Integer.parseInt(scanner.nextLine());
                        Employee employee = new Employee(id, name, born, gender, identifier, phoneNumber, email,
                                level, position, salary);
                        employeeService.addNew(employee);
                        break;
                    case 3: // Edit
                        System.out.println("Enter id of employee you want to edit: ");
                        String idEdit = scanner.nextLine();
                        employeeService.editEmployee(idEdit);
                        break;
                    case 4: // Return main menu
                        displayMainMenu();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
                scanner.nextLine();
            }
        }while (true);
    }

    public static void displayCustomerMenu(){
        do{
            try {
                System.out.println("-----Customer Menu--------");
                System.out.println("1. Display list customers");
                System.out.println("2. Add new customer");
                System.out.println("3. Edit customer");
                System.out.println("4. Return main menu");
                System.out.print("Please input number: ");
                int select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1: // Display list customers
                        System.out.println("List customers: ");
                        customerService.displayList();
                        break;
                    case 2: // Add new customer
                        System.out.println("Enter id of customer: ");
                        String id = scanner.nextLine();
                        System.out.println("Enter name of customer: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter born of customer: ");
                        String born = scanner.nextLine();
                        System.out.println("Enter gender of customer: ");
                        String gender = scanner.nextLine();
                        System.out.println("Enter identifier of customer: ");
                        String identifier = scanner.nextLine();
                        System.out.println("Enter phone number of customer: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.println("Enter email of customer: ");
                        String email = scanner.nextLine();
                        System.out.println("Enter type of customer: ");
                        String type = scanner.nextLine();
                        System.out.println("Enter address of customer: ");
                        String address = scanner.nextLine();
                        Customer customer = new Customer(id, name, born, gender, identifier, phoneNumber, email, type, address);
                        customerService.addNew(customer);
                        break;
                    case 3: // Edit
                        System.out.println("Enter id of customer you want to edit: ");
                        String idEdit = scanner.nextLine();
                        customerService.editCustomer(idEdit);
                        break;
                    case 4: // Return main menu
                        displayMainMenu();
                }
            }
            catch (NumberFormatException e){
                System.out.println(e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
                scanner.nextLine();
            }
        }while (true);
    }

    public static void displayFacilityMenu(){
        do{
            try {
                System.out.println("-----Facility Menu--------");
                System.out.println("1. Display list Facilities");
                System.out.println("2. Add new Facility");
                System.out.println("3. Display list facility maintenance");
                System.out.println("4. Return main menu");
                System.out.print("Please input number: ");
                int select = scanner.nextInt();
                switch (select){
                    case 1: // Display list Facilities
                        System.out.println("List Facilities: ");
                        facilityService.displayList();
                        break;
                    case 2: // Add new customer
                        facilityService.addFacilityMenu();
                        break;
                    case 3: // Edit
                        facilityService.displayFacilityMaintenance();
                        break;
                    case 4: // Return main menu
                        displayMainMenu();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
                scanner.nextLine();
            }
        }while (true);
    }

    public static void displayBookingMenu(){
        do{
            try {
                System.out.println("-----Booking Menu--------");
                System.out.println("1. Add new booking");
                System.out.println("2. Display list booking");
                System.out.println("3. Create new contracts");
                System.out.println("4. Display list contracts");
                System.out.println("5. Edit contracts");
                System.out.println("6. Return main menu");
                System.out.print("Please input number: ");
                int select = scanner.nextInt();
                switch (select){
                    case 1: // Add new Booking
                        bookingService.addNewBooking();
                        break;
                    case 2: // Display list
                        bookingService.displayList();
                        break;
                    case 3: // Create new contracts
                        contractService.addNewContract();
                        System.out.println("A new contract has been created");
                        break;
                    case 4: // Display list contracts
                        System.out.println("List contracts: ");
                        contractService.displayList();
                        break;
                    case 5: // Edit contract
                        System.out.println("Enter id contract you want to edit: ");
                        int idContract = scanner.nextInt();
                        contractService.editContract(idContract);
                        break;
                    case 6: // Return main menu
                        displayMainMenu();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
                scanner.nextLine();
            }
        }while (true);
    }
    public static void displayPromotionMenu(){
        do{
            try {
                System.out.println("-----Promotion Menu--------");
                System.out.println("1. Display list customers use service");
                System.out.println("2. Display list customers get voucher");
                System.out.println("3. Return main menu");;
                System.out.print("Please input number: ");
                int select = scanner.nextInt();
                switch (select){
                    case 1:
                        promotionService.displayCusUseService();
                        break;
                    case 2:
                        promotionService.displayCusGetVoucher();
                        break;
                    case 3:
                        displayMainMenu();
                }
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer!");
                scanner.nextLine();
            }
        }while (true);
    }

    public static void main(String[] args) {
        System.out.println("-----Furama Management System--------");
        displayMainMenu();
    }
}

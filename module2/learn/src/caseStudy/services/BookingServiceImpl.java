package caseStudy.services;

import caseStudy.models.Booking;
import caseStudy.models.Facility;

import java.io.*;
import java.util.*;

public class BookingServiceImpl implements BookingService{
    static Scanner sc = new Scanner(System.in);
    private static final Set<Booking> listBooking;
    private static final FacilityService facilityService = new FacilityServiceImpl();
    private static final String SRC = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\booking.csv";

    static {
        listBooking = createBookingData();
    }
    private static Set<Booking> createBookingData(){
        Set<Booking> bookingList = new TreeSet<>(new BookingComparator());
        try {
            File file = new File(SRC);
            if (!file.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                String idBooking = arr[0];
                String beginDate = arr[1];
                String endDate = arr[2];
                String idCustomer = arr[3];
                String serviceName = arr[4];
                String serviceType = arr[5];
                bookingList.add(new Booking(idBooking, beginDate, endDate, idCustomer, serviceName, serviceType));
            }
            br.close();
        }
        catch (FileNotFoundException e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("The file does not exist or the content has errors!");
        }
        catch (Exception e) {
            System.err.println("There is some error!");
        }
        return bookingList;
    }
    private void writeBooking(Booking b){
        try {
            File writeFile = new File(SRC);
            if (!writeFile.exists()){
                throw new FileNotFoundException();
            }
            FileWriter writer = new FileWriter(SRC, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line = b.getIdBooking() + "," + b.getBeginDate() + "," + b.getEndDate() + "," +
                    b.getIdCustomer() + "," + b.getServiceName() + "," + b.getServiceType();
            bufferedWriter.write("\n" + line);
            bufferedWriter.close();
        }
        catch (Exception ex) {
            System.err.println("The source file does not exist!");
        }
    }

    @Override
    public void addNewBooking() {
        CustomerService customerService = new CustomerServiceImpl();
        System.out.println("Customer List: ");
        customerService.displayList();
        System.out.println("Enter Customer's id: ");
        String idCus = sc.nextLine();

        System.out.println("Enter Booking's id: ");
        String idBook = sc.nextLine();
        System.out.println("Enter begin date: ");
        String beginDate = sc.nextLine();
        System.out.println("Enter end date: ");
        String endDate = sc.nextLine();
        System.out.println("Enter service type: ");
        String type = sc.nextLine();

        System.out.println("Service List: ");
        facilityService.displayList();
        System.out.println("Enter service's id: ");
        String serviceId = sc.nextLine();
        Booking booking = new Booking(idBook, beginDate, endDate, idCus, serviceId, type);
        addNew(booking);
        writeBooking(booking);
    }

    @Override
    public void addNew(Booking b) {
        try{
            if (listBooking.contains(b)){
                throw new IllegalArgumentException("Booking already exists");
            }
            if (facilityService.checkFacility(b.getServiceName())){
                System.out.println("The service you selected is undergoing maintenance!");
            } else {
                listBooking.add(b);
                facilityService.increaseTurns(b.getServiceName());
                System.out.println("Adding new Booking successfully!");
            }
        }
        catch (IllegalArgumentException c){
            System.out.println(c.getMessage());
        }
    }

    @Override
    public double getRentalFee(String serviceName) {
        List<Facility> facilities = facilityService.getFacilityList();
        for (Facility f: facilities){
            if (Objects.equals(f.getServiceName(), serviceName)){
                return f.getRentalFee();
            }
        }
        return 0;
    }

    @Override
    public List<Booking> getBooking() {
        return new ArrayList<>(listBooking);
    }

    @Override
    public void displayList() {
        System.out.println("Booking list: ");
        for (Booking b: listBooking){
            System.out.println(b.bookingInfo() + "\n");
        }
    }

    public static void main(String[] args) {
        BookingService bookingService = new BookingServiceImpl();
        bookingService.displayList();
    }
}

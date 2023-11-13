package caseStudy.services;

import caseStudy.models.Booking;
import caseStudy.models.Contract;

import java.io.*;
import java.util.*;

public class ContractServiceImpl implements ContractService{
    static Scanner sc = new Scanner(System.in);
    private static final Queue<Contract> contractsList;
    private static final BookingService bookingService = new BookingServiceImpl();
    private static final String src = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\contract.csv";
    static {
        contractsList = createContractData();
    }
    public static Queue<Contract> createContractData(){
        Queue<Contract> contractList = new LinkedList<>();
        try {
            File file = new File(src);
            if (!file.exists()){
                System.out.println("File not found");
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                int contractNumber = Integer.parseInt(arr[0]);
                String idBooking = arr[1];
                double deposit = Double.parseDouble(arr[2]);
                double totalPayment = Double.parseDouble(arr[3]);
                String idCustomer = arr[4];
                contractList.add(new Contract(contractNumber, idBooking, deposit, totalPayment, idCustomer));
            }
            br.close();
        }
//        catch (FileNotFoundException f){
//            System.out.println("The file does not exist or the content has errors!");
//        }
        catch (Exception e) {
            System.err.println("There is some error!");
        }
        return contractList;
    }
    private static void writeContract(Contract c){
        try {
            File writeFile = new File(src);
            if (!writeFile.exists()){
                throw new FileNotFoundException();
            }
            FileWriter writer = new FileWriter(src, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String line = c.getContractNumber()+ "," + c.getIdBooking() + "," + c.getDeposit() + "," + c.getTotalPayment()
                    + "," + c.getIdCustomer();
            bufferedWriter.write("\n" + line);
            bufferedWriter.close();
        }
        catch (Exception ex) {
            System.err.println("The source file does not exist!");
        }
    }
    private void updateContractInFile(Contract c) {
        try {
            File inputFile = new File(src);
            File tempFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] arr = currentLine.split(",");
                if (Objects.equals(Integer.parseInt(arr[0]), c.getContractNumber())) {
                    writer.write(c.getContractNumber()+ "," + c.getIdBooking() + "," + c.getDeposit() + "," + c.getTotalPayment()
                            + "," + c.getIdCustomer() + "\n");
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
    public void addNewContract() {
        ArrayList<Booking> bookings = new ArrayList<>(bookingService.getBooking());
        int cSize = contractsList.size();
        int bSize = bookings.size();
        if (bSize > cSize){
            Booking booking = bookings.get(bSize-1);
            Booking[] bookingsArr = bookingService.getBooking().toArray(new Booking[0]);
            Contract contract = new Contract(cSize+1, booking.getIdBooking(),
                        bookingService.getRentalFee(booking.getServiceName())*0.4,
                        bookingService.getRentalFee(booking.getServiceName()), booking.getIdCustomer());
            addNew(contract);
        }
    }

    @Override
    public void addNew(Contract c) {
        boolean flag = contractsList.add(c);
        if (flag){
            writeContract(c);
            System.out.println(c.infoContract());
        } else {
            System.out.println("No new contracts are created!");
        }
    }

    @Override
    public void displayList() {
        for (Contract c: contractsList){
            System.out.println(c.infoContract() + "\n");
        }
    }

    @Override
    public void editContract(int contractNumber) {
        try {
            boolean found = false;
            for (Contract contract : contractsList) {
                if (contract.getContractNumber() == contractNumber) {
                    System.out.println("Enter the section you want to edit: ");
                    String select = sc.nextLine();
                    switch (select.toLowerCase()){
                        case "deposit":
                            System.out.println("Enter new deposit: ");
                            double deposit = sc.nextDouble();
                            contract.setDeposit(deposit);
                            break;
                        case "total payment":
                            System.out.println("Enter new total payment: ");
                            double totalPayment = sc.nextDouble();
                            contract.setTotalPayment(totalPayment);
                            break;
                        default:
                            System.out.println("Invalid input");
                            return;
                    }
                    updateContractInFile(contract);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Contract not found");
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ContractService contractService = new ContractServiceImpl();
        contractService.displayList();
    }
}

package caseStudy.services;

import caseStudy.models.*;

import java.io.*;
import java.util.*;

public class FacilityServiceImpl implements FacilityService{
    static Scanner sc = new Scanner(System.in);
    private static final Map<Facility, Integer> facilityIntegerMap;
    private static final String villaSrc = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\villa.csv";
    private static final String houseSrc = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\house.csv";
    private static final String roomSrc = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\room.csv";

    static {
        facilityIntegerMap = createFacilitiesData();
    }

    private static Map<Facility, Integer> createFacilitiesData()  {
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
        try {
            File file1 = new File(villaSrc);
            File file2 = new File(houseSrc);
            File file3 = new File(roomSrc);
            if (!file1.exists()){
//                throw new FileNotFoundException();
                System.out.println("File not found");
            }
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                facilityList.put(new Villa(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]), arr[4], arr[5] , Double.parseDouble(arr[6]),
                        Integer.parseInt(arr[7])), Integer.parseInt(arr[8]));
            }
            br.close();

            if (!file2.exists()){
//                throw new FileNotFoundException();
                System.out.println("File not found");
            }
            br = new BufferedReader(new FileReader(file2));
            line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                facilityList.put(new House(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]), arr[4], arr[5] , Integer.parseInt(arr[6])), Integer.parseInt(arr[8]));
            }
            br.close();

            if (!file3.exists()){
//                throw new FileNotFoundException();
                System.out.println("File not found");
            }
            br = new BufferedReader(new FileReader(file3));
            line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                facilityList.put(new Room(arr[0], Double.parseDouble(arr[1]), Double.parseDouble(arr[2]),
                        Integer.parseInt(arr[3]), arr[4], arr[5]), Integer.parseInt(arr[8]));
            }
            br.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Read write error");
        }
        return facilityList;
    }
    private void writeFacility(Facility f){
        try {
            String src;
            if (f instanceof Villa) {
                src = villaSrc;
            } else if (f instanceof House) {
                src = houseSrc;
            } else if (f instanceof Room) {
                src = roomSrc;
            } else {
                throw new IllegalArgumentException("Unsupported facility type");
            }

            File writeFile = new File(src);
            if (!writeFile.exists()) {
                throw new FileNotFoundException();
            }

            FileWriter writer = new FileWriter(src, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            if (f instanceof Villa) {
                Villa villa = (Villa) f;
                String line = villa.getServiceName() + "," + villa.getUsableArea() + "," + villa.getRentalFee() + ","
                        + villa.getNumOfPeople() + "," + villa.getTypeOfRental() + "," + villa.getRoomStandards() + ","
                        + villa.getSwimmingPoolArea() + "," + villa.getNumberOfFloors() + "\n" + 0;
                bufferedWriter.write("\n" + line);
            } else if (f instanceof House) {
                House house = (House) f;
                String line = house.getServiceName() + "," + house.getUsableArea() + "," + house.getRentalFee() + ","
                        + house.getNumOfPeople() + "," + house.getTypeOfRental() + "," + house.getRoomStandards() + ","
                        + house.getNumberOfFloors() + "," + 0;
                bufferedWriter.write("\n" + line);
            } else if (f instanceof Room) {
                Room room = (Room) f;
                String line = room.getServiceName() + "," + room.getUsableArea() + "," + room.getRentalFee() + ","
                        + room.getNumOfPeople() + "," + room.getTypeOfRental() + "," + room.getFreeServiceIncluded()
                        + "\n" + 0;
                bufferedWriter.write("\n" + line);
            }

            bufferedWriter.close();
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }
    private void updateIncreaseTurnInFile(String serviceName) {
        try {
            String src = null;
            if (Objects.equals(serviceName.split("-")[0], "SVVL")) {
                src = villaSrc;
            } else if (Objects.equals(serviceName.split("-")[0], "SVHO")) {
                src = houseSrc;
            } else if (Objects.equals(serviceName.split("-")[0], "SVRO")) {
                src = roomSrc;
            }
            File inputFile = new File(src);
            File tempFile = new File("temp.csv");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] arr = currentLine.split(",");
                if (Objects.equals(serviceName.split("-")[0], "SVVL")){
                    if (Objects.equals(arr[0], serviceName)) {
                        writer.write(arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," +
                                arr[4] + "," + arr[5] + "," + arr[6] + "," +
                                arr[7] + "," + (Integer.parseInt(arr[8])+1) + "\n");
                    } else {
                        writer.write(currentLine + "\n");
                    }
                }
                if (Objects.equals(serviceName.split("-")[0], "SVHO")){
                    if (Objects.equals(arr[0], serviceName)) {
                        writer.write(arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," +
                                arr[4] + "," + arr[5] + "," + arr[6] + "," + (Integer.parseInt(arr[7])+1)  + "\n");
                    } else {
                        writer.write(currentLine + "\n");
                    }
                }
                if (Objects.equals(serviceName.split("-")[0], "SVRO")){
                    if (Objects.equals(arr[0], serviceName)) {
                        writer.write(arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + "," +
                                arr[4] + "," + arr[5] + "," + (Integer.parseInt(arr[6])+1)  + "\n");
                    } else {
                        writer.write(currentLine + "\n");
                    }
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
    public boolean checkFacility(String serviceName) {
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if(Objects.equals(entry.getKey().getServiceName(), serviceName)){
                if (entry.getValue() >= 5){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Facility, Integer> facilityMaintenance = new LinkedHashMap<>();
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if(entry.getValue() >= 5){
                facilityMaintenance.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println();
        System.out.println("List facility maintenance: ");
        for (Facility f: facilityMaintenance.keySet()){
            System.out.println(f.infoOfService() + "\n");
        }
    }

    @Override
    public void displayList() {
        for (Facility f : facilityIntegerMap.keySet()) {
            System.out.println(f.infoOfService() + "\n");
        }
    }

    @Override
    public void increaseTurns(String serviceName) {
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            if (Objects.equals(entry.getKey().getServiceName(), serviceName)){
                entry.setValue(entry.getValue()+1);
                updateIncreaseTurnInFile(serviceName);
            }
        }
    }

    @Override
    public void addNew(Facility f) {
        try{
            if (facilityIntegerMap.containsKey(f)){
                throw new IllegalArgumentException("Facility already exists");
            }
            facilityIntegerMap.put(f, 0);
            writeFacility(f);
            System.out.println("Adding new facility successfully!");
        }
        catch (IllegalArgumentException c){
            System.out.println(c.getMessage());
        }
    }

    @Override
    public void addFacilityMenu() {
        try {
            int select;
            boolean check = true;
            do {
                System.out.println("Add new facility menu: ");
                System.out.println("1. Add New Villa");
                System.out.println("2. Add New House");
                System.out.println("3. Add New Room");
                System.out.println("4. Back to facility menu");
                System.out.println("Input a number: ");
                select = sc.nextInt();
                switch (select){
                    case 1:
                        sc.nextLine();
                        System.out.println("You choose add new villa: ");
                        System.out.println("Enter a service's name: ");
                        String serviceName = sc.nextLine();
                        System.out.println("Enter a usable area: ");
                        double usableArea = sc.nextDouble();
                        System.out.println("Enter a rental fee: ");
                        double rentalFee = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Enter a number of peoples: ");
                        int numOfPeople = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter a type of rental: ");
                        String typeOfRental = sc.nextLine();
                        System.out.println("Enter room standards: ");
                        String roomStandards = sc.nextLine();
                        System.out.println("Enter a swimming pool area: ");
                        double swimmingPoolArea = sc.nextDouble();
                        System.out.println("Enter a number of floors: ");
                        int numberOfFloors = sc.nextInt();
                        Villa villa = new Villa(serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                                roomStandards, swimmingPoolArea, numberOfFloors);
                        addNew(villa);
                        writeFacility(villa);
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.println("You choose add new house: ");
                        System.out.println("Enter a service's name: ");
                        serviceName = sc.nextLine();
                        System.out.println("Enter a usable area: ");
                        usableArea = sc.nextDouble();
                        System.out.println("Enter a rental fee: ");
                        rentalFee = sc.nextDouble();
                        System.out.println("Enter a number of peoples: ");
                        numOfPeople = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter a type of rental: ");
                        typeOfRental = sc.nextLine();
                        System.out.println("Enter room standards: ");
                        roomStandards = sc.nextLine();
                        System.out.println("Enter a number of floors: ");
                        numberOfFloors = sc.nextInt();
                        House house = new House(serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                                roomStandards, numberOfFloors);
                        addNew(house);
                        writeFacility(house);
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("You choose add new room: ");
                        System.out.println("Enter a service's name: ");
                        serviceName = sc.nextLine();
                        System.out.println("Enter a usable area: ");
                        usableArea = sc.nextDouble();
                        System.out.println("Enter a rental fee: ");
                        rentalFee = sc.nextDouble();
                        System.out.println("Enter a number of peoples: ");
                        numOfPeople = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter a type of rental: ");
                        typeOfRental = sc.nextLine();
                        System.out.println("Enter free service included: ");
                        String freeServiceIncluded = sc.nextLine();
                        Room room = new Room(serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                                freeServiceIncluded);
                        addNew(room);
                        writeFacility(room);
                        break;
                    case 4:
                        check = false;
                }
            } while (check);
        }
        catch (InputMismatchException e){
            System.out.println("Please enter the number!");
        }
    }

    @Override
    public List<Facility> getFacilityList() {
        return new ArrayList<>(facilityIntegerMap.keySet());
    }
}

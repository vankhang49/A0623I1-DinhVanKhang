package caseStudy.serviceImpl;

import caseStudy.models.*;
import caseStudy.services.BookingService;
import caseStudy.services.FacilityService;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacilityServiceImpl implements FacilityService {
    static Scanner sc = new Scanner(System.in);
    private static final Map<Facility, Integer> facilityIntegerMap;
    private static final String VILLA_SRC = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\villa.csv";
    private static final String HOUSE_SRC = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\house.csv";
    private static final String ROOM_SRC = "H:\\codegym\\module2\\learn\\src\\caseStudy\\data\\room.csv";
    private Pattern pattern;
    private Matcher matcher;
    private static final String IDSERVICE_REGEX = "^SV(VL|HO|RO)-\\d{4}$";
    private static final String SERVICENAME_REGEX = "^[A-Z][a-z]*$";
    private static final String AREA_REGEX = "^([3-9]\\d(\\.\\d+)?| [1-9]\\d{2,}(\\.\\d+)?)$";
    private static final String FEE_REGEX = "^[1-9]\\d*$";
    private static final String NUMPEOPLE_REGEX = "^([1-9]|1\\d)$";

    static {
        facilityIntegerMap = createFacilitiesData();
    }

    private static Map<Facility, Integer> createFacilitiesData()  {
        Map<Facility, Integer> facilityList = new LinkedHashMap<>();
        facilityList.putAll(createVillaObj());
        facilityList.putAll(createHouseObj());
        facilityList.putAll(createRoomObj());
        return facilityList;
    }
    private static Map<Facility, Integer> createVillaObj(){
        Map<Facility, Integer> villaList = new LinkedHashMap<>();
        try {
            File file1 = new File(VILLA_SRC);
            if (!file1.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file1));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                String idService = arr[0];
                String serviceName = arr[1];
                double usableArea = Double.parseDouble(arr[2]);
                double rentalFee = Double.parseDouble(arr[3]);
                int numOfPeople = Integer.parseInt(arr[4]);
                String typeOfRental = arr[5];
                String roomStandards = arr[6];
                double swimmingPoolArea = Double.parseDouble(arr[7]);
                int numberOfFloors = Integer.parseInt(arr[8]);
                int turn = Integer.parseInt(arr[9]);
                villaList.put(new Villa(idService,serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                        roomStandards, swimmingPoolArea, numberOfFloors), turn);
            }
            br.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Read write error");
        }
        return villaList;
    }
    private static Map<Facility, Integer> createHouseObj(){
        Map<Facility, Integer> houseList = new LinkedHashMap<>();
        try {
            File file2 = new File(HOUSE_SRC);
            if (!file2.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file2));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                String idService = arr[0];
                String serviceName = arr[1];
                double usableArea = Double.parseDouble(arr[2]);
                double rentalFee = Double.parseDouble(arr[3]);
                int numOfPeople = Integer.parseInt(arr[4]);
                String typeOfRental = arr[5];
                String roomStandards = arr[6];
                int numberOfFloors = Integer.parseInt(arr[7]);
                int turn = Integer.parseInt(arr[8]);
                houseList.put(new House(idService, serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                        roomStandards, numberOfFloors), turn);
            }
            br.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Read write error");
        }
        return houseList;
    }
    private static Map<Facility, Integer> createRoomObj(){
        Map<Facility, Integer> roomList = new LinkedHashMap<>();
        try {
            File file3 = new File(ROOM_SRC);
            if (!file3.exists()){
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file3));
            String line = "";
            while ((line = br.readLine()) != null){
                String[] arr = line.split(",");
                String idService = arr[0];
                String serviceName = arr[1];
                double usableArea = Double.parseDouble(arr[2]);
                double rentalFee = Double.parseDouble(arr[3]);
                int numOfPeople = Integer.parseInt(arr[4]);
                String typeOfRental = arr[5];
                String freeServiceIncluded = arr[6];
                int turn = Integer.parseInt(arr[7]);
                roomList.put(new Room(idService, serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                        freeServiceIncluded), turn);
            }
            br.close();
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e) {
            // TH file không tồn tại hoặc nội dung file có lỗi thì sẽ hiển thị thông báo lỗi.
            System.err.println("Read write error");
        }
        return roomList;
    }
    private void writeFacility(Facility f){
        try {
            String src = "";
            if (f instanceof Villa) {
                src = VILLA_SRC;
            } else if (f instanceof House) {
                src = HOUSE_SRC;
            } else if (f instanceof Room) {
                src = ROOM_SRC;
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
                String line = villa.getIdService()+ "," + villa.getServiceName() + "," + villa.getUsableArea() + "," +
                        villa.getRentalFee() + "," + villa.getNumOfPeople() + "," + villa.getTypeOfRental() + "," +
                        villa.getRoomStandards() + "," + villa.getSwimmingPoolArea() + "," + villa.getNumberOfFloors() +
                        ",0";
                bufferedWriter.write("\n" + line);
            } else if (f instanceof House) {
                House house = (House) f;
                String line = house.getIdService()+ "," + house.getServiceName() + "," + house.getUsableArea() + "," +
                        house.getRentalFee() + "," + house.getNumOfPeople() + "," + house.getTypeOfRental() + "," +
                        house.getRoomStandards() + "," + house.getNumberOfFloors() + ",0";
                bufferedWriter.write("\n" + line);
            } else if (f instanceof Room) {
                Room room = (Room) f;
                String line = room.getIdService()+ "," + room.getServiceName() + "," + room.getUsableArea() + "," +
                        room.getRentalFee() + "," + room.getNumOfPeople() + "," + room.getTypeOfRental() + "," +
                        room.getFreeServiceIncluded() + ",0";
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
                src = VILLA_SRC;
            } else if (Objects.equals(serviceName.split("-")[0], "SVHO")) {
                src = HOUSE_SRC;
            } else if (Objects.equals(serviceName.split("-")[0], "SVRO")) {
                src = ROOM_SRC;
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
                        String serviceNames = arr[0];
                        double usableArea = Double.parseDouble(arr[1]);
                        double rentalFee = Double.parseDouble(arr[2]);
                        int numOfPeople = Integer.parseInt(arr[3]);
                        String typeOfRental = arr[4];
                        String roomStandards = arr[5];
                        double swimmingPoolArea = Double.parseDouble(arr[6]);
                        int numberOfFloors = Integer.parseInt(arr[7]);
                        int turn = Integer.parseInt(arr[8]);
                        writer.write(serviceNames + "," + usableArea + "," + rentalFee + "," + numOfPeople + "," +
                                typeOfRental + "," + roomStandards + "," + swimmingPoolArea + "," +
                                numberOfFloors + "," + (++turn) + "\n");
                    } else {
                        writer.write(currentLine + "\n");
                    }
                }
                if (Objects.equals(serviceName.split("-")[0], "SVHO")){
                    if (Objects.equals(arr[0], serviceName)) {
                        String serviceNames = arr[0];
                        double usableArea = Double.parseDouble(arr[1]);
                        double rentalFee = Double.parseDouble(arr[2]);
                        int numOfPeople = Integer.parseInt(arr[3]);
                        String typeOfRental = arr[4];
                        String roomStandards = arr[5];
                        int numberOfFloors = Integer.parseInt(arr[6]);
                        int turn = Integer.parseInt(arr[7]);
                        writer.write(serviceNames + "," + usableArea + "," + rentalFee + "," + numOfPeople + "," +
                                typeOfRental + "," + roomStandards + "," + numberOfFloors + "," +
                                (++turn) + "\n");
                    } else {
                        writer.write(currentLine + "\n");
                    }
                }
                if (Objects.equals(serviceName.split("-")[0], "SVRO")){
                    if (Objects.equals(arr[0], serviceName)) {
                        String serviceNames = arr[0];
                        double usableArea = Double.parseDouble(arr[1]);
                        double rentalFee = Double.parseDouble(arr[2]);
                        int numOfPeople = Integer.parseInt(arr[3]);
                        String typeOfRental = arr[4];
                        String freeServiceIncluded = arr[5];
                        int turn = Integer.parseInt(arr[6]);
                        writer.write(serviceNames + "," + usableArea + "," + rentalFee + "," + numOfPeople + "," +
                                typeOfRental + "," + freeServiceIncluded + "," + (++turn)  + "\n");
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
    public String validate(String regex,String ip) {
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(ip);
        boolean isValid = matcher.matches();

        while (!isValid) {
            System.out.println("Format is incorrect, please re-enter!");
            ip = sc.nextLine();

            matcher = pattern.matcher(ip);
            isValid = matcher.matches();
        }

        return ip;
    }

    @Override
    public void addNew(Facility f) {
        try{
            if (facilityIntegerMap.containsKey(f)){
                throw new IllegalArgumentException("Facility already exists");
            }
            facilityIntegerMap.put(f, 0);
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
                select = Integer.parseInt(sc.nextLine());
                switch (select){
                    case 1:
                        System.out.println("You choose add new villa: ");
                        System.out.println("Enter a service's id: ");
                        String idService = validate(IDSERVICE_REGEX, sc.nextLine());
                        System.out.println("Enter a service's name: ");
                        String serviceName = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter a usable area: ");
                        double usableArea = Double.parseDouble(validate(AREA_REGEX, sc.nextLine()));
                        System.out.println("Enter a rental fee: ");
                        double rentalFee = Double.parseDouble(validate(FEE_REGEX, sc.nextLine()));
                        System.out.println("Enter a number of peoples: ");
                        int numOfPeople = Integer.parseInt(validate(NUMPEOPLE_REGEX, sc.nextLine()));
                        System.out.println("Enter a type of rental: ");
                        String typeOfRental = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter room standards: ");
                        String roomStandards = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter a swimming pool area: ");
                        double swimmingPoolArea = Double.parseDouble(validate(AREA_REGEX, sc.nextLine()));
                        System.out.println("Enter a number of floors: ");
                        int numberOfFloors = Integer.parseInt(validate(FEE_REGEX, sc.nextLine()));
                        Villa villa = new Villa(idService,serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                                roomStandards, swimmingPoolArea, numberOfFloors);
                        addNew(villa);
                        writeFacility(villa);
                        break;
                    case 2:
                        System.out.println("You choose add new house: ");
                        System.out.println("Enter a service's id: ");
                        idService = validate(IDSERVICE_REGEX, sc.nextLine());
                        System.out.println("Enter a service's name: ");
                        serviceName = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter a usable area: ");
                        usableArea = Double.parseDouble(validate(AREA_REGEX, sc.nextLine()));
                        System.out.println("Enter a rental fee: ");
                        rentalFee = Double.parseDouble(validate(FEE_REGEX, sc.nextLine()));
                        System.out.println("Enter a number of peoples: ");
                        numOfPeople = Integer.parseInt(validate(NUMPEOPLE_REGEX, sc.nextLine()));
                        System.out.println("Enter a type of rental: ");
                        typeOfRental = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter room standards: ");
                        roomStandards = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter a number of floors: ");
                        numberOfFloors = Integer.parseInt(validate(FEE_REGEX, sc.nextLine()));
                        House house = new House(idService, serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
                                roomStandards, numberOfFloors);
                        addNew(house);
                        writeFacility(house);
                        break;
                    case 3:
                        System.out.println("You choose add new room: ");
                        System.out.println("You choose add new house: ");
                        System.out.println("Enter a service's id: ");
                        idService = validate(IDSERVICE_REGEX, sc.nextLine());
                        System.out.println("Enter a service's name: ");
                        serviceName = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter a usable area: ");
                        usableArea = Double.parseDouble(validate(AREA_REGEX, sc.nextLine()));
                        System.out.println("Enter a rental fee: ");
                        rentalFee = Double.parseDouble(validate(FEE_REGEX, sc.nextLine()));
                        System.out.println("Enter a number of peoples: ");
                        numOfPeople = Integer.parseInt(validate(NUMPEOPLE_REGEX, sc.nextLine()));
                        System.out.println("Enter a type of rental: ");
                        typeOfRental = validate(SERVICENAME_REGEX, sc.nextLine());
                        System.out.println("Enter free service included: ");
                        String freeServiceIncluded = validate(SERVICENAME_REGEX, sc.nextLine());
                        Room room = new Room(idService, serviceName, usableArea, rentalFee, numOfPeople, typeOfRental,
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

    public static void main(String[] args) {
        BookingService bookingService = new BookingServiceImpl();
        bookingService.displayList();
    }
}
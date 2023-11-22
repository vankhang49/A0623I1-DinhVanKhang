package caseStudy.models;

public class Villa extends Facility{
    private String roomStandards;
    private double swimmingPoolArea;
    private int numberOfFloors;

    public Villa(String idService,String serviceName, double usableArea, double rentalFee, int numOfPeople, String typeOfRental,
                 String roomStandards, double swimmingPoolArea, int numberOfFloors) {
        super(idService, serviceName, usableArea, rentalFee, numOfPeople, typeOfRental);
        this.roomStandards = roomStandards;
        this.swimmingPoolArea = swimmingPoolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public double getSwimmingPoolArea() {
        return swimmingPoolArea;
    }

    public void setSwimmingPoolArea(double swimmingPoolArea) {
        this.swimmingPoolArea = swimmingPoolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String infoOfService() {
        return "ID service: " + getIdService() + ",\n" +
                "Service's name: " + getServiceName() + ",\n" +
                "Usable Area: " + getUsableArea() + "m²,\n" +
                "Rental fee: " + getRentalFee() + "$,\n" +
                "Number of people: " + getNumOfPeople() + ",\n" +
                "Type of rental: " + getTypeOfRental() + ",\n" +
                "Room Standard: " + getRoomStandards() + ",\n" +
                "Area of Swimming pool: " + getSwimmingPoolArea() + "m²,\n" +
                "Number of floors: " + getNumberOfFloors();
    }
}

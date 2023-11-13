package caseStudy.models;

public class House extends Facility{
    private String roomStandards;
    private int numberOfFloors;

    public House(String serviceName, double usableArea, double rentalFee, int numOfPeople, String typeOfRental
            , String roomStandards, int numberOfFloors) {
        super(serviceName, usableArea, rentalFee, numOfPeople, typeOfRental);
        this.roomStandards = roomStandards;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String infoOfService() {
        return "Service's name: " + getServiceName() + ",\n" +
                "Usable Area: " + getUsableArea() + "m²,\n" +
                "Rental fee: " + getRentalFee() + "$,\n" +
                "Number of people: " + getNumOfPeople() + ",\n" +
                "Type of rental: " + getTypeOfRental() + ",\n" +
                "Room Standard: " + getRoomStandards() + ",\n" +
                "Number of floors: " + getNumberOfFloors();
    }
}

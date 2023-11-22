package caseStudy.models;

public class Room extends Facility {
    private String freeServiceIncluded;

    public Room(String idService,String serviceName, double usableArea, double rentalFee, int numOfPeople, String typeOfRental,
                String freeServiceIncluded) {
        super(idService,serviceName, usableArea, rentalFee, numOfPeople, typeOfRental);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String infoOfService() {
        return "ID service: " + getIdService() + ",\n" +
                "Service's name: " + getServiceName() + ",\n" +
                "Usable Area: " + getUsableArea() + "m²,\n" +
                "Rental fee: " + getRentalFee() + "$,\n" +
                "Number of people: " + getNumOfPeople() + ",\n" +
                "Type of rental: " + getTypeOfRental() + ",\n" +
                "Free service included: " + getFreeServiceIncluded();
    }
}

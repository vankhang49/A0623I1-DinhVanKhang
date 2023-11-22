package caseStudy.models;

public abstract class Facility {
    private String idService;
    private String serviceName;
    private double usableArea;
    private double rentalFee;
    private int numOfPeople;
    private String typeOfRental;

    public Facility(String idService, String serviceName, double usableArea, double rentalFee, int numOfPeople, String typeOfRental) {
        this.idService = idService;
        this.serviceName = serviceName;
        this.usableArea =  usableArea;
        this.rentalFee = rentalFee;
        this.numOfPeople = numOfPeople;
        this.typeOfRental = typeOfRental;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getRentalFee() {
        return rentalFee;
    }

    public void setRentalFee(int rentalFee) {
        this.rentalFee = rentalFee;
    }

    public int getNumOfPeople() {
        return numOfPeople;
    }

    public void setNumOfPeople(int numOfPeople) {
        this.numOfPeople = numOfPeople;
    }

    public String getTypeOfRental() {
        return typeOfRental;
    }

    public void setTypeOfRental(String typeOfRental) {
        this.typeOfRental = typeOfRental;
    }
    public abstract String infoOfService();
}

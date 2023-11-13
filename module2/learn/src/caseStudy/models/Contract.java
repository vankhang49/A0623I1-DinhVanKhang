package caseStudy.models;

public class Contract {
    private int contractNumber;
    private String idBooking;
    private double deposit;
    private double totalPayment;
    private String idCustomer;

    public Contract(int contractNumber, String idBooking, double deposit, double totalPayment, String idCustomer) {
        this.contractNumber = contractNumber;
        this.idBooking = idBooking;
        this.deposit = deposit;
        this.totalPayment = totalPayment;
        this.idCustomer = idCustomer;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }
    public String infoContract(){
        return "Contract number: " + getContractNumber() + ",\n" +
                "Id booking: " + getIdBooking() + ",\n" +
                "Deposit: " + getDeposit() + "$,\n" +
                "Total payment: " + getTotalPayment() + "$,\n" +
                "Id of customer: " + getIdCustomer();
    }
}

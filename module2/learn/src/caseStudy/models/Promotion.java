package caseStudy.models;

public class Promotion {
    private String idCustomer;
    private int voucherPercentage;

    public Promotion(String idCustomer, int voucherPercentage) {
        this.idCustomer = idCustomer;
        this.voucherPercentage = voucherPercentage;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getVoucherPercentage() {
        return voucherPercentage;
    }

    public void setVoucherPercentage(int voucherPercentage) {
        this.voucherPercentage = voucherPercentage;
    }

    @Override
    public String toString() {
        return "idCustomer:'" + idCustomer + ", voucherPercentage: " + voucherPercentage;
    }
}

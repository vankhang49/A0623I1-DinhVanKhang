package caseStudy.models;

public class Booking {
    private String idBooking;
    private String beginDate;
    private String endDate;
    private String idCustomer;
    private String serviceName;
    private String serviceType;

    public Booking(String idBooking, String beginDate, String endDate, String idCustomer
            , String serviceName, String serviceType) {
        this.idBooking = idBooking;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.idCustomer = idCustomer;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String bookingInfo(){
        return "Id booking: " + getIdBooking() + ",\n" +
                "Begin date: " + getBeginDate() + ",\n" +
                "End date: " + getEndDate() + ",\n" +
                "Id of customer: " + getIdCustomer() + ",\n" +
                "Service name: " + getServiceName() + ",\n" +
                "Type of service: " + getServiceType();
    }

    @Override
    public int hashCode() {
        return this.beginDate.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}

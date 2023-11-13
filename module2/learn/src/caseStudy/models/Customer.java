package caseStudy.models;

public class Customer extends Person{
    private String typeOfGuest;
    private String address;

    public Customer(String id, String name, String born, String gender, String identifier
            , String phoneNumber, String email, String typeOfGuest, String address) {
        super(id, name, born, gender, identifier, phoneNumber, email);
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public String getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(String typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String inforPerson() {
        return "Id: " + getId() + ",\n" +
                "Employee's name: " + getName() + ",\n" +
                "Gender: " + getGender() + ",\n" +
                "Identifier: " + getIdentifier() + ",\n" +
                "Phone number: " + getPhoneNumber() + ",\n" +
                "Address email: " + getEmail() + ",\n" +
                "Type of customer: " + getTypeOfGuest() + ",\n" +
                "Address: " +getAddress();
    }
}

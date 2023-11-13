package caseStudy.models;

public abstract class Person {
    private String id;
    private String name;
    private String born;
    private String gender;
    private String identifier;
    private String phoneNumber;
    private String email;

    public Person(String id, String name, String born, String gender, String identifier, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.born = born;
        this.gender = gender;
        this.identifier = identifier;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String inforPerson();
}

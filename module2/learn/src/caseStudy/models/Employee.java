package caseStudy.models;

public class Employee extends Person implements Comparable<Employee> {
    private String level;
    private String position;
    private int salary;

    public Employee(String id, String name, String born, String gender, String identifier, String phoneNumber
            , String email, String level, String position, int salary) {
        super(id, name, born, gender, identifier, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String inforPerson() {
        return "Id: " + getId() + ",\n" +
                "Employee's name: " + getName() + ",\n" +
                "Gender: " + getGender() + ",\n" +
                "Identifier: " + getIdentifier() + ",\n" +
                "Phone number: " + getPhoneNumber() + ",\n" +
                "Address email: " + getEmail() + ",\n" +
                "Level: " + getLevel() + ",\n" +
                "Position: " + getPosition() + ",\n" +
                "Salary: " + getSalary();
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(o.getSalary(),this.getSalary());
    }
}

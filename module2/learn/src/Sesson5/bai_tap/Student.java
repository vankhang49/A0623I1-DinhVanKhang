package Sesson5.bai_tap;

public class Student {
    private String name = "John";
    private String classes = "C02";

    Student(){}
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getClasses(){
        return this.classes;
    }
    public void setClasses(String classes){
        this.classes = classes;
    }
}
class test{
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Alex");
        student1.setClasses("A06");
        Student student2 = new Student();
        student2.setName("Tom");
        student2.setClasses("A06");

        System.out.println("Student1's name is: " + student1.getName() + " and class " + student1.getClasses());
        System.out.println("Student2's name is: " + student2.getName() + " and class " + student2.getClasses());
    }
}
package Sesson5.thuc_hanh;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(111, "Khang");
        Student s2 = new Student(222, "Dung");
        Student s3 = new Student(333, "Thanh");

        s1.display();
        s2.display();
        s3.display();
    }
}
class Student{
    private int rollno;
    private String name;
    private static String college = "BBDIT";

    Student(int r, String n) {
        rollno = r;
        name = n;
    }
    static void change() {
        college = "CODEGYM";
    }
    void display() {
        System.out.println(rollno + " " + name + " " + college);
    }
}

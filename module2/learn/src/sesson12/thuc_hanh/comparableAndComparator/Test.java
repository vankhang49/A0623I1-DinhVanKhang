package sesson12.thuc_hanh.comparableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student("Kien", 30, "HT");
        Student student2 = new Student("Nam", 26, "HN");
        Student student3 = new Student("Anh", 38, "HT" );
        Student student4 = new Student("Tung", 38, "HT" );
        List<Student> lists = new ArrayList<>();
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        lists.add(student4);
        for (Student student: lists) {
            System.out.println(student.toString());
        }
        Collections.sort(lists);
        for (Student student: lists) {
            System.out.println(student.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        lists.sort(ageComparator);
        System.out.println("Compare students by age:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}

package sesson11.bai_tap.demergingUseQueue;

import java.util.*;

public class Demerging {
    public static void demerging(List<Personnel> list){
        Queue<Personnel> male = new LinkedList<>();
        Queue<Personnel> female = new LinkedList<>();
        for (Personnel item: list){
            if (item.getGender().equals("female")){
                female.offer(item);
            } else {
                male.offer(item);
            }
        }
        list.clear();
        list.addAll(female);
        list.addAll(male);
    }

    public static void main(String[] args) {
        Personnel person1 = new Personnel("Nguyễn Văn A", "male", "22");
        Personnel person2 = new Personnel("Lê Văn C", "male", "24");
        Personnel person3 = new Personnel("Bùi Thị G", "female", "23");
        Personnel person4 = new Personnel("Lê Gia D", "male", "21");
        Personnel person5 = new Personnel("Huỳnh Thị N", "female", "27");
        Personnel person6 = new Personnel("Ngô Văn B", "male", "30");
        List<Personnel> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        list.add(person6);
//        list.sort(Comparator.comparing(p -> p.getName().split(" ")[2])); //theo tên
//        list.sort((p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName())); // theo tên
        list.sort((p1, p2) -> p1.getBorn().compareTo(p2.getBorn())); // theo ngày tháng năm sinh

        demerging(list);
        System.out.println(list);
    }

}

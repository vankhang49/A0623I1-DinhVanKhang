package sesson7.thuc_hanh.comparable;

import java.util.Arrays;

public class ComparableCircleTest {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(5);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle(4.3, "indigo", false);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
//        for (int i = 0; i < circles.length - 1; i++){
//            int compare = circles[i].compareTo(circles[i+1]);
//            if(compare == 1){
//                ComparableCircle temp = circles[i];
//                circles[i] = circles [i+1];
//                circles[i+1] = temp;
//            }
//        }
        Arrays.sort(circles);
        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}

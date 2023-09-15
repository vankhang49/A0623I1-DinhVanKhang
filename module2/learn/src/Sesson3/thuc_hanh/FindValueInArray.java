package Sesson3.thuc_hanh;
import java.util.Scanner;
public class FindValueInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] students = {"Quý", "Thành", "Hoàn", "Phụng", "Mẫn", "Hoà", "Khang", "Dũng", "Minh"};
        System.out.print("Enter a name’s student:");
        String find_name = sc.nextLine();
        int index = -1;
        for(int i = 0; i<students.length; i++){
            if(students[i].equals(find_name)){
                index = i;
            }
        }
        if(index!= -1){
            System.out.println("Position of the students in the list " + find_name + " is: " + index);
        } else {
            System.out.println("Not found" + find_name + " in the list.");
        }
    }
}

package sesson3.thuc_hanh;
import java.util.Scanner;
public class MaxValueInArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = sc.nextInt();
            if (size > 20){System.out.println("Size does not exceed 20");}
        } while (size > 20);
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.print("Elements in array: ");
        for (int i : array) {
            System.out.print(i + "\t");
        }
        System.out.println(" ");
        int max = array[0];
        for (int j = 1; j < array.length; j++) {
            if(array[j]>max){
                max = array[j];
            }
        }
        System.out.println("Max value in array is " + max);
    }
}

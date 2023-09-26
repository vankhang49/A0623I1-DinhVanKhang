package sesson3.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class DeleteElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Enter a element that you need to remove: ");
        int x = sc.nextInt();
        int[] newArr = RemoveElement(arr, x);
        System.out.println(Arrays.toString(newArr));
    }

    public static int[] RemoveElement(int[] array, int element) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                index = i;
            }
        }
        if (index != -1) {
            for (int i = index; i < array.length-1; i++) {
                array[i] = array[i + 1];
                array[i + 1] = 0;
            }
        } else {
            System.out.println("Could not find the element to delete!");
        }
        return array;
    }
}

package sesson13.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] array, int left, int right ,int value){
        while (right>=left){
            int middle = (left + right)/2;
            if (value < array[middle]){
                return binarySearch(array, left, middle - 1, value);
            } else if (value == array[middle]){
                return middle;
            } else {
                return binarySearch(array, middle + 1, right, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a size of array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++){
            System.out.println("Enter value for index " + i);
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter a value you want to find: ");
        int value = sc.nextInt();
        int index  = binarySearch(arr, 0, size - 1, value);
        if (value != -1){
            System.out.println(value + " is found at index " + index + " in array");
        } else {
            System.out.println("Value not found!");
        }
    }
}

package sesson15.thuc_hanh;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample {
    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List elements of array: " );
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i]+ " ");
        }
        return arr;
    }
    public static void main(String[] args) {
        ArrayExample arrExample = new ArrayExample();
        Integer[] arr = arrExample.createRandom();

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter a index of any element: ");
        int x = sc.nextInt();
        try {
            System.out.println("Value of element has index " + x + " is " + arr[x]);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("The index exceeds the bounds of the array");
        }
    }
}

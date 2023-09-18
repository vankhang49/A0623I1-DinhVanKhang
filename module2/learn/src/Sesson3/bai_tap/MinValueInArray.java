package Sesson3.bai_tap;

import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class MinValueInArray {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter a length of array: ");
        int x = sc.nextInt();
        int[] arr = newArr(x);
        int min = minValue(arr);
        System.out.println("Min value in array " + Arrays.toString(arr) + " is " + min);

    }
    public static int[] newArr(int length){
        int[] array = new int[length];
        System.out.println("Let's enter " + length + " element!");
        for (int i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static int minValue(int[] array){
        int min = array[0];
        for (int i = 1;i<array.length;i++){
            if(array[i]<min){
                min = array[i];
            }
        }
        return min;
    }
}

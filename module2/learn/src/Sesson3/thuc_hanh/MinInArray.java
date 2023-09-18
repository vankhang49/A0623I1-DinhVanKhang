package Sesson3.thuc_hanh;

import java.util.Arrays;

public class MinInArray {
    public static void main(String[] args) {
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("Min value in array " + Arrays.toString(arr) + " is " + arr[index]);

    }
    public static int minValue(int[] array){
        int index = 0;
        for (int i = 1;i<array.length;i++){
            if(array[i]<array[index]){
                index = i;
            }
        }
        return index;
    }
}

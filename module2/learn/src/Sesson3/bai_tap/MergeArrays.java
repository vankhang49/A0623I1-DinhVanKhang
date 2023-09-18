package Sesson3.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class MergeArrays {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Let's create the first array!");
        System.out.println("Enter length of first array: ");
        int length1 = sc.nextInt();
        int[] arr1 = newArr(length1);
        System.out.println("Let's create the second array!");
        System.out.println("Enter length of second array: ");
        int length2 = sc.nextInt();
        int[] arr2 = newArr(length2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        int[] merge = mergeArr(arr1, arr2);
        System.out.println("Array after merge: ");
        System.out.println(Arrays.toString(merge));
    }
    public static int[] newArr(int length){
        int[] array = new int[length];
        System.out.println("Let's enter " + length + " element!");
        for (int i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
        }
        return array;
    }
    public static int[] mergeArr(int[] firstArray, int[] secondArray){
        int[] newArr = new int[firstArray.length + secondArray.length];
        for(int i = 0; i<firstArray.length;i++){
            newArr[i] = firstArray[i];
        }
        for(int i = firstArray.length, j = 0; i<newArr.length;i++, j++){
                newArr[i] = secondArray[j];
        }
        return newArr;
    }
}

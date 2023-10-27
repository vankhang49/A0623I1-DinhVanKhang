package sesson13.thuc_hanh;

import java.util.Arrays;

public class BinarySearch {
    public static int[] list = {4, 7, 2, 10, 66, 60, 50, 59, 79, 11, 69, 45, 70};
    public static int binarySearch(int[] arr, int value){
        int left = 0;
        int right = arr.length - 1;
        while (right >= left){
            int mid = (left + right)/2;
            if (value < arr[mid]){
                right = mid - 1;
            } else if (value == arr[mid]) {
                return mid;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));

        // find value in array
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 66));
        System.out.println(binarySearch(list, 61));
        System.out.println(binarySearch(list, 79));
        System.out.println(binarySearch(list, 45));
        System.out.println(binarySearch(list, 54));
    }
}

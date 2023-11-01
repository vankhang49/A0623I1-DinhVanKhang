package sesson14.bai_tap;

import java.util.Arrays;

public class InsertionSortByStep {
    public static void insertionSort(int[] array){
        int exc, x;
        for(int i = 1; i < array.length; i++){ //Skip the first element
            //starting with the second element
            x = array[i];
            exc = i;
            if (x > array[exc-1]){
                System.out.println(array[exc-1] + " < " + x + ", don't swap");
            } else {
                System.out.println(Arrays.toString(array));
            }
            /* Swap array[exc] with array[exc - 1] */
            while(exc > 0 && x < array[exc-1]){
                System.out.println("Assign the value " + array[exc] + " of index " + exc +
                        " to the value " +  array[exc-1] + " of index " + (exc - 1));
                array[exc] = array[exc-1];
                exc--;
                System.out.println(Arrays.toString(array));
            }
            if (array[exc] != x){
                System.out.println("Assign the value of index " + exc + " to the value " + x);
            }
            array[exc] = x;
        }
    }
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        insertionSort(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}

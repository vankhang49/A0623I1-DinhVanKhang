package sesson14.bai_tap;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        int exc, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            exc = i;
            while (exc > 0 && x < array[exc - 1]) {
                array[exc] = array[exc - 1];
                exc--;
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

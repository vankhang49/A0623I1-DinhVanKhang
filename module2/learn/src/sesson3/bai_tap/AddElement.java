package sesson3.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class AddElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println("Enter an element you want to add: ");
        int x = sc.nextInt();
        System.out.println("Enter the location you want to add: ");
        int index = sc.nextInt();
        int[] arr1 = pushElement(arr, x, index);
        System.out.println(Arrays.toString(arr1));
    }
    public static int[] pushElement(int[] array, int element, int index){
        if(index < 1 || index > array.length){
            System.out.println("Cannot add element because element position is outside the size of the array!");
            return array;
        } else {
            int[] newArr = new int[array.length+1];
            for (int i = 0; i<array.length; i++){
                newArr[i] = array[i];
            }
            for (int i = newArr.length-1; i > index-1;i--){
                newArr[i] = newArr[i-1];
                newArr[i-1] = element;
            }
            return newArr;
        }
    }
}

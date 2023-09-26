package sesson3.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class totalMainDiagonal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = newArr();
        for(int[] item: arr){
            System.out.println(Arrays.toString(item));
        }
        int total = sumofMainDiagonals(arr);
        System.out.println("Sum of main diagonal is " + total);
    }
    public static int[][] newArr(){
        System.out.println("Enter the length of array: ");
        int length = sc.nextInt();
        int[][] array = new int[length][length];
        System.out.println("Let's add elements for array!");
        for (int i = 0; i < array.length; i++){
            for(int j = 0; j<array[i].length; j++){
                System.out.print("array["+ i + "][" + j + "] = ");
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }
    public static int sumofMainDiagonals(int[][] array){
        int total = 0;
        for (int i = 0; i < array.length; i++){
            total += array[i][i];
        }
        return total;
    }
}

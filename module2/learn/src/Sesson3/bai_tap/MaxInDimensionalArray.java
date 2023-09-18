package Sesson3.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class MaxInDimensionalArray {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = newArr();
        for(int[] item: arr){
            System.out.println(Arrays.toString(item));
        }
        int[] max = maxValue(arr);
        System.out.println("Max value of array is " + max[0]
                + " found in row " + max[1] + ", column " + max[2]);
    }
    public static int[][] newArr(){
        System.out.println("Enter the row number: ");
        int row = sc.nextInt();
        System.out.println("Enter the column number: ");
        int column = sc.nextInt();
        int[][] array = new int[row][column];
        System.out.println("Let's add elements for array!");
        for (int i = 0; i < row; i++){
            for(int j = 0; j<column; j++){
                System.out.print("array["+ i + "][" + j + "] = ");
                array[i][j] = sc.nextInt();
            }
        }
        return array;
    }
    public static int[] maxValue(int[][] array){
        int[] result = new int[3];
        int max = 0;
        int indexOfRow = -1;
        int indexOfColumn = -1;
        for (int i = 0; i<array.length; i++){
            for (int j = 0; j< array[i].length; j++){
                if(array[i][j]>max){
                    max = array[i][j];
                    indexOfRow = i;
                    indexOfColumn = j;
                }
            }
        }
        result[0] = max;
        result[1] = indexOfRow;
        result[2] = indexOfColumn;
        return result;
    }
}

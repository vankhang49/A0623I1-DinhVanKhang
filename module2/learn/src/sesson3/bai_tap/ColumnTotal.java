package sesson3.bai_tap;
import java.util.Arrays;
import java.util.Scanner;
public class ColumnTotal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double[][] arr = newArr();
        for (double[] item: arr){
            System.out.println(Arrays.toString(item));
        }
        System.out.println("Enter a column that you want to total: ");
        int column = sc.nextInt();
        double sumOfColumn = sumOfColumn(arr,column);
        System.out.println("Sum of column " + column + " is "+ sumOfColumn);
    }
    public static double[][] newArr(){
        System.out.println("Enter the row number: ");
        int row = sc.nextInt();
        System.out.println("Enter the column number: ");
        int column = sc.nextInt();
        double[][] array = new double[row][column];
        System.out.println("Let's add elements for array!");
        for (int i = 0; i < row; i++){
            for(int j = 0; j<column; j++){
                System.out.print("array["+ i + "][" + j + "] = ");
                array[i][j] = sc.nextDouble();
            }
        }
        return array;
    }
    public static double sumOfColumn(double[][] array, int column){
        double sum = 0;
        for(int i = 0; i<array.length; i++){
            sum += array[i][column];
        }
        return sum;
    }
}

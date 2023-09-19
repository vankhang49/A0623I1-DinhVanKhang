package Sesson4.bai_tap;
import java.util.Scanner;
public class UseStopwatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a length of array: ");
        int length = sc.nextInt();
        int[] arr = createArray(length);
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        selectionSort(arr);
        stopwatch.stop();
        System.out.println("The execution time of the selection sort algorithm is: "+ stopwatch.getElapsedTime() + "ms");
    }
    public static void selectionSort(int[] arr){
        int size = arr.length;
        for (int i = 0; i <  size - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < size; j++)
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    public static int[] createArray(int length){
        int[] array = new int[length];
        for (int i = 0; i <array.length; i++) {
            array[i]=(int)(Math.random()*length);
        }
        return array;
    }
}
class Stopwatch{
    private long startTime;
    private long endTime;
    public Stopwatch(){
        startTime = System.currentTimeMillis();
    }
    public long getStarTime(){
        return startTime;
    }
    public long getEndTime(){
        return endTime;
    }
    public void start(){
        startTime = System.currentTimeMillis();
    }
    public void stop(){
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return endTime - startTime;
    }
}

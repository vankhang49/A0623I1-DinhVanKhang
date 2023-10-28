package sesson13.thuc_hanh;

import java.util.Scanner;

public class Complexity {
    public static int[] frequency(String str){
        int[] frequentChar = new int[255];
        for (int i = 0; i < str.length(); i++){
            int ascii = (int) str.charAt(i);
            frequentChar[ascii]++;
        }
        return frequentChar;
    }
    public static char maxFrequency(int[] arr){
        int max = 0;
        char character = (char) 255;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
                character = (char) i;
            }
        }
        return character;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
        int[] asciiArr = frequency(inputString);
        char frequentChar = maxFrequency(asciiArr);
        System.out.println("The most appearing letter is '" + frequentChar + "' with a frequency of " + asciiArr[(int) frequentChar] + " times");
    }
}

/*********************************************************************
 *             Độ phức tạp của thuật toán                            *
 *      * Thuật toán tìm tần suất xuất hiện của ký tự:               *
 *        1 vòng lặp: O(n)                                           *
 *      * Thuật toán tìm tần suất xuất hiện lớn nhất:                *
 *        1 vòng lặp * 1 câu lệnh rẽ nhánh: O(n*1) = O(n)            *
 *        với số lần lặp là 255 tức O(n) = O(255)                    *
 *      T(n) = O(n) + O(255)                                         *
 *      *TH1: Khi n <= 255 (n là độ dài của chuỗi ký tự)             *
 *      => T(n) = O(255 + n)                                         *
 *      *TH2: Khi n > 255 (n là độ dài của chuỗi ký tự)              *
 *      => T(n) = O(n)                                               *
 *********************************************************************/

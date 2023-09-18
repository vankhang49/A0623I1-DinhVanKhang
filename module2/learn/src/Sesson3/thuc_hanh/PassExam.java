package Sesson3.thuc_hanh;

import java.util.Scanner;

public class PassExam {
    public static void main(String[] args) {
        int size;
        double[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size:");
            size = sc.nextInt();
            if (size > 30)
                System.out.println("Size should not exceed 30");
        } while (size > 30);
        array = new double[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Enter a mark for student " + (i + 1) + ": ");
            array[i] = sc.nextDouble();
        }
        int count = 0;
        System.out.print("List of mark: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
            if (array[j] >= 5 && array[j] <= 10){
                count++;
            }
        }
        System.out.print("\n The number of students passing the exam is " + count);
    }
}

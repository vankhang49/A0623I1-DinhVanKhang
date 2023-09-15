package Sesson2.thuc_hanh;
import java.util.Scanner;
public class Profit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the lending amount: ");
        int loan = sc.nextInt();
        System.out.println("Enter the monthly interest rate: ");
        double rate = sc.nextDouble();
        System.out.println("Enter the number of loan months: ");
        int month = sc.nextInt();
        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += loan*(rate/100)/12 * month;
        }
        System.out.println("Amount obtained after" + month + " months of loan:" + totalInterest + " VND");
    }
}

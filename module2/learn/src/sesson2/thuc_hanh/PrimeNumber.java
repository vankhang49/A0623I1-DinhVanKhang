package sesson2.thuc_hanh;
import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number that you want to check: ");
        int num = sc.nextInt();
        if(num<=1){
            System.out.println(num + " is not a prime number");
        } else {
            if(num == 2){
                System.out.println(num + " is a prime number");
            } else {
                boolean flag = true;
                for(int i = 2; i<= Math.sqrt(num); i++){
                    if (num % i == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    System.out.println(num + " is a prime number");
                }else {
                    System.out.println(num + " is not a prime number");
                }
            }
        }
    }
}

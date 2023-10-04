package sesson8.thuc_hanh;

import java.util.Scanner;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if(isFizz && isBuzz)
            return "FizzBuzz";

        if(isFizz)
            return "Fizz";

        if(isBuzz)
            return "Buzz";

        return number + "";
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sn.nextInt();
        while (number !=0){
            String str = fizzBuzz(number);
            System.out.println(str);
            number = sn.nextInt();
        }
    }
}

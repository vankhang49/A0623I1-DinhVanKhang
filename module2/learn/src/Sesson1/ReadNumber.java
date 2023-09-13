package Sesson1;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        String read = "";
        if (num >= 0 && num <=10){
            switch (num){
                case 1:
                    read ="one";
                    break;
                case 2:
                    read ="two";
                    break;
                case 3:
                    read = "three";
                    break;
                case 4:
                    read = "four";
                    break;
                case 5:
                    read ="five";
                    break;
                case 6:
                    read = "six";
                    break;
                case 7:
                    read = "seven";
                    break;
                case 8:
                    read = "eight";
                    break;
                case 9:
                    read = "night";
                    break;
                case 10:
                    read = "ten";
                    break;

            }
        } else if(num < 20){
            if(num < 16){
                switch (num){
                    case 11:
                        read = "eleven";
                        break;
                    case 12:
                        read = "twelve";
                        break;
                    case 13:
                        read = "thirteen";
                        break;
                    case 14:
                        read = "fourteen";
                        break;
                    case 15:
                        read = "fifteen";
                        break;
                }
            }else {
                read
            }
        }


        System.out.println(read);
    }
}

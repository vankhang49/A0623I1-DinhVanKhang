package Sesson1.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (0-999): ");
            String input = sc.nextLine();
            while (!(input.matches("[0-9]") ||
                    input.matches("[0-9][0-9]") ||
                    input.matches("[1-9][0-9][0-9]"))) {
                System.out.println("invalid!");
                System.out.print("Enter a number (0-999): ");
                input = sc.nextLine();
                System.out.println(input);
            }
            String[] inputRay = input.split("");
            switch (inputRay.length) {
                case 1:
                    if (inputRay[0].equals("0")) {
                        System.out.println("zero");
                    } else {
                        System.out.println(tenDown(inputRay[0]));
                    }
                    break;
                case 2:
                    System.out.println(tenUp(inputRay[0], tenDown(inputRay[1])));
                    break;
                case 3:
                    if ((inputRay[1].equals("0")) && (inputRay[2].equals("0"))) {
                        System.out.println(hundredUp(inputRay[0]));
                    } else {
                        System.out.print(hundredUp(inputRay[0]));
                        System.out.print(" and " + tenUp(inputRay[1], tenDown(inputRay[2])) + "\n");
                    }
            }
        }

    }
    private static String tenDown (String number){
        switch (number) {
            case "0":
                return "";
            case "1":
                return "one";
            case "2":
                return "two";
            case "3":
                return "three";
            case "4":
                return "four";
            case "5":
                return "five";
            case "6":
                return "six";
            case "7":
                return "seven";
            case "8":
                return "eight";
            case "9":
                return "nine";
            default:
                return "can't read this";
        }
    }
    private static String tenUp(String number, String previous) {
        switch (number) {
            case "0":
                return previous;
            case "1":
                switch (previous) {
                    case "":
                        return "ten";
                    case "one":
                        return "eleven";
                    case "two":
                        return "twelve";
                    case "three":
                        return "thirteen";
                    default:
                        return previous + "teen";
                }
            case "2":
                return "twenty " + previous;
            case "3":
                return "thirty " + previous;
            case "5":
                return "fifty" + previous;
            default:
                return tenDown(number) + "ty" + " " + previous;

        }
    }

    private static String hundredUp(String number) {
        return tenDown(number) + " hunred";
    }
}

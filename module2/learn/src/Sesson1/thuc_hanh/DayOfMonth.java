package Sesson1.thuc_hanh;

import java.util.Scanner;
public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Which month that you want to count days? ");
        int month = scanner.nextInt();
        String dayInMonth;
        if(month<1 || month>12){
            dayInMonth = "";
        }else {
            switch (month){
                case 2:
                    dayInMonth = "28 or 29";
                    break;
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    dayInMonth = "31";
                    break;
                default:
                    dayInMonth = "30";
            }
        }
        if (!dayInMonth.isEmpty()){
            System.out.println("The month '" + month + "' has " + dayInMonth + " days!");
        }else {
            System.out.println("ERROR!");
        }

    }
}

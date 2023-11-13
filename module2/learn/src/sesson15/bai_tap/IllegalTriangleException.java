package sesson15.bai_tap;

import java.util.Scanner;

public class IllegalTriangleException extends Throwable {
    public static void input() throws IllegalTriangleException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter edge a: ");
        double a = sc.nextDouble();
        System.out.println("Enter edge b: ");
        double b = sc.nextDouble();
        System.out.println("Enter edge c: ");
        double c = sc.nextDouble();
        if(a <= 0 || b <= 0 || c <= 0){
            throw new IllegalTriangleException();
        }else if (a + b <= c || b + c <= a || a + c <= b){
            throw new IllegalTriangleException();
        }
    }

    public static void main(String[] args) {
        try{
            input();
        }
        catch (IllegalTriangleException e){
            System.out.println("Illegal!");
        }
    }
}

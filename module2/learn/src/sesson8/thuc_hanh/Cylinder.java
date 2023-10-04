package sesson8.thuc_hanh;

import java.util.Scanner;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }
    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("Enter a radius");
        int radius = sn.nextInt();
        System.out.println("Enter a height");
        int height = sn.nextInt();
        double volume = getVolume(radius, height);
        System.out.println("Volumn is " + volume);
    }
}

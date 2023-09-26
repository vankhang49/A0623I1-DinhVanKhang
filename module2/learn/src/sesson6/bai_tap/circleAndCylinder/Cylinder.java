package sesson6.bai_tap.circleAndCylinder;

import java.util.concurrent.CyclicBarrier;

public class Cylinder extends Circle {
    private double height;
    public Cylinder(){
        height = 1;
    }
    public Cylinder(double height, double radius, String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea()*height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height = "+ getHeight()
                + " and bottom Radius = " + super.getRadius()
                + ", which is a subclass of " + super.toString();
    }
}

class CylinderTest{
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(7, 5, "Yellow");
        System.out.println(cylinder);
    }
}
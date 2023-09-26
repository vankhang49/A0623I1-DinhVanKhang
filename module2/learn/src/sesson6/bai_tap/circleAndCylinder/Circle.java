package sesson6.bai_tap.circleAndCylinder;

public class Circle {
    private double radius;
    private String color;
    public Circle(){
        radius = 1;
        color = "black";
    }
    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return radius*radius*Math.PI;
    }
    public String toString(){
        return "A Circle with radius is " + getRadius()
                + " and color " + getColor()
                + " have Area is " + getArea();
    }
}
class CircleTest{
    public static void main(String[] args) {
        Circle circle = new Circle(5, "pink-pastel");
        System.out.println(circle);
    }
}

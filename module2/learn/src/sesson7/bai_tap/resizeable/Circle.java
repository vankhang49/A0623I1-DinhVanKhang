package sesson7.bai_tap.resizeable;

public class Circle extends Shape implements Resizeable{
    private double radius;
    public Circle(){
        this.radius = 1.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return radius*radius*Math.PI;
    }
    @Override
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }
    @Override
    public void resize(double percent) {
        setRadius(getRadius()*(1+percent));
    }

    @Override
    public String toString() {
        return "The circle has radius = " + getRadius()
                + ", perimeter = " + getPerimeter()
                + " and area = " + getArea();
    }
}
class CircleTest{
    public static void main(String[] args) {
        Circle circle = new Circle(2);
        System.out.println(circle);
        circle.resize(0.7);
        System.out.println("\n" + circle);
    }
}

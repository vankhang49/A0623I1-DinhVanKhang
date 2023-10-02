package sesson7.bai_tap.colorable;

public class Circle extends Shape{
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
    public String toString() {
        return "The circle has radius = " + getRadius()
                + ", perimeter = " + getPerimeter()
                + " and area = " + getArea();
    }
}

package sesson6.thuc_hanh;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(4.7);
        System.out.println(circle);

        circle = new Circle(4.7, "violet", false);
        System.out.println(circle);
    }
}
class Circle extends Shape{
    private double radius;
    public Circle(){
        radius = 1;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius, String color, boolean filled){
        super(color, filled);
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter(){
        return 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + getRadius()
                + ", which is a subclass of " + super.toString();
    }
}
package sesson5.bai_tap;

public class Circle {
    private double radius = 1;
    private String color = "red";
    Circle(){}
    Circle(double r){
        this.radius = r;
    }
    public double getRadius(){
        return this.radius;
    }
    public String getColor(){
        return this.color;
    }
}
class TestCircle{
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Circle radius: " + circle.getRadius() + ", color: " + circle.getColor());
    }
}
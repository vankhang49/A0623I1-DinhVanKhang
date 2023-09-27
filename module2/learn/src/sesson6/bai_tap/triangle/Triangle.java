package sesson6.bai_tap.triangle;

public class Triangle extends Shape {
    private double side1, side2, side3;
    public Triangle(){
        this.side1 = 1;
        this.side2 = 1;
        this.side3 = 1;
    }
    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1() {
        return side1;
    }
    public void setSide1(double side1) {
        this.side1 = side1;
    }
    public double getSide2() {
        return side2;
    }
    public void setSide2(double side2) {
        this.side2 = side2;
    }
    public double getSide3() {
        return side3;
    }
    public void setSide3(double side3) {
        this.side3 = side3;
    }
    public double getArea(){
        //Nửa chu vi tam giác
        double p = getPerimeter()/2;
        //công thức Heron
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }
    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                "} has Area = " + getArea() +
                " and Perimeter = " + getPerimeter();
    }
}
class TriangleTest{
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle);
        triangle = new Triangle(3,4,5);
        System.out.println(triangle);
    }
}

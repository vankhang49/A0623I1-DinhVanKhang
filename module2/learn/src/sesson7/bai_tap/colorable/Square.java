package sesson7.bai_tap.colorable;

public class Square extends Shape implements Colorable{
    private double side;
    public Square(){
        this.side = 1.0;
    }
    public Square(double side){
        this.side = side;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public double getArea() {
        return side*side;
    }
    @Override
    public double getPerimeter() {
        return side*4;
    }
    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }
    @Override
    public String toString() {
        return "The square has side = " + getSide() +
                ", perimeter = " + getPerimeter() +
                " and area = " + getArea();
    }
}
class SquareTest {
    public static void main(String[] args) {
        Square square = new Square(5);
        System.out.println(square);
        square.howToColor();
    }
}

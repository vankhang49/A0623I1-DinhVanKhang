package sesson7.bai_tap.resizeable;

public class Rectangle extends Shape implements Resizeable{
    private double length, width;
    public Rectangle(){
        this.length = 1.0;
        this.width = 1.0;
    }
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public double getArea() {
        return length*width;
    }
    @Override
    public double getPerimeter() {
        return (length+width)*2;
    }
    @Override
    public void resize(double percent) {
        setWidth(getWidth()*(1+percent));
        setLength(getLength()*(1+percent));
    }
    @Override
    public String toString() {
        return "The rectangle has length = " + getLength() +
                " and width = " + getWidth() +
                ", perimeter = " + getPerimeter() +
                " and area = " + getArea();
    }
}
class RectangleTest{
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(7, 5);
        System.out.println(rectangle);
        rectangle.resize(0.7);
        System.out.println("\n" + rectangle);
    }
}

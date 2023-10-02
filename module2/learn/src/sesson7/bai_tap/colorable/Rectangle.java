package sesson7.bai_tap.colorable;

public class Rectangle extends Shape{
    private double width, length;
    public Rectangle(){
        this.width = 1.0;
        this.length = 1.0;
    }
    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public double getArea() {
        return width*length;
    }
    @Override
    public double getPerimeter() {
        return (width+length)*2;
    }
    @Override
    public String toString() {
        return "The rectangle has length = " + getLength() +
                " and width = " + getWidth() +
                ", perimeter = " + getPerimeter() +
                " and area = " + getArea();
    }
}

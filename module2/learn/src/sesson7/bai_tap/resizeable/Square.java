package sesson7.bai_tap.resizeable;

public class Square extends Shape implements Resizeable{
    private double edge;
    public Square(){
        this.edge = 1.0;
    }
    public Square(double edge){
        this.edge = edge;
    }
    public double getEdge() {
        return edge;
    }
    public void setEdge(double edge) {
        this.edge = edge;
    }
    @Override
    public double getArea() {
        return edge*edge;
    }
    @Override
    public double getPerimeter() {
        return edge*4;
    }
    @Override
    public void resize(double percent) {
        setEdge(getEdge()*(1+percent));
    }
    @Override
    public String toString() {
        return "The rectangle has edge = " + getEdge() +
                ", perimeter = " + getPerimeter() +
                " and area = " + getArea();
    }
}
class SquareTest{
    public static void main(String[] args) {
        Square square = new Square(5);
        System.out.println(square);
        square.resize(0.7);
        System.out.println("\n" + square);
    }
}

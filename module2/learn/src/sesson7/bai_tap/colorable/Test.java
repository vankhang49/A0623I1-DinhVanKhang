package sesson7.bai_tap.colorable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle(4.7);
        shapes[1] = new Rectangle(3.5, 7);
        shapes[2] = new Square(4);
        shapes[3] = new Circle();
        shapes[4] = new Square();

        for (Shape item: shapes){
            System.out.println(item);
            if(item instanceof Colorable){
                ((Colorable) item).howToColor();
            }
        }
    }
}

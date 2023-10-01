package sesson7.bai_tap.resizeable;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapeArr = new Shape[5];
        shapeArr[0] = new Circle(3.6);
        shapeArr[1] = new Rectangle(7, 5);
        shapeArr[2] = new Square(4.5);
        shapeArr[3] = new Circle();
        shapeArr[4] =new Square(5.2);

        System.out.println("Before resize: ");
        for(Shape item: shapeArr){
            System.out.println(item);
        }
        for (Shape item: shapeArr){
            ((Resizeable) item).resize((Math.random()*100 - 1)/100);
        }
        System.out.println("\n" + "After resize");
        for (Shape item: shapeArr){
            System.out.println(item);
        }
    }
}

package sesson6.bai_tap.point2DAndPoint3D;

import java.util.Arrays;

public class Point2D {
    private float x, y;
    public Point2D(){
    }
    public Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public float[] getXY(){
        return new float[]{x, y};
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point has coordinates (x, y): " + Arrays.toString(getXY());
    }
}
class Point2DTest{
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        point2D = new Point2D(5.8f, 7.3f);
        System.out.println(point2D);
    }
}

package sesson6.bai_tap.pointAndMovablePoint;

import java.util.Arrays;

public class Point {
    private float x, y;
    public Point(){
    }
    public Point(float x, float y){
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
        return "Point2D has coordinates [x, y]: " + Arrays.toString(getXY());
    }
}
class PointTest{
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point = new Point(5.2f, 3.9f);
        System.out.println(point);
    }
}

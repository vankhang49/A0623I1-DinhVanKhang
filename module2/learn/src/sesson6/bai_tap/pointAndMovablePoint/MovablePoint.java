package sesson6.bai_tap.pointAndMovablePoint;

import java.util.Arrays;

public class MovablePoint extends Point {
    private float xSpeed, ySpeed;
    public MovablePoint(){
    }
    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float getXSpeed() {
        return xSpeed;
    }
    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }
    public float getYSpeed() {
        return ySpeed;
    }
    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed(){
        return new float[] {xSpeed, ySpeed};
    }
    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return super.toString() + " and has speed [xSpeed, ySpeed]: " + Arrays.toString(getSpeed());
    }
    public MovablePoint move(){
        super.setX(super.getX() + this.xSpeed);
        super.setY(super.getY() + this.ySpeed);
        return this;
    }
}
class MovablePointTest{
    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(2.4f, 3);
        System.out.println(movablePoint);

        movablePoint = new MovablePoint(5, 7, 2.4f, 3);
        System.out.println(movablePoint);
    }
}

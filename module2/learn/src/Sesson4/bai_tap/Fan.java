package Sesson4.bai_tap;

public class Fan {
    public static final int SLOW = 1, MEDIUM = 2, FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;
    public Fan(){
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }
    public int getSpeed(){
        return this.speed;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public boolean getStatus(){
        return this.on;
    }
    public void setStatus(boolean on){
        this.on = on;
    }
    public double getRadius(){
        return this.radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String getColor(){
        return this.color;
    }
    public void setColor(String color){
        this.color = color;
    }
    public String toString(){
        if(this.on){
            return "Fan is on, speed: " + this.getSpeed() + ", color: " + this.getColor()
                    + " and radius: "+ this.getRadius();
        } else {
            return "Fan is off, color: " + this.getColor() + " and radius: "+ this.getRadius();
        }
    }

    public static void main(String[] args) {
        Fan panasonic = new Fan();
        panasonic.setStatus(true);
        panasonic.setColor("green");
        panasonic.setSpeed(FAST);
        panasonic.setRadius(6.9);

        Fan lifan = new Fan();
        lifan.setStatus(false);
        lifan.setSpeed(MEDIUM);
        lifan.setRadius(5.67);
        lifan.setColor("silver");

        System.out.println("Information of Panasonic Fan: " + panasonic.toString());
        System.out.println("Information of Lifan Fan: " + lifan.toString());
    }
}

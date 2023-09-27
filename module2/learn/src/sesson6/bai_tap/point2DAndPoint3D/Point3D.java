package sesson6.bai_tap.point2DAndPoint3D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;
    public Point3D(){};
    public Point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }
    public float getZ() {
        return z;
    }
    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ() {
        return new float[]{super.getX(), super.getY(), z};
    }
    public void setXYZ(float x, float y, float z){
        super.setX(x);
        super.setY(y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D has a coordinates (x,y,z): " + Arrays.toString(getXYZ())
                + " which is a subclass of " + super.toString();
    }
}

class Point3DTest{
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println();

        point3D = new Point3D(5, 7.6f, 3.5f);
        System.out.println(point3D);
    }
}

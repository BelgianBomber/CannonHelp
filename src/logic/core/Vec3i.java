package logic.core;


//This class is used to have a more compact way of storing block positions as 3 integers for x, y and z
public class Vec3i {
    int x;
    int y;
    int z;

    public Vec3i(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return  "Vec3{x=" + x +
                ", y=" + y +
                ", z=" + z + '}';
    }
}

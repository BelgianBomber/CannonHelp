package logic.core;

//This class is used to have a more compact way of storing block positions as 3 doubles for x, y and z
public class Vec3 {
    double x;
    double y;
    double z;

    public Vec3() {

    }

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(double y) {
        this.x = 0.0D;
        this.y = y;
        this.z = 0.0D;
    }

    //calculates the distance between two positions in 3d
    public double distanceTo(Vec3 otherVec3) {
        double xDifference = otherVec3.x - this.x;
        double yDifference = otherVec3.y - this.y;
        double zDifference = otherVec3.z - this.z;
        return Math.sqrt(xDifference * xDifference + yDifference * yDifference + zDifference * zDifference);
    }

    public double xDistance(Vec3 otherVec3) {
        return otherVec3.getX() - this.getX();
    }

    public double yDistance(Vec3 otherVec3) {
        return otherVec3.getY() - this.getY();
    }

    public double zDistance(Vec3 otherVec3) {
        return otherVec3.getZ() - this.getZ();
    }

    public Vec3 add(Vec3 otherVec3) {
        return this.add(otherVec3.x, otherVec3.y, otherVec3.z);
    }

    public Vec3 add(double x, double y, double z) {
        return new Vec3(this.x + x, this.y + y, this.z + z);
    }

    public Vec3 multiply(Vec3 otherVec3) {
        return this.multiply(otherVec3.x, otherVec3.y, otherVec3.z);
    }

    public Vec3 multiply(double x, double y, double z) {
        return new Vec3(this.x * x, this.y * y, this.z * z);
    }

    public Vec3 multiply(double s) {
        return this.multiply(s, s, s);
    }

    //aligns the position to the top of a block (such as a guider)
    public Vec3 topAlign(Vec3 pos) {
        return new Vec3(pos.x, Math.floor(pos.y) + 1D - 0.98F, pos.z);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Vec3{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}

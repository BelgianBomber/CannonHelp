package logic;

import java.util.List;

public class Entity {
    double pos;
    double vel;
    int fuse;
    boolean tracked;
    int id;

    public Entity(double pos, double vel, int fuse, int id) {
        this.pos = pos;
        this.vel = vel;
        this.fuse = fuse;
        this.id = id;

        tracked = true;
    }
    public Entity(double pos, double vel, int fuse) {
        this.pos = pos;
        this.vel = vel;
        this.fuse = fuse;
    }

    public Entity(double pos, double vel) {
        this.pos = pos;
        this.vel = vel;
        this.fuse = 80;
    }

    public Entity(double pos) {
        this.pos = pos;
        this.vel = 0;
        this.fuse = 80;
    }

    public void applyMovement (){
        vel -= 0.04D;
        pos +=  vel;
        vel *= 0.98D;
    }

    public void explode (List<Entity> entityList){

        double explPos = this.pos + 0.98F * 0.0625D;                            //higher explosion point
        //System.out.println("Explosion at: " + explPos);

        for (Entity e : entityList){
            double distance = e.getPos() - explPos;                             //difference between explosion and entity

            if (Math.abs(distance) <= 8){                                       //check if it can be affected
                double efficiency = (double) 1 - (Math.abs(distance) / 8F);
                e.setVel(e.vel += efficiency * Math.signum(distance));          //see if it gets up or down velocity
            }
        }
    }

    public double getPos() {
        return pos;
    }

    public double getVel() {
        return vel;
    }

    public int getFuse() {
        return fuse;
    }

    public int getId() {
        return id;
    }

    public boolean isTracked() {
        return tracked;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }

    public void setVel(double vel) {
        this.vel = vel;
    }

    public void setFuse(int fuse) {
        this.fuse = fuse;
    }
}

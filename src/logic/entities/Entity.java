package logic.entities;

import logic.Vec3;

public class Entity {
    Vec3 pos;
    Vec3 vel;
    boolean onGround;

    int ticksUntillAffected = 0;
    int trackingId;
    boolean isTracked = false;


    //this will give the entity a bit of downwards velocity, update the position according to that velocity and then apply drag (2%) to the entity
    public void applyMovement() {
        vel = vel.add(0.0D, -0.04D, 0.0D);
        move();
        vel = vel.multiply(0.98D);

        if (onGround) vel.multiply(0.7D, -0.5D, 0.7D);
    }

    //needs a lot more code to check for moving while sliding on ground, moving into blocks etc.
    public void move() {
        pos = pos.add(vel);
    }

    public Vec3 getPos() {
        return pos;
    }

    public void setVel(Vec3 vel) {
        this.vel = vel;
    }

    public Vec3 getVel() {
        return vel;
    }

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public void setTracked(boolean tracked) {
        isTracked = tracked;
    }

    public boolean isTracked() {
        return isTracked;
    }

    public void reduceTicksUntillAffected() {
        this.ticksUntillAffected--;
    }
}

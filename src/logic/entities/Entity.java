package logic.entities;

import logic.blocks.Block;
import logic.blocks.BlockList;
import logic.core.Vec3;
import logic.core.Vec3i;

//This is the main shared code for all entities. At this point, we only use fallingBlock and TNT entities, therefor there isn't much code
public class Entity {
    Vec3 pos;
    Vec3 vel;
    boolean onGround;

    int ticksUntilAffected = 0;
    int trackingId;
    boolean isTracked = false;


    //this will give the entity a bit of downwards velocity, update the position according to that velocity and then apply drag (2%) to the entity
    public void applyMovement() {
        vel = vel.add(0.0D, -0.04D, 0.0D);
        move();
        vel = vel.multiply(0.98D);

        if (onGround) vel.multiply(0.7D, -0.5D, 0.7D);
    }

    //updates the position of the entity based on the velocity and blocks in the world
    public void move() {
        Vec3 nextPosition = pos.add(vel);




        pos = nextPosition;
    }

    public boolean isWithinBlock(){
        double x = pos.getX();
        double z = pos.getZ();

        if (0.49 > x || x > 0.51) return false;
        if (0.49 > z || z > 0.51) return false;
        return true;
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
        this.ticksUntilAffected--;
    }
}

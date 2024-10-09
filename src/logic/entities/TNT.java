package logic.entities;

import logic.core.Vec3;

public class TNT extends Entity {
    int fuse;

    public TNT(Vec3 pos, Vec3 vel, int fuse) {
        this.pos = pos;
        this.vel = vel;
        this.fuse = fuse;
    }

    //The "ticks until affected" means we can already store stuff in the entity list for the logic to ignore, simulating being shot from a later power
    public TNT(Vec3 pos, Vec3 vel, int fuse, int ticksUntilAffected) {
        this.pos = pos;
        this.vel = vel;
        this.fuse = fuse;
        this.ticksUntilAffected = ticksUntilAffected;
    }

    public void explode(EntityList el) {

        //get the position of the actual explosion
        Vec3 explPos = new Vec3(this.pos.getX(), this.pos.getY() + 0.98F * 0.0625D, this.pos.getZ());

        for (Entity e : el.getList()) {
            //get the distance between the explosion and the affected entity
            double xDiff = explPos.xDistance(e.getPos());
            double yDiff = explPos.yDistance(e.getPos());
            double zDiff = explPos.zDistance(e.getPos());
            double distance = explPos.distanceTo(e.getPos());

            //make sure the entity isn't too far away to be affected
            if (distance <= 8 && distance != 0) {
                //get the direction to the entity
                xDiff /= distance;
                yDiff /= distance;
                zDiff /= distance;

                double efficiency = (double) 1 - (Math.abs(distance) / 8F);

                e.setVel(new Vec3(e.getVel().getX() + xDiff * efficiency, e.getVel().getY() + yDiff * efficiency, e.getVel().getZ() + zDiff * efficiency));
            }
        }
    }


    public int getFuse() {
        return fuse;
    }

    public void setFuse(int fuse) {
        this.fuse = fuse;
    }
}

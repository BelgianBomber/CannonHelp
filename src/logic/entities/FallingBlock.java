package logic.entities;

import logic.Vec3;

public class FallingBlock extends Entity{
    public FallingBlock(Vec3 pos, Vec3 vel){
        this.pos = pos;
        this.vel = vel;
    }

    public FallingBlock(Vec3 pos, Vec3 vel, int ticksUntillAffected){
        this.pos = pos;
        this.vel = vel;
        this.ticksUntillAffected = ticksUntillAffected;
    }
}

package logic.entities;

import logic.core.Vec3;

//The fallingBlock entity is an entity 98% the size of a full block that is susceptible to gravity and explosions
public class FallingBlock extends Entity{
    public FallingBlock(Vec3 pos, Vec3 vel){
        this.pos = pos;
        this.vel = vel;
    }

    //The "ticks until affected" means we can already store stuff in the entity list for the logic to ignore, simulating being shot from a later power
    public FallingBlock(Vec3 pos, Vec3 vel, int ticksUntilAffected){
        this.pos = pos;
        this.vel = vel;
        this.ticksUntilAffected = ticksUntilAffected;
    }
}

package logic.blocks;

import logic.core.Vec3i;

public class Block {
    Vec3i pos; //Vec3i is a way to store 3 integers, in this case the x, y and z position.
    boolean isDestructible = true; //false when the block cannot be destroyed by explosions, such as bedrock
    boolean isFullBlock = true; //false when the block isn't a cubic metre in volume, such as a slab or a fencepost
    double blastResitance;

    public Block(){
    }

    public Block(Vec3i pos) {
        this.pos = pos;
    }

    public Block(Vec3i pos, boolean isDestructible, boolean isFullBlock) {
        this.pos = pos;
        this.isDestructible = isDestructible;
        this.isFullBlock = isFullBlock;
    }

    public Vec3i getPos() {
        return pos;
    }

    public boolean isDestructible() {
        return isDestructible;
    }

    public boolean isFullBlock() {
        return isFullBlock;
    }

    public void setPos(Vec3i pos) {
        this.pos = pos;
    }

    public void setDestructible(boolean destructible) {
        isDestructible = destructible;
    }

    public void setFullBlock(boolean fullBlock) {
        isFullBlock = fullBlock;
    }
}

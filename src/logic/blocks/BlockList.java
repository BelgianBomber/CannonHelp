package logic.blocks;

import logic.core.Vec3;
import logic.core.Vec3i;
import logic.entities.Entity;

import java.util.ArrayList;
import java.util.List;

//This class is very different with how minecraft handles blocks, but it should allow me to simulate sand stacking and unbreakable blocks.
public class BlockList {
    //This is going to store all the blocks that currently exist in our simulation.
    List<Block> blockList;

    public BlockList(){
        blockList = new ArrayList<>();
    }

    public void add(Block b){
        blockList.add(b);
    }

    public void tick(){
        //maybe falling block logic later idk yet
    }

    public Block firstHitY(Vec3 pos, Vec3 vel){
        //sets the next position to where the entity would be if there are no blocks in the way
        Vec3 nextPosition = pos.add(vel);

        //checks all blocks in the y axys for collissions (triangles)
        double startHeight = pos.getY();
        double direction = Math.signum(vel.getY()); //-1 means the entity is going down, +1 means the entity
        Block blockToCheck;

        //adding a little check to see if the entity will even move into a new block in the next gametick
        double heightWithinBlock = pos.getY()-Math.floor(pos.getY());
        if (direction < 0 && heightWithinBlock > Math.abs(vel.getY())) { //this is good, it means the entity will not collide with another block when moving down
            pos = nextPosition;
        } else if (direction < 0 && 1-heightWithinBlock > vel.getY()) { //this is also good, it means the entity will not collide with another block while moving up
            pos = nextPosition;
        }

        else{ //now we need to make sure the entity isn't spread along multiple blocks along the x or z coordinates. If that is the case, we need to check 2 or 4 blocks going down.
            if (getDecimalPortion(pos.getX()) < 0.489 || getDecimalPortion(pos.getX()) > 0.511){
                if (getDecimalPortion(pos.getZ()) < 0.489 || getDecimalPortion(pos.getZ()) > 0.511){

                }
            }
            

            for (int i = 0; i < Math.ceil(vel.getY()); i++){
                blockToCheck = new Block(new Vec3i((int)(pos.getX()), (int)(Math.floor(startHeight-1)), (int)(pos.getY())));
            }


        }

        //checks all blocks in the x or z axys for collissions, going the side with the largest velocity first (triangles)

        //een loop gebruiken om dezelfde code twee keer uit te voeren, maar op het einde van de eerste cyclus wordt een boolean veranderd waardoor de andere helft gerund wordt






        return blockToCheck;
    }

    public double getDecimalPortion(double number){
        return number - (long)number;
    }

}

package logic.level;

import logic.blocks.Block;
import logic.blocks.BlockList;
import logic.entities.Entity;
import logic.entities.EntityList;

// The level is a combination of things a cannon projectile might interact with, such as other entities and blocks
public class Level {
    EntityList el; //stores an entity list for each level
    BlockList bl; //stores a blocklist for each level
    Dimension d;

    public Level(Dimension dimension) {
        el = new EntityList();
        bl = new BlockList();
        d = dimension;
    }

    public EntityList getEl() {
        return el;
    }

    public BlockList getBl() {
        return bl;
    }

    public void addEntity(Entity e){
        el.add(e);
    }

    public void addBlock(Block b){
        bl.add(b);
    }

    public void tick(){
        el.tick();
        bl.tick();
    }

    public void tick(int amount){
        for (int i = 0; i < amount; i++){
            tick();
        }
    }
}

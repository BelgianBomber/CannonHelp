package logic.blocks;

import logic.core.Vec3i;

public class Sand extends Block{
    public Sand (Vec3i pos){
        isDestructible = true;
        isFullBlock = true;
        blastResitance = 0.5;
    }
}

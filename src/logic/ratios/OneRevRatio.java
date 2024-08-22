package logic.ratios;

import logic.Vec3;
import logic.entities.EntityList;
import logic.entities.FallingBlock;
import logic.entities.TNT;

public class OneRevRatio {
    Vec3 barrelHeight;
    int ticksBetweenPowers, revTicksFromFirstPower, hammerTicksFromFirstPower, sandAmount, hammerAmount;

    public OneRevRatio(Vec3 barrelHeight, int ticksBetweenPowers, int revTicksFromFirstPower, int hammerTicksFromFirstPower, int sandAmount, int hammerAmount){
        this.barrelHeight = barrelHeight;
        this.ticksBetweenPowers = ticksBetweenPowers;
        this.revTicksFromFirstPower = revTicksFromFirstPower;
        this.hammerTicksFromFirstPower = hammerTicksFromFirstPower;
        this.sandAmount = sandAmount;
        this.hammerAmount = hammerAmount;
    }

    public void addToEntityList(EntityList el){
        el.add(new TNT(barrelHeight, new Vec3(0),  revTicksFromFirstPower));

        for (int i = 0; i < hammerAmount; i++) {
            el.add(new TNT(barrelHeight, new Vec3(0), hammerTicksFromFirstPower - ticksBetweenPowers, ticksBetweenPowers));
        }

        for (int i = 0; i < sandAmount; i++) {
            el.add(new FallingBlock(barrelHeight, new Vec3(0)));
        }
    }

}

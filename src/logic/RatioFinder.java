package logic;


import logic.entities.EntityList;
import logic.entities.FallingBlock;
import logic.entities.TNT;
import logic.ratios.OneRevRatio;

public class RatioFinder {
    int amountOfPowers = 2, maxTicksBetweenPowers = 6, amountOfGuiders = 1;
    int maxRevTnt = 36;
    int minRange = 5, maxRange = 9, maxHammerTicksAfterRev = 5;

    int ticksPassed = 0;
    boolean useGUI;
    static Vec3 vec3 = new Vec3();
    Vec3 barrelHeight = vec3.topAlign(new Vec3(318));
    EntityList el = new EntityList();

    public RatioFinder(boolean useGUI){
        this.useGUI = useGUI;
    }

    public void oneRevRatio(){
        nineTen380oneRev();

        FallingBlock sand = new FallingBlock(barrelHeight, new Vec3(0));
        sand.setTracked(true);
        sand.setTrackingId(1);
        el.add(sand);

        FallingBlock sand2 = new FallingBlock(barrelHeight, new Vec3(0), 4);
        sand2.setTracked(true);
        sand2.setTrackingId(2);
        el.add(sand2);

        el.tick(15);
    }

    private void nineTen380oneRev(){
        OneRevRatio orr = new OneRevRatio(barrelHeight, 4, 9, 10, 382, 450);
        orr.addToEntityList(el);
    }
}

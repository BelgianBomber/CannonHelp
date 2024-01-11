package logic;

import java.util.List;

public class Ratio {
    int ticksBetweenPowers, revTicks, revTnt, hammerTicks, hammerAmount;
    boolean revFirstPower;
    double guiderHeight;

    //regular 1 rev ratio
    public Ratio(double guiderHeight, int ticksBetweenPowers, int revTicksFromFirstPower, boolean revFirstPower, int revTnt, int hammerTicksFromFirstPower, int hammerAmount) {
        this.guiderHeight = guiderHeight;
        this.ticksBetweenPowers = ticksBetweenPowers;
        this.revTicks = revTicksFromFirstPower;
        this.revFirstPower = revFirstPower;
        this.revTnt = revTnt;
        this.hammerTicks = hammerTicksFromFirstPower;
        this.hammerAmount = hammerAmount;

        intoList();
    }

    public Ratio(double guiderHeight, int ticksBetweenPowers, int revTicksFromFirstPower, int hammerTicksFromFirstPower, int hammerAmount) {
        new Ratio(guiderHeight, ticksBetweenPowers, revTicksFromFirstPower, true, 1, hammerTicksFromFirstPower, hammerAmount);
    }

    private void intoList() {
        EntityList entityList = new EntityList(this);

        //first power projectiles
        if (revFirstPower){
            for (int i = 0; i < revTnt; i++) {
                entityList.add(new Entity(guiderHeight, 0, revTicks));
            }
        }
        //entityList.add(new Entity(guiderHeight, 0, 20, 1));
        entityList.add(new Entity(guiderHeight, 0, 20, 100)); //first silent tracker
        entityList.sortList();

        entityList.tick(ticksBetweenPowers);

        //second power projectiles
        if (!revFirstPower){
            for (int i = 0; i < revTnt; i++) {
                entityList.add(new Entity(guiderHeight, 0, revTicks));
            }
        }
        for (int i = 0; i < hammerAmount; i++) {
            entityList.add(new Entity(guiderHeight, 0, hammerTicks - ticksBetweenPowers));
        }
        //entityList.add(new Entity(guiderHeight, 0, 20, 2));
        entityList.add(new Entity(guiderHeight, 0, 20, 101)); //second silent tracker
        entityList.sortList();
        entityList.tick(entityList.untilDone());
    }

    public boolean isViable(EntityList el, int passedTicks) {
        boolean viable = true;
        double pos1 = 0, pos2 = 0;

        for (Entity e : el.getList()) {
            if (e.getId() == 100) pos1 = e.getPos();
            if (e.getId() == 101) pos2 = e.getPos();
        }

        //get lowest
        double lowest = Math.min(pos1, pos2);
        double highest = Math.max(pos1, pos2);

        //check if sand is 1 block under guider
        if (lowest < Math.floor(guiderHeight) - 1) return false;
        //check if sand isn't too high up, otherwise cannon might clip with blocks above barrel
        if (lowest > Math.floor(guiderHeight) - 0.6) return false;
        //check distance between hammer and sand
        if (highest - lowest > 1.6) return false;
        if (highest - lowest < 0.9) return false;

        if (highest == 99.43576189452651) return false; //temp !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        System.out.println("highest: " + highest + "\nlowest: " + lowest);
        if (revFirstPower && revTnt <= 1)  System.out.println("0, " + ticksBetweenPowers + ", " + revTicks + " after " + passedTicks + "  ticks");
        else {
            String firstOrSecondPower = (revFirstPower) ? "first power":"second power";
            System.out.println("0, " + ticksBetweenPowers + ", " + revTicks + " after " + passedTicks + "  ticks with " + revTnt + " tnt on the " + firstOrSecondPower);
        }

        return viable;
    }

}

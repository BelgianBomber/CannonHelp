package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EntityList {

    List<Entity> entityList;
    int passedTicks;
    Ratio r;
    public EntityList(Ratio r) {
        entityList = new ArrayList<>();
        this.r = r;
    }

    public void add(Entity e) {
        entityList.add(e);
    }

    public void tick() {
        for (Entity e : entityList) {
            if (e.isTracked() && e.getId()!=100 && e.getId() != 101) System.out.printf( //100 and 101 are meant for finding ratios and not putting the coords in chat
                    "Tick: %-2s | ID: %-2s | Fuse: %-2s | Pos: %-19s | Vel: %s %n",
                    passedTicks, e.getId(), e.getFuse(), e.getPos(), e.getVel());
        }

        r.isViable( this, passedTicks);

        clearExploded();

        for (Entity e : entityList) {
            e.applyMovement();

            int f = e.getFuse() - 1;
            e.setFuse(f);

            if (f == 0) {
                e.explode(entityList);
            }
        }
        passedTicks++;
    }

    public void tick(int amount) {
        for (int i = 0; i < amount; i++) {
            tick();
        }
    }
    public void clearExploded(){
        entityList.removeIf(e -> e.getFuse() == 0);
    }

    public void sortList(){
        Collections.sort(entityList, Comparator.comparing(Entity::getFuse));
    }

    public int untilDone() {
        int longestFuse = 0;
        for (Entity e : entityList) {
            if (e.getFuse() > longestFuse) {
                longestFuse = e.getFuse();
            }
        }
        return longestFuse;
    }
    public List<Entity> getList() {
        return entityList;
    }
}

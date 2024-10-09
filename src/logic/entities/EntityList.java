package logic.entities;

import java.util.ArrayList;
import java.util.List;

//Minecraft stores all entities in a list which it iterates over every gametick. This code implements logic for that list.
public class EntityList {
    //this is going to store all the entities that are being processed in this script.
    List<Entity> entityList;
    int passedTicks;

    public EntityList(){
        entityList = new ArrayList<>();
    }

    public void tick(){
        for (Entity e : entityList){


            if (e.isTracked() && e.ticksUntilAffected ==0)
                System.out.printf("Tick: %-2s | ID: %-2s | Pos: %-20s | Vel: %s %n", passedTicks, e.getTrackingId(), e.getPos().getY(), e.getVel().getY());
        }

        clearExploded();

        for (Entity e : entityList){
            if (e.ticksUntilAffected ==0){
                e.applyMovement();
                if (e instanceof TNT){
                    int f = ((TNT) e).getFuse() - 1;
                    ((TNT) e).setFuse(f);

                    if (f==0)((TNT) e).explode(this);
                }
            }else e.reduceTicksUntillAffected();
        }
        passedTicks++;
    }

    //runs the tick method i amount of times
    public void tick(int amount){
        for (int i = 0; i < amount; i++){
            tick();
        }
    }

    //removes the exploded entity from the entity list
    public void clearExploded(){
        entityList.removeIf(e -> e instanceof TNT && ((TNT) e).getFuse()==0);
    }

    //adds an entity to the entity list
    public void add(Entity e){
        entityList.add(e);
    }

    //returns the list as an ArrayList of Entity Objects
    public List<Entity> getList(){
        return entityList;
    }




}

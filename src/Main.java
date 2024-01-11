import logic.Entity;
import logic.EntityList;
import logic.Ratio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    /*
    static double minY;
    static double maxY;
    */
    static int maxTicksBetweenPowers = 5; //max ticks in gameticks between powers
    static int minRange = 3; //range in gameticks
    static int maxRange = 12; //maximum range, anything over 7 gameticks will clip on long ranges
    static int maxHammerTicksAfterRev = 5;
    static int maxRevTnt = 36;

    public static void main(String[] args) {
        //new Ratio(topAlign(100), 4, 13, 18, 350);

        /*for (int ticksBetweenPowers = 1; ticksBetweenPowers <= maxTicksBetweenPowers; ticksBetweenPowers++) {
            for (int gameticksRange = minRange; gameticksRange <= maxRange; gameticksRange++) {
                new Ratio(topAlign(100), ticksBetweenPowers, ticksBetweenPowers + gameticksRange, ticksBetweenPowers + gameticksRange + maxHammerTicksAfter1Rev, 10);
            }
        }*/

        for (int ticksBetweenPowers = 1; ticksBetweenPowers <= maxTicksBetweenPowers; ticksBetweenPowers++) {
            for (int gameticksRange = minRange; gameticksRange <= maxRange; gameticksRange++) {
                for (int revTnt = 0; revTnt <= maxRevTnt; revTnt++){
                    new Ratio(topAlign(100), ticksBetweenPowers, ticksBetweenPowers + gameticksRange, true, revTnt, ticksBetweenPowers + gameticksRange + maxHammerTicksAfterRev, 10);
                    new Ratio(topAlign(100), ticksBetweenPowers, ticksBetweenPowers + gameticksRange, false, revTnt, ticksBetweenPowers + gameticksRange + maxHammerTicksAfterRev, 10);
                }
            }
        }

    }

    private static double topAlign(double pos) {
        return pos + 1D - 0.98F;
    }

    /*
    public static void checkInbetween(double pos, int gt, double vel){
        double decimal = pos - Math.floor(pos);
        if (decimal>minY && decimal<maxY) {
            System.out.println("gt: " + gt + "\npos: " + pos + "\nvel: " + vel + "\n");
        }
    }
    */

    /*
    private static void floatClip(double pos){
        System.out.println("Position: " + pos);
        for (double i = 0; i<320 ; i++){
            double startPos = i + pos;

            for (double j = -64; j<0; j++){
                double vec3 = j - startPos;
                double endPos = startPos + vec3;
                if (!(Math.floor(endPos)==endPos)){
                    System.out.println(i + " fuck!");
                    break;
                }
            }
        }
    }*/
}

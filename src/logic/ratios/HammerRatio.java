package logic.ratios;

public class HammerRatio {
    double guiderHeight;
    int ticksBetweenPowers, revTicks, revTnt, hammerTicks, hammerAmount;
    boolean revFirstPower;

    public HammerRatio(double guiderHeight, int ticksBetweenPowers, int revTicksFromFirstPower, boolean revFirstPower, int revTnt, int hammerTicksFromFirstPower, int hammerAmount){
        this.guiderHeight = guiderHeight;
        this.ticksBetweenPowers = ticksBetweenPowers;
        this.revTicks = revTicksFromFirstPower;
        this.revFirstPower = revFirstPower;
        this.revTnt = revTnt;
        this.hammerTicks = hammerTicksFromFirstPower;
        this.hammerAmount = hammerAmount;
    }
    public HammerRatio(double guiderHeight, int ticksBetweenPowers, int revTicksFromFirstPower, int hammerTicksFromFirstPower, int hammerAmount) {
        new HammerRatio(guiderHeight, ticksBetweenPowers, revTicksFromFirstPower, true, 1, hammerTicksFromFirstPower, hammerAmount);
    }



    
}

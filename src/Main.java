import logic.RatioFinder;
import render.DisplayPanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        boolean useGUI = false;

        if (useGUI){
            JFrame window = new JFrame ();
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            window.setResizable(false);
            window.setTitle("Cannon Simulator");

            DisplayPanel dp = new DisplayPanel();
            window.add(dp);

            window.pack();

            window.setLocationRelativeTo(null);
            window.setVisible(true);

            dp.startDisplayThread();
        }

        RatioFinder rf = new RatioFinder(useGUI);
        rf.oneRevRatio();

        /*
        PrimedTNT tnt = new PrimedTNT(vec3.topAlign(new Vec3(318)), new Vec3(0.0D), 5);
        FallingBlock sand = new FallingBlock(vec3.topAlign(new Vec3(318)), new Vec3(0.5D));
        for (int i = 0; i < 10; i++){
            System.out.println(tnt.getPos().getY());
            tnt.applyDrag();
            System.out.println(sand.getPos().getY());
            sand.applyDrag();
        }*/

        //System.out.println(3000.1D+5200.2D);
    }


}
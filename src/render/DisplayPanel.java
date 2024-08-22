package render;

import javax.swing.*;
import java.awt.*;

public class DisplayPanel extends JPanel implements Runnable {
    final int originalTileSize = 16; //in pixels
    final int scale = 3; //multiply tile size
    final int tileSize = originalTileSize * scale; //actual size of tile, in pixels
    final int maxScreenCol = 15; //max width of display in columns
    final int maxScreenRow = 20; //max height of display in rows

    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    final int fps = 20;
    Thread displayThread;

    int x = 0, y = 0;

    public DisplayPanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.GRAY);
        this.setDoubleBuffered(true);
    }

    public void startDisplayThread() {
        displayThread = new Thread(this);
        displayThread.start();
    }

    @Override
    public void run() {
        long drawInterval = (long) (1000 / fps); //get the amount of milliseconds per frame, at 20TPS this is 50ms
        long lastMillis = System.currentTimeMillis();
        long currentMillis, timePassed;

        while (displayThread != null) {
            currentMillis = System.currentTimeMillis();
            timePassed = currentMillis - lastMillis;
            if (timePassed <= drawInterval) {
                try {
                    Thread.sleep(drawInterval - timePassed);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            lastMillis = System.currentTimeMillis();


            //update all the information that has to go on the display
            update();

            //draw the screen with the new information
            repaint();


        }
    }

    public void update() {
        if (x == screenWidth - 1) {
            x = 0;
        } else x++;
        if (y == screenHeight - 1) {
            y = 0;
        } else y++;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        g2.fillRect(x, y, tileSize, tileSize);
        g2.dispose();
    }
}

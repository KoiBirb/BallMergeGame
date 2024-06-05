package Balls;

import Main.GamePanel;
import hsa2.GraphicsConsole;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperBall {
    public BufferedImage image;
    public int x, y, diameter, radius;
    public double vx, vy;
    public boolean isDropped;
    private long lastTime = System.currentTimeMillis();


    public SuperBall( int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius = diameter / 2;
        this.isDropped = false;
    }

    public void update() {
        if ((GamePanel.gc.getMouseButton(0)
                || GamePanel.gc.getMouseButton(2))
                && lastTime + 1000 < System.currentTimeMillis())
            isDropped = true;

        if (isDropped){
            // gravity
            vy += 1;

            vx *= 0.95;
            vy *= 0.95;

            x += (int) vx;
            y += (int) vy;

        } else
            x = GamePanel.gc.getMouseX() - diameter /2;

        if (x < 350) {
            x = 350;
            vx *= -0.90;
        }
        else if (x + diameter > 850) {
            x = 850 - diameter;
            vx *= -0.90;
        }

        else if (y + diameter >= 650) {
            if (Math.abs(vy) > 4) {
                y = 649 - diameter;
                vy *= -0.90;
            } else {
                y = 650 - diameter;
                vy = 0;
            }
        }
    }

    public void draw(GraphicsConsole gc) {
        gc.setColor(Color.ORANGE);
        gc.drawOval(x, y, diameter, diameter);
        gc.drawImage(image, x, y, diameter, diameter);
    }
}

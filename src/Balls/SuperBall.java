package Balls;

import Ballhandlers.Collisions;
import Main.GamePanel;
import hsa2.GraphicsConsole;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperBall {
    public BufferedImage image;
    public int x, y, diameter, radius;
    public double vx, vy, weight;
    public boolean isDropped, touchingWall;
    private long lastTime = System.currentTimeMillis();


    public SuperBall( int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius = diameter / 2;
        this.weight = diameter / 100.0;
        this.isDropped = false;
        this.touchingWall = false;
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

        Collisions.wallCollisions(this);
    }

    public void draw(GraphicsConsole gc) {
        gc.drawImage(image, x, y, diameter, diameter);
    }
}

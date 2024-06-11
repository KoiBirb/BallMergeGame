/*
 * SuperBall.java
 * Leo Bogaert
 * June 12, 2024
 * Parent class for all fruit objects
 * Contains the update and draw methods for the fruit objects
 */
package Balls;

import Ballhandlers.Collisions;
import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class SuperBall {
    public BufferedImage image;
    public int x,y, diameter, radius;
    public double vx, vy = 1, weight;
    public boolean isDropped;

    private final long lastTime = System.currentTimeMillis(); // Time object was created
    public long droppedTime = 0; // Time object was dropped

    /**
     * SuperBall constructor
     * @param x int position of the ball
     * @param y int position of the ball
     * @param diameter int size of the ball
     */
    public SuperBall(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.radius = diameter / 2;
        this.weight = diameter;
        this.isDropped = false;
    }

    /**
     * Updates the ball
     * Checks if the ball is dropped and updates the position
     */
    public void update() {
        if ((GamePanel.gc.getMouseButton(0)
                || GamePanel.gc.getMouseButton(2))
                && lastTime + 1000 < System.currentTimeMillis()) {
            isDropped = true;
            droppedTime = System.currentTimeMillis();
        }

        if (isDropped){

            // drag
            vx *= 0.95;
            vy *= 0.95;

            // gravity
            vy += 1;

            x += (int) Math.round(vx);
            y += (int) Math.round(vy);

        } else {

            // follow mouse at top of screen before drop
            x = GamePanel.gc.getMouseX() - diameter / 2;
            y = 150 - diameter;
        }
        Collisions.wallCollisions(this);
    }

    /**
     * Draws the ball
     */
    public void draw() {
        GamePanel.gc.drawImage(image, x, y, diameter, diameter);
    }

    /**
     * Sets the image of the ball
     * @param imagePath String path to the image
     */
    public void setImage(String imagePath) {
        try {
            this.image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
        } catch (Exception e) {
            System.out.println("Error loading image: " + imagePath);
        }
    }
}

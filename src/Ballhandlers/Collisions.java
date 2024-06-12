/*
 * Collisions.java
 * Leo Bogaert
 * June 12, 2024
 * This class contains methods that handle and detect collisions between balls and  walls
 */
package Ballhandlers;

import Balls.SuperBall;
import Main.GamePanel;
import Main.Main;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.*;

public class Collisions {

    /**
     * Checks if the balls are colliding by comparing distances
     * between them and the radi
     * @param b1 SuperBall object to be checked
     * @param b2 SuperBall object to be checked against
     * @return boolean true if objects are colliding
     */
    public static boolean checkCollision (SuperBall b1, SuperBall b2) {
        return distance(b1,b2) <= (b1.radius + b2.radius);
    }

    /**
     * Handles the collision between two balls
     * @param b1 SuperBall object being collided with
     * @param b2 SuperBall object to be collided
     */
    public static void handleCollisions (SuperBall b1, SuperBall b2) {

        // Correct the position of the balls if they are overlapping
        if (b2.radius > b1.radius) staticCollision(b1, b2);
        else staticCollision(b2, b1);

        int xDist = (b1.x + b1.radius) - (b2.x + b2.radius);
        int yDist = (b1.y + b1.radius) - (b2.y + b2.radius);
        double xVelDiff = b2.vx - b1.vx;
        double yVelDiff = b2.vy - b1.vy;

        double distSquared = xDist*xDist + yDist*yDist; // avoid square root
        double dotProduct = xDist * xVelDiff + yDist * yVelDiff;

        if (dotProduct > 0) { // Check if fruit are going towards eachother
            double colScale = dotProduct / distSquared;
            double xCol = xDist * colScale;
            double yCol = yDist * colScale;
            double combinedMass = b1.weight + b2.weight;
            double colWeightB1 = 2 * b2.weight / combinedMass;
            double colWeightB2 = 2 * b1.weight / combinedMass;

            b1.vx += colWeightB1 * xCol;
            b1.vy += colWeightB1 * yCol;
            b2.vx -= colWeightB2 * xCol;
            b2.vy -= colWeightB2 * yCol;
        }
    }

    /**
     * Finds and corrects the overlap between balls
     * @param b1 SuperBall object that is stationary
     * @param b2 SuperBall object that is to be corrected
     */
    public static void staticCollision(SuperBall b1, SuperBall b2) {
        double overlap = b1.radius + b2.radius - distance(b1, b2);

        double theta = Math.atan2(((b1.y + b1.radius) - (b2.y + b2.radius)), ((b1.x + b1.radius) - (b2.x + b2.radius)));
        b2.x -= (int) round(overlap * Math.cos(theta));
        b2.y -= (int) round(overlap * Math.sin(theta));
    }

    /**
     * Calculates the distance between two balls
     * @param b1 SuperBall object
     * @param b2 SuperBall object
     * @return double distance between the balls
     */
    public static double distance (SuperBall b1, SuperBall b2){
        return Math.sqrt(pow((b2.x+b2.radius) - (b1.x + b1.radius), 2) + pow((b2.y+b2.radius) - (b1.y + b1.radius), 2));
    }

    /**
     * Handles the collision between the ball and the walls
     * @param b SuperBall object to check for collision
     */
    public static void wallCollisions (SuperBall b) {
        boolean collide = false;
        if (b.x < 350) {
            b.x = 350;
            b.vx *= -0.90;
            collide = true;
        }
        else if (b.x + b.diameter > 850) {
            b.x = 850 - b.diameter;
            b.vx *= -0.90;
            collide = true;
        }
        if (b.y + b.diameter >= 650) {
            b.y = 650 - b.diameter;
            b.vy = 0;
            collide = true;
        }
        if (collide) {
            for (SuperBall b2 : GamePanel.fruits) {
                if (b2 != b && checkCollision(b, b2)) {
                    staticCollision(b, b2);
                    b.vx = 0;
                }
            }
        }
    }

    /**
     * Checks if the ball is out of bounds
     * @param b SuperBall object to check
     */
    public static void checkLost(SuperBall b) {
        long currentTime = System.currentTimeMillis();
        if (b.y < 150 && b.isDropped &&(currentTime - b.droppedTime) >= 1500) {
            Main.mh.playEndSoundEffect();
            GamePanel.fruits.clear();
            Main.gameState = 2;
        }
    }
}

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

import static java.lang.Math.*;

public class Collisions {

    public static boolean checkCollision (SuperBall b1, SuperBall b2) {
        return distance(b1,b2) <= (b1.radius + b2.radius);
    }

    public static void handleCollisions (SuperBall b1, SuperBall b2) {

        if (b2.radius > b1.radius)
            staticCollision(b1, b2, false);
        else
            staticCollision(b2, b1, false);


        int xDist = b1.x - b2.x;
        int yDist = b1.y - b2.y;
        double distSquared = xDist*xDist + yDist*yDist;
        //Check the squared distances instead of the the distances, same result, but avoids a square root.
        double xVelocity = b2.vx - b1.vx;
        double yVelocity = b2.vy - b1.vy;
        double dotProduct = xDist * xVelocity + yDist * yVelocity;
        //Neat vector maths, used for checking if the objects moves towards one another.
        if (dotProduct > 0) {
            double collisionScale = dotProduct / distSquared;
            double xCollision = xDist * collisionScale;
            double yCollision = yDist * collisionScale;
            //The Collision vector is the speed difference projected on the Dist vector,
            //thus it is the component of the speed difference needed for the collision.
            double combinedMass = b1.weight + b2.weight;
            double collisionWeightA = 2 * b2.weight / combinedMass;
            double collisionWeightB = 2 * b1.weight / combinedMass;
            b1.vx += collisionWeightA * xCollision;
            b1.vy += collisionWeightA * yCollision;
            b2.vx -= collisionWeightB * xCollision;
            b2.vy -= collisionWeightB * yCollision;
        }
    }

    public static void staticCollision(SuperBall b1, SuperBall b2, boolean emergency) {
        double overlap = b1.radius + b2.radius - distance(b1, b2);

        SuperBall smallerObject = b2;
        SuperBall biggerObject = b1;

        if (emergency) {
            biggerObject = b2;
            smallerObject = b1;
        }

        double theta = Math.atan2((biggerObject.y - smallerObject.y), (biggerObject.x - smallerObject.x));
        smallerObject.x -= (int) round(overlap * Math.cos(theta));
        smallerObject.y -= (int) round(overlap * Math.sin(theta));
    }

    public static double distance (SuperBall b1, SuperBall b2){
        return Math.sqrt(pow((b2.x+b2.radius) - (b1.x + b1.radius), 2) + pow((b2.y+b2.radius) - (b1.y + b1.radius), 2));
    }

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
                    staticCollision(b, b2, false);
                    b.vx = 0;
                }
            }
        }
    }

    public static void checkLost(SuperBall b) {
        if (b.y < 150 && b.vx <= 0) {
            Main.gameState = 2;
        }
    }
}

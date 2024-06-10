package Ballhandlers;

import Balls.SuperBall;
import Main.GamePanel;

import static java.lang.Math.*;
import static java.lang.Math.cos;

public class Collisions {

    public static boolean checkCollision (SuperBall b1, SuperBall b2) {
        return distance(b1,b2) <= (b1.radius + b2.radius);
    }

    public static void handleCollisions (SuperBall b1, SuperBall b2) {

        if (b1.radius > b2.radius)
            staticCollision(b1, b2, false);
        else
            staticCollision(b2, b1, false);

        int b1x = b1.x + b1.radius;

        int b2x = b2.x + b2.radius;
        int b2y = b2.y + b2.radius;

        double dx = b2x - b1x;
        double dy = b2y - b1x;

        if (checkCollision(b1, b2)) {
            double angle = atan2(dy, dx);
            double sin = sin(angle), cos = cos(angle);

            // rotate velocity
            double vx1 = b1.vx * cos + b1.vy * sin;
            double vy1 = b1.vy * cos - b1.vx * sin;
            double vx2 = b2.vx * cos + b2.vy * sin;
            double vy2 = b2.vy * cos - b2.vx * sin;

            // resolve the 1D case
            double vx1final = ((b1.weight - b2.weight) * vx1 + 2 * b2.weight * vx2) / (b1.weight + b2.weight);
            double vx2final = ((b2.weight - b1.weight) * vx2 + 2 * b1.weight * vx1) / (b1.weight + b2.weight);

            vx1 = vx1final;
            vx2 = vx2final;

            //rotate vel back

            if (!b1.stopped) {
                b1.vx = vx1 * cos - vy1 * sin;
                b1.vy = vy1 * cos + vx1 * sin;
            }
            if (!b2.stopped) {
                b2.vx = vx2 * cos - vy2 * sin;
                b2.vy = vy2 * cos + vx2 * sin;
            }
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
            checkCollision(b);
        }
    }

    public static void checkCollision(SuperBall b) {
        for (SuperBall b2 : GamePanel.fruits) {
            if (b2 != b && checkCollision(b, b2)) {
                staticCollision(b, b2, false);
            }
        }
    }
    public static boolean lose = false;
    public static void outOfBounds(SuperBall b) {
        if (b.y < 150 && b.vx < 0) {
            lose = true;
        }


    }
}

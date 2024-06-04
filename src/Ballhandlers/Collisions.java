package Ballhandlers;

import Balls.SuperBall;

import static java.lang.Math.*;
import static java.lang.Math.cos;

public class Collisions {

    public static boolean checkCollision (SuperBall b1, SuperBall b2) {
        return Math.sqrt(pow((b2.x+b2.radius) - b1.x, 2) + pow((b2.y+b2.radius) - b1.y, 2)) <= (b1.radius + b2.radius);
    }

    public static void handleCollisions (SuperBall b1, SuperBall b2) {

        int dx = b2.x - b1.x;
        int dy = b2.y - b1.y;

        double angle = atan2(dy,dx);
        double sin = sin(angle), cos = cos(angle);

        // rotate velocity
        double vx1 = b1.vx*cos+b1.vy*sin;
        double vy2 = b2.vy*cos-b2.vx*sin;
        double vx2 = ((b2.radius-b1.radius)*(b2.vx*cos+b2.vy*sin)+2*b1.radius*vx1)/(b1.radius+b2.radius);

        if (b2.y < b1.y) {
            b2.vy = (vy2*cos+vx2*sin) * -1;
        } else {
            b2.vy = vy2*cos+vx2*sin;
        }

        if (b2.x < b1.x) {
            b2.vx = (vx2*cos-vy2*sin) * -1;
        } else {
            b2.vx = vx2*cos-vy2*sin;
        }
    }
}

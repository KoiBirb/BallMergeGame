package Ballhandlers;

import Balls.SuperBall;

import static java.lang.Math.*;
import static java.lang.Math.cos;

public class Collisions {

    public static boolean checkCollision (SuperBall b1, SuperBall b2) {
        return Math.abs(Math.sqrt(pow((b2.x+b2.radius) - (b1.x + b1.radius), 2) + pow((b2.y+b2.radius) - (b1.y + b1.radius), 2))) <= Math.abs((b1.radius + b2.radius));
    }

    public static void handleCollisions (SuperBall b1, SuperBall b2) {

        int b1x = b1.x + b1.radius;
        int b1y = b1.y + b1.radius;

        int b2x = b2.x + b2.radius;
        int b2y = b2.y + b2.radius;

        double dx = b2x - b1x;
        double dy = b2y - b1x;

        if (checkCollision(b1, b2)) {
            double angle = atan2(dy, dx);
            double sin = sin(angle), cos = cos(angle);

            double x1 = 0, y1 = 0;
            double x2 = dx * cos + dy * sin;
            double y2 = dy * cos - dx * sin;

            // rotate velocity
            double vx1 = b1.vx * cos + b1.vy * sin;
            double vy1 = b1.vy * cos - b1.vx * sin;
            double vx2 = b2.vx * cos + b2.vy * sin;
            double vy2 = b2.vy * cos - b2.vx * sin;

            // resolve the 1D case
            double vx1final = ((b1.radius/100.0 - b2.radius/100.0) * vx1 + 2 * b2.radius/100.0 * vx2) / (b1.radius/100.0 + b2.radius/100.0);
            double vx2final = ((b2.radius/100.0 - b1.radius/100.0) * vx2 + 2 * b1.radius/100.0 * vx1) / (b1.radius/100.0 + b2.radius/100.0);

            vx1 = vx1final;
            vx2 = vx2final;

            // fix the glitch by moving ball part equal to the overlap
            // see video for more details(https://youtu.be/guWIF87CmBg)

            double absV = abs(vx1) + abs(vx2);
            double overlap = (b1.radius + b2.radius) - abs(x1 - x2);
            x1 += vx1 / absV * overlap;
            x2 += vx2 / absV * overlap;

            // rotate the relative positions back
            double x1final = x1 * cos - y1 * sin;
            double y1final = y1 * cos + x1 * sin;
            double x2final = x2 * cos - y2 * sin;
            double y2final = y2 * cos + x2 * sin;


            // finally compute the new absolute positions
            b2.x = (int) (b1x + x2final);
            b2.y = (int) (b1y + y2final);

            b1.x = (int) (b1x + x1final);
            b1.y = (int) (b1y + y1final);

            //rotate vel back
            b1.vx = vx1 * cos - vy1 * sin;
            b1.vy = vy1 * cos + vx1 * sin;
            b2.vx = vx2 * cos - vy2 * sin;
            b2.vy = vy2 * cos + vx2 * sin;

        }
    }
}

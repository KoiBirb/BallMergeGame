package Ballhandlers;

import Balls.SuperBall;

import static java.lang.Math.pow;

public class CollisionHandler {

    public static boolean checkCollision (SuperBall b1, SuperBall b2) {
        return Math.sqrt(pow((b2.x+b2.radius) - b1.x, 2) + pow((b2.y+b2.radius) - b1.y, 2)) <= (b1.radius + b2.radius);
    }
}

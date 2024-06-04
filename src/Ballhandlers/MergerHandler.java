package Ballhandlers;

import Balls.SuperBall;

import java.util.ArrayList;

public class MergerHandler {

    private ArrayList<SuperBall> balls;

    public void mergeBalls(ArrayList<SuperBall> balls) {
        this.balls = balls;
    }

    public void merge() {
        for (int i = 0; i < balls.size(); i++) {
            for (int j = i + 1; j < balls.size(); j++) {
                if (CollisionHandler.checkCollision(balls.get(i), balls.get(j))) {
                    if (balls.get(i).radius == balls.get(j).radius) {
                        balls.get(i).x += balls.get(j).radius;
                        balls.remove(j);
                        j--;
                    }
                }
            }
        }
    }
}

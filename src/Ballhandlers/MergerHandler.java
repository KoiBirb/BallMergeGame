/*
 * MergerHandler.java
 * Leo Bogaert
 * June 12, 2024
 * Handles merges and calls collision methods between balls
 */
package Ballhandlers;

import Balls.*;
import GUI.ScoreBoard;
import Main.GamePanel;

public class MergerHandler {

    /**
     * Merges balls of the same size to the next tier of fruit
     * Checks for collisions and calls handler
     */
    public void merge() {
        for (int i = 0; i < GamePanel.fruits.size(); i++) {
            SuperBall b1 = GamePanel.fruits.get(i);
            if (b1.isDropped) {
                
                for (int j = i + 1; j < GamePanel.fruits.size(); j++) {
                    SuperBall b2 = GamePanel.fruits.get(j);
                    if (b2.isDropped) {

                        if (Collisions.checkCollision(b1, b2)) {
                            Collisions.handleCollisions(b1, b2);
                            if (b1.radius == b2.radius) {
                                GamePanel.fruits.set(i, findNextBall((GamePanel.fruits.get(i).x + GamePanel.fruits.get(j).x + GamePanel.fruits.get(j).diameter) / 2,
                                        GamePanel.fruits.get(i).y, GamePanel.fruits.get(i).diameter));
                                GamePanel.fruits.get(i).isDropped = true;
                                GamePanel.fruits.remove(j);
                                j--;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Finds the next ball in the tier
     * @param x int position of the ball
     * @param y int position of the ball
     * @param diameter int size of the ball that needs to be merged
     * @return SuperBall object of the next ball in the tier
     */
    private SuperBall findNextBall (int x, int y, int diameter) {

        switch (diameter){
            case Cherry.DIAMETER:
                // finding middle position to place ball
                x = x - Strawberry.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Strawberry.DIAMETER > 850) ? 850 - Strawberry.DIAMETER : x;
                ScoreBoard.score += 10;
                return new Strawberry(x, y);
            case Strawberry.DIAMETER:
                x = x - Grape.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Grape.DIAMETER > 850) ? 850 - Grape.DIAMETER : x;
                ScoreBoard.score += 3;
                return new Grape(x, y);
            case Grape.DIAMETER:
                x = x - Lemon.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Lemon.DIAMETER > 850) ? 850 - Lemon.DIAMETER : x;
                ScoreBoard.score += 60;
                return new Lemon(x, y);
            case Lemon.DIAMETER:
                x = x - Orange.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Orange.DIAMETER > 850) ? 850 - Orange.DIAMETER : x;
                ScoreBoard.score += 100;
                return new Orange(x, y);
            case Orange.DIAMETER:
                x = x - Apple.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Apple.DIAMETER > 850) ? 850 - Apple.DIAMETER : x;
                ScoreBoard.score += 150;
                return new Apple(x, y);
            case Apple.DIAMETER:
                x = x - Pear.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Pear.DIAMETER > 850) ? 850 - Pear.DIAMETER : x;
                ScoreBoard.score += 210;
                return new Pear(x, y);
            case Pear.DIAMETER:
                x = x - Watermelon.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Watermelon.DIAMETER > 850) ? 850 - Watermelon.DIAMETER : x;
                ScoreBoard.score += 300;
                return new Watermelon(x, y);
            case Watermelon.DIAMETER:
                x = x - Cherry.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Cherry.DIAMETER > 850) ? 850 - Cherry.DIAMETER : x;
                ScoreBoard.score += 600;
                return new Cherry(x, y);
        }
        return null;
    }
}

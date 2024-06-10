package Ballhandlers;

import Balls.*;
import GUI.ScoreBoard;
import Main.GamePanel;

public class MergerHandler {

    /**
     * Merges balls of the same size to the next tier of fruit
     */
    public void merge() {
        for (int i = 0; i < GamePanel.fruits.size(); i++) {
            if (GamePanel.fruits.get(i).isDropped) {
                for (int j = i + 1; j < GamePanel.fruits.size(); j++) {
                    if (GamePanel.fruits.get(j).isDropped) {
                        if (Collisions.checkCollision(GamePanel.fruits.get(i), GamePanel.fruits.get(j))) {
                            Collisions.handleCollisions(GamePanel.fruits.get(i), GamePanel.fruits.get(j));
                            if (GamePanel.fruits.get(i).radius == GamePanel.fruits.get(j).radius) {
                                GamePanel.fruits.set(i, findNextBall((GamePanel.fruits.get(i).x + GamePanel.fruits.get(j).x + GamePanel.fruits.get(j).diameter)/2,
                                        GamePanel.fruits.get(i).y, GamePanel.fruits.get(i).diameter));
                                if (GamePanel.fruits.get(i) == null) {
                                    GamePanel.fruits.remove(i);
                                } else {
                                    GamePanel.fruits.get(i).isDropped = true;
                                    GamePanel.fruits.remove(j);
                                }
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
                x = x - Strawberry.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Strawberry.DIAMETER > 850) ? 850 - Strawberry.DIAMETER : x;
                ScoreBoard.score += 1;
                System.out.println(ScoreBoard.score);
                return new Strawberry(x, y);
            case Strawberry.DIAMETER:
                x = x - Grape.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Grape.DIAMETER > 850) ? 850 - Grape.DIAMETER : x;
                ScoreBoard.score += 3;
                return new Grape(x, y);
            case Grape.DIAMETER:
                x = x - Lemon.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Lemon.DIAMETER > 850) ? 850 - Lemon.DIAMETER : x;
                ScoreBoard.score += 6;
                return new Lemon(x, y);
            case Lemon.DIAMETER:
                x = x - Orange.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Orange.DIAMETER > 850) ? 850 - Orange.DIAMETER : x;
                ScoreBoard.score += 10;
                return new Orange(x, y);
            case Orange.DIAMETER:
                x = x - Apple.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Apple.DIAMETER > 850) ? 850 - Apple.DIAMETER : x;
                ScoreBoard.score += 15;
                return new Apple(x, y);
            case Apple.DIAMETER:
                x = x - Pear.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Pear.DIAMETER > 850) ? 850 - Pear.DIAMETER : x;
                ScoreBoard.score += 21;
                return new Pear(x, y);
            case Pear.DIAMETER:
                x = x - Watermelon.DIAMETER/2;
                x = (x < 350) ? 350 : (x + Watermelon.DIAMETER > 850) ? 850 - Watermelon.DIAMETER : x;
                ScoreBoard.score += 30;
                return new Watermelon(x, y);
            case Watermelon.DIAMETER:
                ScoreBoard.score += 60;
                return null;
        }
        return null;
    }
}

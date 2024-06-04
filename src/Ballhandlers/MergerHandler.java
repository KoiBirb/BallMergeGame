package Ballhandlers;

import Balls.*;
import Main.GamePanel;

public class MergerHandler {

    public void merge() {
        for (int i = 0; i < GamePanel.fruits.size(); i++) {
            for (int j = i + 1; j < GamePanel.fruits.size(); j++) {
                if (CollisionHandler.checkCollision(GamePanel.fruits.get(i), GamePanel.fruits.get(j))) {
                    if (GamePanel.fruits.get(i).radius == GamePanel.fruits.get(j).radius) {
                        GamePanel.fruits.set(i, findNextBall(GamePanel.fruits.get(i).x + GamePanel.fruits.get(j).radius,
                                GamePanel.fruits.get(i).y, GamePanel.fruits.get(i).diameter));
                        GamePanel.fruits.get(i).isDropped = true;
                        GamePanel.fruits.remove(j);
                        j--;
                    }
                }
            }
        }
    }

    private SuperBall findNextBall (int x, int y, int diameter) {

        if (x > 850 - diameter)
            x = 850 - diameter*2;
        else if (x < 350)
            x = 350 + diameter*2;


        switch (diameter){
            case 20:
                return new Strawberry(x, y);
            case 40:
                return new Grape(x, y);
            case 60:
                return new Lemon(x, y);
            case 80:
                return new Orange(x, y);
            case 100:
                return new Apple(x, y);
            case 120:
                return new Pear(x, y);
            case 140:
                return new Watermelon(x, y);
            case 160:
                return null;
        }
        return null;
    }
}

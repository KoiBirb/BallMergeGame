package Ballhandlers;

import Balls.*;
import Main.GamePanel;
import java.util.Random;

public class Spawner {
    private final Random random = new Random();

    public Spawner() {
        spawnBall();
    }

    public void update() {
        if (GamePanel.fruits.get(GamePanel.fruits.size() - 1).isDropped){
            spawnBall();
        }
    }

    public void draw() {

    }

    public void spawnBall() {
        int randNum = random.nextInt(5) + 1;
        switch (randNum) {
            case 1:
                GamePanel.fruits.add(new Cherry(GamePanel.gc.getMouseX(), 50));
                break;
            case 2:
                GamePanel.fruits.add(new Strawberry(GamePanel.gc.getMouseX(), 50));
                break;
            case 3:
                GamePanel.fruits.add(new Grape(GamePanel.gc.getMouseX(), 50));
                break;
            case 4:
                GamePanel.fruits.add(new Lemon(GamePanel.gc.getMouseX(), 50));
                break;
            case 5:
                GamePanel.fruits.add(new Orange(0, 0));
                break;
        }
    }
}

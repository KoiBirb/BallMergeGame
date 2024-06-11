/*
 * Spawner.java
 * Leo Bogaert
 * June 12, 2024
 * Spawns fruit to be dropped
 */
package Ballhandlers;

import Balls.*;
import Main.GamePanel;
import java.util.Random;

public class Spawner {
    private final Random random = new Random();

    /**
     * Updates the spawner and checks if a new ball needs to be spawned
     */
    public void update() {
        try {
            // check if last fruit has been dropped
            if (GamePanel.fruits.get(GamePanel.fruits.size() - 1).isDropped) {
                spawnBall();
            }
        } catch (IndexOutOfBoundsException e) {
            spawnBall();
        }
    }

    /**
     * Spawns a random new fruit
     */
    public void spawnBall() {
        int randNum = random.nextInt(5) + 1;
        switch (randNum) {
            case 1:
                GamePanel.fruits.add(new Cherry(GamePanel.gc.getMouseX(), 150 - Cherry.DIAMETER));
                break;
            case 2:
                GamePanel.fruits.add(new Strawberry(GamePanel.gc.getMouseX(), 150 - Strawberry.DIAMETER));
                break;
            case 3:
                GamePanel.fruits.add(new Grape(GamePanel.gc.getMouseX(), 150 - Grape.DIAMETER));
                break;
            case 4:
                GamePanel.fruits.add(new Lemon(GamePanel.gc.getMouseX(), 150 - Lemon.DIAMETER));
                break;
            case 5:
                GamePanel.fruits.add(new Orange(GamePanel.gc.getMouseX(), 150 - Orange.DIAMETER));
                break;
        }
    }
}

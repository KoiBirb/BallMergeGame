/*
 * Spawner.java
 * Leo Bogaert
 * June 12, 2024
 * Spawns fruit to be dropped
 */
package Ballhandlers;

import Balls.*;
import Main.GamePanel;

import java.awt.*;
import java.util.Random;

public class Spawner {
    private final Random random = new Random();
    private final Color transparentWhite = new Color(255, 255, 255, 40);
    private int futureBall = 1;

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
     * Draws next fruit based on the previous ball
     */
    public void draw(){
        SuperBall fruit;

        GamePanel.gc.drawOval(950, 40, 150, 150);
        GamePanel.gc.setColor(transparentWhite);
        GamePanel.gc.fillOval(950, 40, 150, 150);
        GamePanel.gc.setColor(Color.white);

        fruit = switch (futureBall) {
            case 2 -> new Strawberry(1025 - Strawberry.DIAMETER/2, 115 - Strawberry.DIAMETER/2);
            case 3 -> new Grape(1025 - Grape.DIAMETER/2, 115 - Grape.DIAMETER/2);
            case 4 -> new Lemon(1025 - Lemon.DIAMETER/2, 115 - Lemon.DIAMETER/2);
            case 5 -> new Orange(1025 - Orange.DIAMETER/2, 115 - Orange.DIAMETER/2);
            default -> new Cherry(1025 - Cherry.DIAMETER/2, 115 - Cherry.DIAMETER/2);
        };
        fruit.draw();
    }

    /**
     * Spawns a random new fruit
     */
    private void spawnBall() {

        int currentBall = futureBall;
        futureBall = random.nextInt(5) + 1;

        switch (currentBall) {
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

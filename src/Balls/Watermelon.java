/*
 * Watermelon.java
 * Leo Bogaert
 * June 12, 2024
 * Watermelon object
 */
package Balls;

public class Watermelon extends SuperBall {

    public static final int DIAMETER = 320;

    /**
     * Watermelon constructor
     * @param x int position of the watermelon
     * @param y int position of the watermelon
     */
    public Watermelon(int x, int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/watermelon.png");
    }
}

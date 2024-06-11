/*
 * Lemon.java
 * Leo Bogaert
 * June 12, 2024
 * Lemon object
 */
package Balls;

public class Lemon extends SuperBall{

    public static final int DIAMETER = 90;

    /**
     * Lemon constructor
     * @param x int position of the lemon
     * @param y int position of the lemon
     */
    public Lemon(int x, int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/lemon.png");
    }
}

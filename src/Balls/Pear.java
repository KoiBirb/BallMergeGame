/*
 * Pear.java
 * Leo Bogaert
 * June 12, 2024
 * Pear object
 */
package Balls;

public class Pear extends SuperBall{

    public static final int DIAMETER = 240;

    /**
     * Pear constructor
     * @param x int position of the pear
     * @param y int position of the pear
     */
    public Pear(int x, int y) {
        super(x, y, DIAMETER);
        setImage("/Assets/Fruit/pear.png");
    }
}
